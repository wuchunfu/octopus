package org.metahut.octupus.meta.message.api;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(
        prefix = "meta.message"
)
public class MetaMessageProperties {

    private MetaMessageType type;
    private final MetaMessageProperties.Kafka kafka = new MetaMessageProperties.Kafka();
    private final MetaMessageProperties.Pulsar pulsar = new MetaMessageProperties.Pulsar();

    public MetaMessageType getType() {
        return type;
    }

    public void setType(MetaMessageType type) {
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
        private String token;

        public String getServiceUrl() {
            return serviceUrl;
        }

        public void setServiceUrl(String serviceUrl) {
            this.serviceUrl = serviceUrl;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

}
