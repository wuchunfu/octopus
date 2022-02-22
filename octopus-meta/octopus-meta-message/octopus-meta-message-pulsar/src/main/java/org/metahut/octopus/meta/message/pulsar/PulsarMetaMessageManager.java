package org.metahut.octopus.meta.message.pulsar;

import org.metahut.octopus.meta.message.api.MetaMessageConsumer;
import org.metahut.octopus.meta.message.api.MetaMessageManager;
import org.metahut.octopus.meta.message.api.MetaMessageProducer;
import org.metahut.octopus.meta.message.api.MetaMessageProperties;

import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * pulsar meta message manager
 */
@Component
@ConditionalOnProperty(prefix = "meta.message", name = "type", havingValue = "pulsar")
public class PulsarMetaMessageManager implements MetaMessageManager {

    private static final Logger logger = LoggerFactory.getLogger(PulsarMetaMessageManager.class);

    private final PulsarClient client;

    private final MetaMessageProperties.Pulsar pulsarProperties;

    private final Map<String, MetaMessageProducer> metaMessageProducerMap = new ConcurrentHashMap(16);
    private final Map<String, MetaMessageConsumer> metaMessageConsumerMap = new ConcurrentHashMap(16);

    public PulsarMetaMessageManager(MetaMessageProperties metaMessageProperties) {
        pulsarProperties = metaMessageProperties.getPulsar();
        try {
            client = PulsarClient.builder()
                    .serviceUrl(pulsarProperties.getServiceUrl())
                    .build();
            this.setProducers(pulsarProperties.getProducers());
            this.setConsumers(pulsarProperties.getConsumers());

        } catch (PulsarClientException e) {
            logger.error(e.getMessage(), e);
            // TODO Exception type???
            throw new IllegalArgumentException(e);
        }
    }

    public void setProducers(Map<String, MetaMessageProperties.PulsarProducer> producerMap) {
        producerMap.forEach((name, properties) -> metaMessageProducerMap.put(name, this.createProducer(properties)));
    }

    protected MetaMessageProducer createProducer(MetaMessageProperties.PulsarProducer properties) {
        try {
            return new PulsarMetaMessageProducer(client.newProducer()
                    .topic(properties.getTopicName())
                    .producerName(properties.getProducerName())
                    .create());
        } catch (PulsarClientException e) {
            logger.error(e.getMessage(), e);
            // TODO Exception type???
            throw new IllegalArgumentException(e);
        }
    }

    public void setConsumers(Map<String, MetaMessageProperties.PulsarConsumer> consumerMap) {
        consumerMap.forEach((name, properties) -> metaMessageConsumerMap.put(name, this.createConsumer(properties)));
    }

    protected MetaMessageConsumer createConsumer(MetaMessageProperties.PulsarConsumer properties) {
        try {
            return new PulsarMetaMessageConsumer(client.newConsumer()
                    .topic(properties.getTopicName())
                    .subscriptionName(properties.getSubscriptionName())
                    .subscribe());
        } catch (PulsarClientException e) {
            logger.error(e.getMessage(), e);
            // TODO Exception type???
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public MetaMessageProducer getProducer(String name) {
        return metaMessageProducerMap.get(name);
    }

    @Override
    public MetaMessageConsumer getConsumer(String name) {
        return metaMessageConsumerMap.get(name);
    }

    @Override
    public void close() throws IOException {
        metaMessageProducerMap.forEach((name, producer) -> {
            try {
                producer.close();
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        });

        metaMessageConsumerMap.forEach((name, consumer) -> {
            try {
                consumer.close();
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        });

        if (Objects.nonNull(client)) {
            client.close();
        }
    }

}
