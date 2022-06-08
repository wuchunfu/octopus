package org.metahut.octopus.jobs.job;

import org.metahut.octopus.jobs.common.FlowInstance;
import org.metahut.octopus.jobs.common.MetricMessage;
import org.metahut.octopus.jobs.util.HttpUtils;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.connector.pulsar.sink.PulsarSink;
import org.apache.flink.connector.pulsar.sink.writer.serializer.PulsarSerializationSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.table.catalog.hive.HiveCatalog;
import org.apache.flink.table.functions.UserDefinedFunction;
import org.apache.flink.table.module.hive.HiveModule;

public class OfflineHiveMetrics {
    private static StreamTableEnvironment tableEnvironment;
    //private static StatementSet statementSet;
    private static final String serviceUrl = "pulsar://pulsar-idc-qa.zpidc.com:6650";
    private static final String adminUrl = "http://pulsar-idc-qa.zpidc.com:8080";
    private static final String topic = "persistent://data/uu/octopus.metrics.result";

    public static void main(String[] args) throws Exception {
        String flowResponse = HttpUtils.get("https://qinglong-pre.dev.zhaopin.com/quality/monitorFlowDefinition/5782139932320");
        ObjectMapper objectMapper = new ObjectMapper();
        FlowInstance flowInstance = objectMapper.readValue(flowResponse, FlowInstance.class);

        //sample data
        String viewSamples = "select\n"
                + "age\n"
                //"feature_name\n" +
                + "from\n"
                + "myhive.`default`.test_obs_octopus_jobs\n"
                //"myhive.dmm.fdm_cv_feature_day\n" +
                + "order by rand()\n"
                + "limit 2000";
        //String view_samples = "select feature_name from myhive.dmm.fdm_cv_feature_day TABLESAMPLE (10 PERCENT)";

        //production view
        String metricsProduction = "select count(1) as metrics_value from view_samples";
        //null rate view
        String metricsNullRate = "select sum(if(age is null, 1, 0))/count(1)  as metrics_value from view_samples";
        //resutl table
        String tableResult = "select\n"
                + "  123 as id,\n"
                + "  insert_metrics_clickhouse(123, 'report_channel', 'dataset_code', 'subject_code', 'subject_category', 'production', 'key', cast (metrics_value as varchar)) as report_channel,\n"
                + "  'dataset_code' as dataset_code,\n"
                + "  'subject_code' as subject_code,\n"
                + "  'subject_category'as subject_category,\n"
                + "  'production' as  metrics_code,\n"
                + "  'metrics_unique_key' as metrics_unique_key,\n"
                + "  cast (metrics_value as varchar) as metrics_value,\n"
                + "  'rule_instances' as rule_instances\n"
                + "from\n"
                + "  view_metrics_production\n"
                + "union all\n"
                + "select\n"
                + "  123 as id,\n"
                + "  insert_metrics_clickhouse(123, 'report_channel', 'dataset_code', 'subject_code', 'subject_category', 'production', 'key', cast (metrics_value as varchar)) as report_channel,\n"
                + "  'dataset_code' as dataset_code,\n"
                + "  'subject_code' as subject_code,\n"
                + "  'subject_category'as subject_category,\n"
                + "  'metrics_code' as  metrics_code,\n"
                + "  'metrics_unique_key' as metrics_unique_key,\n"
                + "  cast (metrics_value as varchar) as metrics_value,\n"
                + "  'rule_instances' as rule_instances\n"
                + "from\n"
                + "  view_metrics_null_rate";

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

        //sample data
        tableEnvironment.createTemporaryView("view_samples", tableEnvironment.sqlQuery(viewSamples));

        //production view
        tableEnvironment.createTemporaryView("view_metrics_production", tableEnvironment.sqlQuery(metricsProduction));

        //null rate view
        tableEnvironment.createTemporaryView("view_metrics_null_rate", tableEnvironment.sqlQuery(metricsNullRate));

        //union all TODO
        // tableEnvironment.createTemporaryView("view_result", tableEnvironment.sqlQuery(table_result));
        Table table = tableEnvironment.sqlQuery(tableResult);
        // tableEnvironment.sqlQuery()
        // .unionAll(tableEnvironment.sqlQuery())

        DataStream<String> metricResultDataStream = tableEnvironment.toDataStream(table, MetricMessage.class)
                .map(data -> JSONObject.toJSONString(data));

        PulsarSink<String> sink = PulsarSink.builder()
                .setServiceUrl(serviceUrl)
                .setAdminUrl(adminUrl)
                .setTopics(topic)
                .setSerializationSchema(PulsarSerializationSchema.flinkSchema(new SimpleStringSchema()))
                //  .setDeliverGuarantee(DeliveryGuarantee.AT_LEAST_ONCE)
                .build();

        metricResultDataStream.sinkTo(sink);
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
