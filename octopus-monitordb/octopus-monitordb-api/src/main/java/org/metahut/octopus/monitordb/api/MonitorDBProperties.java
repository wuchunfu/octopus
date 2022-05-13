package org.metahut.octopus.monitordb.api;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "octopus.monitordb")
public class MonitorDBProperties {

    private MonitorDBTypeEnum type;
    private ElasticSearch elasticsearch = new ElasticSearch();

    public static class ElasticSearch {

    }

    public MonitorDBTypeEnum getType() {
        return type;
    }

    public void setType(MonitorDBTypeEnum type) {
        this.type = type;
    }

    public ElasticSearch getElasticsearch() {
        return elasticsearch;
    }

    public void setElasticsearch(ElasticSearch elasticsearch) {
        this.elasticsearch = elasticsearch;
    }
}
