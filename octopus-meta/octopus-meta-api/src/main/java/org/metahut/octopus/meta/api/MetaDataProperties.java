package org.metahut.octopus.meta.api;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "octopus.meta")
public class MetaDataProperties {

    private MetaDataTypeEnum type;
    private Starfish starfish = new Starfish();

    public static class Starfish {

    }

    public MetaDataTypeEnum getType() {
        return type;
    }

    public void setType(MetaDataTypeEnum type) {
        this.type = type;
    }

    public Starfish getStarfish() {
        return starfish;
    }

    public void setStarfish(Starfish starfish) {
        this.starfish = starfish;
    }
}
