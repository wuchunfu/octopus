package org.metahut.octopus.jobs.job;

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

public class RuleMonitorTask {

    private static final String pulsarServiceUrl = "pulsar://pulsar-qa.zpidc.com:6650";
    private static final String pulsarAdminUrl = "http://pulsar-idc-qa.zpidc.com:8080";
    private static final String topicName = "persistent://data/quality/octopus.metrics.result";
    private static final String subscriptionName = "data.quality.dev";
    private static final String jobName = "data-quality-monitor";

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

        DataStream<String> dataStream = env.fromSource(pulsarSource, WatermarkStrategy.noWatermarks(), "quality-metrics-source", TypeInformation.of(String.class));

        dataStream.print().name("print-sink");

        env.execute(jobName);

    }
}
