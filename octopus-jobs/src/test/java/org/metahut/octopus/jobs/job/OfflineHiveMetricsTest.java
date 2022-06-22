package org.metahut.octopus.jobs.job;

import org.metahut.octopus.common.utils.JSONUtils;
import org.metahut.octopus.jobs.common.MonitorConfig;
import org.metahut.octopus.jobs.common.MonitorFlowDefinitionResponseDTO;

import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.connector.pulsar.sink.PulsarSink;
import org.apache.flink.connector.pulsar.sink.writer.serializer.PulsarSerializationSchema;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Disabled
public class OfflineHiveMetricsTest {

    public static Stream<MonitorFlowDefinitionResponseDTO> flowInstanceProvider() {
        MonitorFlowDefinitionResponseDTO monitorFlowDefinitionResponse = JSONUtils.parseObject(OfflineHiveMetricsTest.class.getClass().getResourceAsStream("/json/oneMetricData.json"),
                new TypeReference<MonitorFlowDefinitionResponseDTO>() {
                });

        return Stream.of(monitorFlowDefinitionResponse);

    }

    @Disabled
    @ParameterizedTest
    @MethodSource("flowInstanceProvider")
    public void executeTaskTest(MonitorFlowDefinitionResponseDTO flowInstance) throws Exception {
        MonitorConfig monitorConfig = MonitorConfig.getMonitorConfig();
        EnvironmentSettings settings = EnvironmentSettings.newInstance()
                .inBatchMode()
                .build();
        // tableEnvironment = TableEnvironment.create(settings);

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        //sink
        PulsarSink<String> sink = PulsarSink.builder()
                .setServiceUrl(monitorConfig.getMessageQueue().getPulsar().getServiceUrl())
                .setAdminUrl(monitorConfig.getMessageQueue().getPulsar().getAdminUrl())
                .setTopics(monitorConfig.getMessageQueue().getPulsar().getTopic())
                .setSerializationSchema(PulsarSerializationSchema.flinkSchema(new SimpleStringSchema()))
                //  .setDeliverGuarantee(DeliveryGuarantee.AT_LEAST_ONCE)
                .build();

        OfflineHiveMetrics.executeTask("2022-06-15 13:10:20",flowInstance,env, settings, sink);
    }
}
