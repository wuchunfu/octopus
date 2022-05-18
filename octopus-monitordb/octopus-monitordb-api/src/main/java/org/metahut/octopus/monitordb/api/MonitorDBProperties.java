package org.metahut.octopus.monitordb.api;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "octopus.monitordb")
public class MonitorDBProperties {

    private MonitorDBTypeEnum type;
    private ElasticSearch elasticsearch = new ElasticSearch();

    private Clickhouse clickhouse = new Clickhouse();

    public static class ElasticSearch {

    }

    private static class JDBCDatasource {
        private String driverClassName;
        private String jdbcUrl;
        private String user;
        private String password;
        private Integer minimumIdle;
        private Integer maximumPoolSize;
        private String validationQuery;

        public String getDriverClassName() {
            return driverClassName;
        }

        public void setDriverClassName(String driverClassName) {
            this.driverClassName = driverClassName;
        }

        public String getJdbcUrl() {
            return jdbcUrl;
        }

        public void setJdbcUrl(String jdbcUrl) {
            this.jdbcUrl = jdbcUrl;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Integer getMinimumIdle() {
            return minimumIdle;
        }

        public void setMinimumIdle(Integer minimumIdle) {
            this.minimumIdle = minimumIdle;
        }

        public Integer getMaximumPoolSize() {
            return maximumPoolSize;
        }

        public void setMaximumPoolSize(Integer maximumPoolSize) {
            this.maximumPoolSize = maximumPoolSize;
        }

        public String getValidationQuery() {
            return validationQuery;
        }

        public void setValidationQuery(String validationQuery) {
            this.validationQuery = validationQuery;
        }
    }

    public static class Clickhouse extends JDBCDatasource {

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

    public Clickhouse getClickhouse() {
        return clickhouse;
    }

    public void setClickhouse(Clickhouse clickhouse) {
        this.clickhouse = clickhouse;
    }
}
