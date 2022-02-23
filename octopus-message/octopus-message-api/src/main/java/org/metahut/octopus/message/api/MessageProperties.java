package org.metahut.octopus.message.api;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(
        prefix = "meta.message"
)
public class MessageProperties {

    private MessageType type;
    private final Kafka kafka = new Kafka();
    private final Pulsar pulsar = new Pulsar();

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public Kafka getKafka() {
        return kafka;
    }

    public Pulsar getPulsar() {
        return pulsar;
    }

    public static class Kafka {

    }

    public static class Pulsar {

        private String serviceUrl;

        private Map<String, PulsarProducer> producers;

        private Map<String, PulsarConsumer> consumers;

        public String getServiceUrl() {
            return serviceUrl;
        }

        public void setServiceUrl(String serviceUrl) {
            this.serviceUrl = serviceUrl;
        }

        public Map<String, PulsarProducer> getProducers() {
            return producers;
        }

        public void setProducers(Map<String, PulsarProducer> producers) {
            this.producers = producers;
        }

        public Map<String, PulsarConsumer> getConsumers() {
            return consumers;
        }

        public void setConsumers(Map<String, PulsarConsumer> consumers) {
            this.consumers = consumers;
        }
    }

    public static class PulsarProducer {

        private String topicName;

        private String schema;

        private String producerName;

        public String getTopicName() {
            return topicName;
        }

        public void setTopicName(String topicName) {
            this.topicName = topicName;
        }

        public String getSchema() {
            return schema;
        }

        public void setSchema(String schema) {
            this.schema = schema;
        }

        public String getProducerName() {
            return producerName;
        }

        public void setProducerName(String producerName) {
            this.producerName = producerName;
        }
    }

    public static class PulsarConsumer {

        private String topicName;

        private String subscriptionName;

        public String getTopicName() {
            return topicName;
        }

        public void setTopicName(String topicName) {
            this.topicName = topicName;
        }

        public String getSubscriptionName() {
            return subscriptionName;
        }

        public void setSubscriptionName(String subscriptionName) {
            this.subscriptionName = subscriptionName;
        }
    }

}
