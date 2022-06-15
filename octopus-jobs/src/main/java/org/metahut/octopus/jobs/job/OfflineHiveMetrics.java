package org.metahut.octopus.jobs.job;

import org.metahut.octopus.jobs.common.MetaDatasetResponseDTO;
import org.metahut.octopus.jobs.common.MetaSchemaSingleResponseDTO;
import org.metahut.octopus.jobs.common.MetricInfo;
import org.metahut.octopus.jobs.common.MetricMessage;
import org.metahut.octopus.jobs.common.MetricResult;
import org.metahut.octopus.jobs.common.MonitorFlowDefinitionResponseDTO;
import org.metahut.octopus.jobs.common.RuleInstance;
import org.metahut.octopus.jobs.common.RuleInstanceResponseDTO;
import org.metahut.octopus.jobs.common.SampleInstanceResponseDTO;
import org.metahut.octopus.jobs.enums.WindowUnit;
import org.metahut.octopus.jobs.util.HttpUtils;
import org.metahut.octopus.jobs.util.MonitorDBPluginHelper;
import org.metahut.octopus.monitordb.api.IMonitorDBSource;
import org.metahut.octopus.monitordb.api.MetricsResult;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.utils.ParameterTool;
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
import org.apache.flink.table.module.hive.HiveModule;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
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
    private static volatile Map<MetricInfo, List<RuleInstance>> ruleInstancesMap = new ConcurrentHashMap<>();
    private static volatile String tableName = null;
    private static volatile String database = null;
    private static volatile String fullTableName = null;
    private static volatile Date scheduleTime = null;  //new Date()
    private static final IMonitorDBSource monitorDBSource = MonitorDBPluginHelper.getMonitorDBSource();

    public static void main(String[] args) throws Exception {
        // -- schduleTIme 2022-06-14 13:10:20
        ParameterTool parameterTool = ParameterTool.fromArgs(args);
        String schduleTimeStr = parameterTool.get("schduleTIme");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        scheduleTime = sdf.parse(schduleTimeStr);

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
        //registerUdf("insert_metrics_clickhouse", "org.metahut.octopus.jobs.udf.InsertMetricsToClickhouse");

        String flowResponse = HttpUtils.get("https://qinglong-pre.dev.zhaopin.com/quality/monitorFlowDefinition/5856993537312");

        JSONObject flowResponseJson = JSONObject.parseObject(flowResponse);
        String flowResponseData = flowResponseJson.getString("data");
        ObjectMapper objectMapper = new ObjectMapper();
        MonitorFlowDefinitionResponseDTO flowInstance = objectMapper.readValue(flowResponseData, MonitorFlowDefinitionResponseDTO.class);

        //get window info
        int windowSize = Integer.valueOf(flowInstance.getWindowSize());
        WindowUnit windowUnit = flowInstance.getWindowUnit();
        Date windowBeginTime = null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(scheduleTime);
        String timecConditionsPre = "";
        String dateTimeField = flowInstance.getDateTimeFields().get(0).getName();
        String dateTimeFormat = flowInstance.getDateTimeFields().get(0).getFormat();
        String type = flowInstance.getDateTimeFields().get(0).getType();
        if (type.equals("string")) {
            timecConditionsPre = "where ${dateTimeField} >= '${beginTime}' and ${dateTimeField}< '${endTime}'";
        } else if (type.equals("int")) {
            timecConditionsPre = "where ${dateTimeField} >= ${beginTime} and ${dateTimeField}< ${endTime}";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateTimeFormat);
        String beginTime = null;
        String endTime = simpleDateFormat.format(scheduleTime);
        switch (windowUnit) {
            case DAY:
                cal.add(Calendar.DAY_OF_MONTH, -windowSize);
                windowBeginTime = cal.getTime();
                beginTime = simpleDateFormat.format(windowBeginTime);
                break;
            case HOUR:
                cal.add(Calendar.HOUR_OF_DAY, -windowSize);
                windowBeginTime = cal.getTime();
                beginTime = simpleDateFormat.format(windowBeginTime);
                break;
            case MINUTE:
                cal.add(Calendar.MINUTE, -windowSize);
                windowBeginTime = cal.getTime();
                break;
            default:
                throw new Exception(
                        "Unsupported windowUnit.");
        }
        String timeConditions = timecConditionsPre.replaceAll("\\$\\{dateTimeField\\}",dateTimeField)
                .replaceAll("\\$\\{beginTime\\}",beginTime)
                .replaceAll("\\$\\{endTime\\}",endTime);

        //get meta info
        MetaDatasetResponseDTO meta = flowInstance.getMeta();
        tableName = meta.getName();
        database = meta.getDatabase().getName();
        fullTableName = database + "." + tableName;
        String datasourceCode = meta.getDatasource().getCode();
        String datasetCode = meta.getCode();
        Collection<MetaSchemaSingleResponseDTO> schemas = meta.getSchemas();
        for (MetaSchemaSingleResponseDTO schema : schemas) {
            metaSchemasMap.put(schema.getCode(), schema.getName());
        }

        //sample data : FLink only support random sample
        //String viewSamplesPre = "select * from myhive.{0} TABLESAMPLE ({1} PERCENT)";
        //select * from default.test_obs_octopus_jobs where dt >= '20220610' and dt < '20220615' and rand() <= 0.1;
        String viewSamplesPre = "select * from myhive.{0} {1} and rand() <= {2}";
        String viewSamples = null;
        //get sampleInstance info
        SampleInstanceResponseDTO sampleInstance = flowInstance.getSampleInstance();
        if (sampleInstance != null) {
            String parameter = sampleInstance.getParameter();
            JSONObject parameterJson = JSONObject.parseObject(parameter);
            int number = parameterJson.getInteger("number");
            viewSamples = MessageFormat.format(viewSamplesPre, fullTableName, timeConditions, (float)number / 100);
        }

        //get ruleInstances info
        List<RuleInstanceResponseDTO> ruleInstancesList = flowInstance.getRuleInstances();
        for (RuleInstanceResponseDTO ruleInstanceResponseDTO : ruleInstancesList) {
            MetricInfo metricInfo = new MetricInfo();
            metricInfo.setId(UUID.randomUUID().toString());
            metricInfo.setReportChannel("");
            metricInfo.setDatasourceCode(datasourceCode);
            metricInfo.setDatasetCode(datasetCode);
            metricInfo.setSubjectCode(ruleInstanceResponseDTO.getSubjectCode());
            metricInfo.setSubjectCategory(ruleInstanceResponseDTO.getSubjectCategory().toString());
            metricInfo.setMetricsCode(ruleInstanceResponseDTO.getMetrics().getCode());
            metricInfo.setMetricsConfigCode(ruleInstanceResponseDTO.getMetricsConfig().getCode());
            metricInfo.setMetricsUniqueKey(ruleInstanceResponseDTO.getMetricsUniqueKey());
            metricInfo.setExecutorScript(ruleInstanceResponseDTO.getMetricsConfig().getExecutorScript() + " " + timeConditions);
            metricInfo.setWindowBeginTime(windowBeginTime);
            metricInfo.setWindowSize(windowSize);
            metricInfo.setWindowUnit(windowUnit.toString());
            metricInfo.setScheduleTime(scheduleTime);
            SampleInstanceResponseDTO metricSampleInstance = ruleInstanceResponseDTO.getSampleInstance();
            if (metricSampleInstance == null) {
                metricInfo.setSampleFlag(Boolean.FALSE);
            }

            RuleInstance ruleInstance = new RuleInstance();
            ruleInstance.setRuleInstanceCode(ruleInstanceResponseDTO.getCode());
            ruleInstance.setCheckType(ruleInstanceResponseDTO.getCheckType());
            ruleInstance.setCheckMethod(ruleInstanceResponseDTO.getCheckMethod());
            ruleInstance.setComparisonUnit(ruleInstanceResponseDTO.getComparisonUnit());
            ruleInstance.setCheckMethod(ruleInstanceResponseDTO.getComparisonMethod());
            ruleInstance.setExpectedValue(ruleInstanceResponseDTO.getExpectedValue());

            List<RuleInstance> ruleInstanceList = ruleInstancesMap.get(metricInfo);
            if (ruleInstanceList == null) {
                ArrayList<RuleInstance> ruleInstances = new ArrayList<>();
                ruleInstances.add(ruleInstance);
                ruleInstancesMap.put(metricInfo, ruleInstances);
            } else {
                ruleInstanceList.add(ruleInstance);
                ruleInstancesMap.put(metricInfo, ruleInstanceList);
            }

        }

        //sample data
        if (viewSamples != null) {
            tableEnvironment.createTemporaryView("view_samples", tableEnvironment.sqlQuery(viewSamples));
        }

        //sink
        PulsarSink<String> sink = PulsarSink.builder()
                .setServiceUrl(serviceUrl)
                .setAdminUrl(adminUrl)
                .setTopics(topic)
                .setSerializationSchema(PulsarSerializationSchema.flinkSchema(new SimpleStringSchema()))
                //  .setDeliverGuarantee(DeliveryGuarantee.AT_LEAST_ONCE)
                .build();

        // get metric info list and compute
        for (Map.Entry<MetricInfo, List<RuleInstance>> entry : ruleInstancesMap.entrySet()) {
            List<RuleInstance> ruleInstanceList = entry.getValue();
            MetricInfo metricInfo = entry.getKey();
            String subjectCategory = metricInfo.getSubjectCategory().toString();
            String subjectCode = metricInfo.getSubjectCode();
            String metricSqlPre = metricInfo.getExecutorScript();
            String metricSql = null;
            if (subjectCategory.equals("TABLE")) {
                if (metricInfo.getSampleFlag().equals(Boolean.TRUE)) {
                    metricSql = metricSqlPre.replaceAll("\\$\\{table\\}","view_samples");
                } else {
                    metricSql = metricSqlPre.replaceAll("\\$\\{table\\}",fullTableName);
                }
            } else {
                if (metricInfo.getSampleFlag().equals(Boolean.TRUE)) {
                    String metricSqlPreTwo = metricSqlPre.replaceAll("\\$\\{table\\}","view_samples");
                    metricSql = metricSqlPreTwo.replaceAll("\\$\\{field\\}",metaSchemasMap.get(subjectCode));
                } else {
                    String metricSqlPreTwo = metricSqlPre.replaceAll("\\$\\{table\\}",fullTableName);
                    metricSql = metricSqlPreTwo.replaceAll("\\$\\{field\\}",metaSchemasMap.get(subjectCode));
                }
            }

            Table table = tableEnvironment.sqlQuery(metricSql);
            DataStream<MetricResult> metricResultDataStream = tableEnvironment.toDataStream(table, MetricResult.class); //这里改下类名，不然有些混淆MetricValue.class
            SingleOutputStreamOperator<String> metricStringDataStream = metricResultDataStream
                    //insert into clickhouse
                    .map(data -> {
                        MetricsResult metricsResult = new MetricsResult();
                        metricsResult.setId(metricInfo.getId());
                        metricsResult.setWindowBeginTime(metricInfo.getWindowBeginTime());
                        metricsResult.setWindowSize(metricInfo.getWindowSize());
                        metricsResult.setWindowUnit(metricInfo.getWindowUnit());
                        metricsResult.setScheduleTime(scheduleTime);
                        metricsResult.setReportChannel(metricInfo.getReportChannel());
                        metricsResult.setDatasetCode(metricInfo.getDatasetCode());
                        metricsResult.setSubjectCode(metricInfo.getSubjectCode());
                        metricsResult.setSubjectCategory(metricInfo.getSubjectCategory().toString());
                        metricsResult.setMetricsCode(metricInfo.getMetricsCode());
                        metricsResult.setMetricsUniqueKey(metricInfo.getMetricsUniqueKey());
                        if (data.getMetricsValue() == null && metricInfo.getMetricsCode().equals("null_rate")) {
                            metricsResult.setMetricsValue("1");
                        } else {
                            metricsResult.setMetricsValue(data.getMetricsValue());
                        }
                        metricsResult.setCreateTime(new Date());
                        monitorDBSource.saveMetricsResult(metricsResult);
                        return data;
                    })
                    //send to pulsar
                    .map(data -> {
                        MetricMessage metricMessage = new MetricMessage();
                        metricMessage.setId(metricInfo.getId());
                        metricMessage.setReportChannel(metricInfo.getReportChannel());
                        metricMessage.setDatasourceCode(metricInfo.getDatasourceCode());
                        metricMessage.setDatasetCode(metricInfo.getDatasetCode());
                        metricMessage.setSubjectCode(metricInfo.getSubjectCode());
                        metricMessage.setSubjectCategory(metricInfo.getSubjectCategory().toString());
                        metricMessage.setMetricsCode(metricInfo.getMetricsCode());
                        metricMessage.setMetricsConfigCode(metricInfo.getMetricsConfigCode());
                        metricMessage.setMetricsUniqueKey(metricInfo.getMetricsUniqueKey());
                        if (data.getMetricsValue() == null && metricInfo.getMetricsCode().equals("null_rate")) {
                            metricMessage.setMetricsValue("1");
                        } else {
                            metricMessage.setMetricsValue(data.getMetricsValue());
                        }
                        metricMessage.setWindowBeginTime(metricInfo.getWindowBeginTime());
                        metricMessage.setWindowSize(metricInfo.getWindowSize());
                        metricMessage.setWindowUnit(metricInfo.getWindowUnit());
                        metricMessage.setScheduleTime(metricInfo.getScheduleTime());
                        metricMessage.setSendDate(new Date());
                        metricMessage.setRuleInstances(ruleInstanceList);

                        return objectMapper.writeValueAsString(metricMessage);
                    });
            metricStringDataStream.sinkTo(sink);
        }

        env.execute("OfflineHiveMetrics");

        //Thread.sleep(1000000000);

    }

    //register udf
    /*private static void registerUdf(String funcName, String classPath) throws Exception {
        Class<?> udfClass = Thread.currentThread().getContextClassLoader().loadClass(classPath);
        UserDefinedFunction udfFunc = udfClass.asSubclass(UserDefinedFunction.class).newInstance();

        tableEnvironment.createTemporarySystemFunction(funcName, udfFunc);
    }*/
}
