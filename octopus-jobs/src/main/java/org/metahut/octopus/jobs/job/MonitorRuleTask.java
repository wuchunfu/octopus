package org.metahut.octopus.jobs.job;

import org.metahut.octopus.jobs.common.MetricMessage;
import org.metahut.octopus.jobs.common.RuleInstance;
import org.metahut.octopus.jobs.util.MonitorDBPluginHelper;
import org.metahut.octopus.monitordb.api.IMonitorDBSource;
import org.metahut.octopus.monitordb.api.MetricsResult;
import org.metahut.octopus.monitordb.api.MetricsResultRequest;
import org.metahut.octopus.monitordb.api.PageResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.flink.api.common.RuntimeExecutionMode;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.connector.pulsar.source.PulsarSource;
import org.apache.flink.connector.pulsar.source.enumerator.cursor.StartCursor;
import org.apache.flink.connector.pulsar.source.reader.deserializer.PulsarDeserializationSchema;
import org.apache.flink.streaming.api.scala.DataStream;
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment;
import org.apache.pulsar.client.api.SubscriptionType;

import java.util.List;

public class MonitorRuleTask {

    private static final String pulsarServiceUrl = "pulsar://pulsar-qa.zpidc.com:6650";
    private static final String pulsarAdminUrl = "http://pulsar-idc-qa.zpidc.com:8080";
    private static final String topicName = "persistent://data/quality/octopus.metrics.result";
    private static final String subscriptionName = "data.quality.dev";
    private static final String jobName = "data-quality-monitor";

    private static final String monitorRuleLogTable = "monitor_rule_log_all";
    private static final String monitorMetricsResultTable = "monitor_metrics_result_all";

    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setRuntimeMode(RuntimeExecutionMode.STREAMING);

        PulsarSource<String> pulsarSource = PulsarSource.builder()
            .setServiceUrl(pulsarServiceUrl)
            .setAdminUrl(pulsarAdminUrl)
            .setStartCursor(StartCursor.earliest())
            .setTopics(topicName)
            .setDeserializationSchema(PulsarDeserializationSchema.flinkSchema(new SimpleStringSchema()))
            .setSubscriptionName(subscriptionName)
            .setSubscriptionType(SubscriptionType.Key_Shared)
            .build();

        // PulsarDeserializationSchema.flinkSchema()
        ObjectMapper objectMapper = new ObjectMapper();
        DataStream<String> dataStream = env.fromSource(pulsarSource, WatermarkStrategy.noWatermarks(), "quality-metrics-source", TypeInformation.of(String.class));

        // dataStream.map(item -> {
        //     objectMapper.readValue(item, MetricMessage.class);
        // })

        dataStream.print().name("print-sink");

        env.execute(jobName);
    }

    public void handleMonitorRule(MetricMessage metricMessage) {
        IMonitorDBSource monitorDBSource = MonitorDBPluginHelper.getMonitorDBSource();

        MetricsResultRequest request = new MetricsResultRequest();
        request.setPageNo(1);
        request.setPageSize(10);
        // request.setMetricsCodes(Lists.asList(metricMessage.getMetricsCode()));
        PageResponse<MetricsResult> pageResponse = monitorDBSource.queryMetricsResultListPage(request);

    }

    public static String buildSQLForFixedValue(MetricMessage metricMessage) {

        List<RuleInstance> ruleInstanceList = metricMessage.getRuleInstances();

        // list.add(SelectItemResponseDTO.of("FixedValue", "与固定值比较"));
        // list.add(SelectItemResponseDTO.of("7DayAverageFluctuation", "7天平均值波动"));

        String sql = String.format("select  from %s where id = '%s' and create_time between '%s' and '%s' limit 1", monitorMetricsResultTable);

        //
        // if (metricMessage.getMetricsCode().equalsIgnoreCase("delay")) {
        //
        // } else if (metricMessage.getMetricsCode().equalsIgnoreCase("production")) {
        //
        // } else if (metricMessage.getMetricsCode().equalsIgnoreCase("production"))

        return sql;
    }

}
