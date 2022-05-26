package org.metahut.octopus.meta.api;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "octopus.meta")
public class MetaProperties {

    private MetaTypeEnum type;
    private Starfish starfish = new Starfish();

    public static class Starfish {

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

    public MetaTypeEnum getType() {
        return type;
    }

    public void setType(MetaTypeEnum type) {
        this.type = type;
    }

    public Starfish getStarfish() {
        return starfish;
    }

    public void setStarfish(Starfish starfish) {
        this.starfish = starfish;
    }
}
