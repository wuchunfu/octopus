package org.metahut.octopus.meta.message.pulsar;

import org.metahut.octopus.meta.message.api.MetaMessageProducer;
import org.metahut.octopus.meta.message.api.MetaMessageProperties;
import org.metahut.octopus.meta.message.api.MetaMessageType;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Disabled
class PulsarMetaMessageManagerTest {

    private PulsarMetaMessageManager pulsarMetaMessageManager;

    private static final String PULSAR_SERVICE_URL = "";
    private static final String PULSAR_PRODUCER_1_NAME = "metaProducer";

    @BeforeEach
    public void before() {

        MetaMessageProperties metaMessageProperties = new MetaMessageProperties();
        metaMessageProperties.setType(MetaMessageType.PULSAR);
        MetaMessageProperties.Pulsar pulsar = new MetaMessageProperties.Pulsar();
        pulsar.setServiceUrl(PULSAR_SERVICE_URL);

        // set pulsar producer
        Map<String, MetaMessageProperties.PulsarProducer> producerMap = new HashMap<>();
        MetaMessageProperties.PulsarProducer pulsarProducer = new MetaMessageProperties.PulsarProducer();
        pulsarProducer.setTopicName("my-topic");
        pulsarProducer.setProducerName("producer-1");
        producerMap.put(PULSAR_PRODUCER_1_NAME, pulsarProducer);
        pulsar.setProducers(producerMap);

        Map<String, MetaMessageProperties.PulsarConsumer> consumerMap = new HashMap<>();

        pulsar.setConsumers(consumerMap);

        pulsarMetaMessageManager = new PulsarMetaMessageManager(metaMessageProperties);
    }

    @AfterEach
    public void after() throws IOException {
        if (Objects.nonNull(pulsarMetaMessageManager)) {
            pulsarMetaMessageManager.close();
        }
    }

    @Test
    public void testProducer() {
        MetaMessageProducer producer = pulsarMetaMessageManager.getProducer(PULSAR_PRODUCER_1_NAME);
        producer.send("k1", "v1");
    }

}