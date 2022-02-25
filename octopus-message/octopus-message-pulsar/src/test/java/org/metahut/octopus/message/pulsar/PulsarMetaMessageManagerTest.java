package org.metahut.octopus.message.pulsar;

import org.metahut.octopus.message.api.MessageProducer;
import org.metahut.octopus.message.api.MessageProperties;
import org.metahut.octopus.message.api.MessageType;

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

    private PulsarMessageManager pulsarMessageManager;

    private static final String PULSAR_SERVICE_URL = "";
    private static final String PULSAR_PRODUCER_1_NAME = "metaProducer";

    @BeforeEach
    public void before() {

        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setType(MessageType.PULSAR);
        MessageProperties.Pulsar pulsar = new MessageProperties.Pulsar();
        pulsar.setServiceUrl(PULSAR_SERVICE_URL);

        // set pulsar producer
        Map<String, MessageProperties.PulsarProducer> producerMap = new HashMap<>();
        MessageProperties.PulsarProducer pulsarProducer = new MessageProperties.PulsarProducer();
        pulsarProducer.setTopicName("my-topic");
        pulsarProducer.setProducerName("producer-1");
        producerMap.put(PULSAR_PRODUCER_1_NAME, pulsarProducer);
        pulsar.setProducers(producerMap);

        Map<String, MessageProperties.PulsarConsumer> consumerMap = new HashMap<>();

        pulsar.setConsumers(consumerMap);

        pulsarMessageManager = new PulsarMessageManager(messageProperties);
    }

    @AfterEach
    public void after() throws IOException {
        if (Objects.nonNull(pulsarMessageManager)) {
            pulsarMessageManager.close();
        }
    }

    @Test
    public void testProducer() {
        MessageProducer producer = pulsarMessageManager.getProducer(PULSAR_PRODUCER_1_NAME);
        producer.send("k1", "v1");
    }

}