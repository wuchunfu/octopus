package org.metahut.octopus.jobs.job;

import org.metahut.octopus.jobs.common.FlowData;
import org.metahut.octopus.jobs.common.FlowInstance;
import org.metahut.octopus.jobs.common.MetricMessage;
import org.metahut.octopus.jobs.common.MetricResult;
import org.metahut.octopus.jobs.common.RuleInstance;
import org.metahut.octopus.jobs.util.HttpUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.connector.pulsar.sink.PulsarSink;
import org.apache.flink.connector.pulsar.sink.writer.serializer.PulsarSerializationSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.table.catalog.hive.HiveCatalog;
import org.apache.flink.table.functions.UserDefinedFunction;
import org.apache.flink.table.module.hive.HiveModule;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class OfflineHiveMetrics {
    private static StreamTableEnvironment tableEnvironment;
    private static final String serviceUrl = "pulsar://pulsar-idc-qa.zpidc.com:6650";
    private static final String adminUrl = "http://pulsar-idc-qa.zpidc.com:8080";
    private static final String topic = "persistent://data/uu/octopus.metrics.result";

    private static volatile Map<String, String> metaSchemasMap = new ConcurrentHashMap<>();
    private static volatile JSONObject sampleInstanceJson = null;
    private static volatile Map<MetricMessage, List<RuleInstance>> ruleInstancesMap = new ConcurrentHashMap<>();
    private static volatile String tableName = null;

    public static void main(String[] args) throws Exception {

        EnvironmentSettings settings = EnvironmentSettings.newInstance()
                .inBatchMode()
                .build();
        // tableEnvironment = TableEnvironment.create(settings);

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        tableEnvironment = StreamTableEnvironment.create(env, settings);

        Configuration configuration = tableEnvironment.getConfig().getConfiguration();
        configuration.setString("table.exec.spill-compression.block-size", "262144 kb");
        configuration.setString("table.optimizer.join-reorder-enabled", "true");
        configuration.setString("table.optimizer.join.broadcast-threshold", "10485760");
        configuration.setString("table.optimizer.agg-phase-strategy", "TWO_PHASE"); // enable two-phase, i.e. local-global aggregation

        // register catalog
        HiveCatalog hiveCatalog = new HiveCatalog("myhive", "default", "./octopus-jobs/src/main/resources/", "3.1.0");
        // HiveCatalog hiveCatalog = new HiveCatalog("myhive", "dmm", "/data/online/octopus-jobs/flink/conf", "3.1.0");
        tableEnvironment.registerCatalog("myhive", hiveCatalog);
        tableEnvironment.loadModule("myhive", new HiveModule("3.1.0"));

        //register udf
        registerUdf("insert_metrics_clickhouse", "org.metahut.octopus.jobs.udf.InsertMetricsToClickhouse");

        String flowResponse = HttpUtils.get("https://qinglong-pre.dev.zhaopin.com/quality/monitorFlowDefinition/5782139932320");
        ObjectMapper objectMapper = new ObjectMapper();
        FlowInstance flowInstance = objectMapper.readValue(flowResponse, FlowInstance.class);

        //get meta info
        FlowData flowData = flowInstance.getData();
        JSONObject metaJsonObject = flowData.getMeta();
        tableName = metaJsonObject.getString("name");
        String datasourceCode = metaJsonObject.getJSONObject("datasource").getString("code");
        String datasetCode = metaJsonObject.getString("code");
        JSONArray schemasJsonArray = metaJsonObject.getJSONArray("schemas");
        for (int i = 0; i < schemasJsonArray.size(); i++) {
            JSONObject jsonObject = schemasJsonArray.getJSONObject(i);
            metaSchemasMap.put(jsonObject.getString("code"), jsonObject.getString("name"));
        }

        //get sampleInstance info
        sampleInstanceJson = flowData.getSampleInstance();
        Integer number = sampleInstanceJson.getInteger("number");
        //String viewSamplesPre = "select feature_name from myhive.dmm.fdm_cv_feature_day TABLESAMPLE ({0} PERCENT)";
        String viewSamplesPre = "select\n"
                + "age\n"
                //"feature_name\n" +
                + "from\n"
                + "myhive.{0}\n"
                //"myhive.dmm.fdm_cv_feature_day\n" +
                + "order by rand()\n"
                + "limit {1}";
        //        String viewSamplesPre = "select * from myhive.{0} TABLESAMPLE ({1} PERCENT)";
        String viewSamples = MessageFormat.format(viewSamplesPre, tableName, number);

        //get ruleInstances info
        JSONArray ruleInstancesJsonArray = flowData.getRuleInstances();
        for (int i = 0; i < ruleInstancesJsonArray.size(); i++) {
            MetricMessage metricMessage = new MetricMessage();
            JSONObject jsonObject = ruleInstancesJsonArray.getJSONObject(i);
            metricMessage.setId(UUID.randomUUID().toString());
            metricMessage.setDatasourceCode(datasourceCode);
            metricMessage.setDatasetCode(datasetCode);
            metricMessage.setSubjectCode(jsonObject.getString("subjectCode"));
            metricMessage.setSubjectCategory(jsonObject.getString("subjectCategory"));
            metricMessage.setMetricsCode(jsonObject.getJSONObject("metrics").getString("code"));
            metricMessage.setMetricsConfigCode(jsonObject.getJSONObject("metricsConfig").getLong("code"));
            // metricMessage.setExecutorScript(jsonObject.getJSONObject("metricsConfig").getString("executorScript"));
            metricMessage.setMetricsUniqueKey(jsonObject.getString("metricsUniqueKey"));

            RuleInstance ruleInstance = new RuleInstance();
            ruleInstance.setRuleInstanceCode(jsonObject.getLong("code"));
            ruleInstance.setCheckType(jsonObject.getString("checkType"));
            ruleInstance.setCheckMethod(jsonObject.getString("checkMethod"));
            ruleInstance.setComparisonUnit(jsonObject.getString("comparisonUnit"));
            ruleInstance.setComparisonMethod(jsonObject.getString("comparisonMethod"));
            ruleInstance.setExpectedValue((List<String>)jsonObject.get("expectedValue"));

            List<RuleInstance> ruleInstanceList = ruleInstancesMap.get(metricMessage);
            if (ruleInstanceList == null) {
                ArrayList<RuleInstance> ruleInstances = new ArrayList<>();
                ruleInstances.add(ruleInstance);
                ruleInstancesMap.put(metricMessage, ruleInstances);
            } else {
                ruleInstanceList.add(ruleInstance);
                ruleInstancesMap.put(metricMessage, ruleInstanceList);
            }
        }

        //sample data
        tableEnvironment.createTemporaryView("view_samples", tableEnvironment.sqlQuery(viewSamples));

        //sink
        PulsarSink<String> sink = PulsarSink.builder()
                .setServiceUrl(serviceUrl)
                .setAdminUrl(adminUrl)
                .setTopics(topic)
                .setSerializationSchema(PulsarSerializationSchema.flinkSchema(new SimpleStringSchema()))
                //  .setDeliverGuarantee(DeliveryGuarantee.AT_LEAST_ONCE)
                .build();

        // get metric info list and compute
        for (Map.Entry<MetricMessage, List<RuleInstance>> entry : ruleInstancesMap.entrySet()) {
            MetricMessage metricMessage = entry.getKey();
            String subjectCategory = metricMessage.getSubjectCategory();
            String subjectCode = metricMessage.getSubjectCode();
            String metricSqlPre = ""; //metricMessage.getExecutorScript();
            String metricSql = null;
            metricMessage.setRuleInstances(entry.getValue());

            if (subjectCategory.equals("TABLE")) {
                metricSql = metricSqlPre.replaceAll("\\$\\{table\\}","view_samples");
            } else {
                String metricSqlPreTwo = metricSqlPre.replaceAll("\\$\\{table\\}","view_samples");
                metricSql = metricSqlPreTwo.replaceAll("\\$\\{field\\}",metaSchemasMap.get(subjectCode));
            }

            Table table = tableEnvironment.sqlQuery(metricSql);
            DataStream<MetricResult> metricResultDataStream = tableEnvironment.toDataStream(table, MetricResult.class);
            SingleOutputStreamOperator<String> metricStringDataStream = metricResultDataStream.map(data -> {
                metricMessage.setMetricsValue(data.getMetricsValue());
                MetricMessage metricMessage1 = new MetricMessage();
                metricMessage1 = metricMessage;
                return JSONObject.toJSONString(metricMessage);
            });

            metricStringDataStream.sinkTo(sink);
        }

        env.execute("OfflineHiveMetrics");

        //Thread.sleep(1000000000);

    }

    //register udf
    private static void registerUdf(String funcName, String classPath) throws Exception {
        Class<?> udfClass = Thread.currentThread().getContextClassLoader().loadClass(classPath);
        UserDefinedFunction udfFunc = udfClass.asSubclass(UserDefinedFunction.class).newInstance();

        tableEnvironment.createTemporarySystemFunction(funcName, udfFunc);
    }
}
