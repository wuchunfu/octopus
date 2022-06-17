package org.metahut.octopus.jobs.util;

public class Constants {
    private Constants() {

    }

    //interface info
    public static final String interfaceUrl = "https://url.com/quality/monitorFlowDefinition/";

    //clickhouse info
    public static final String CLICKHOUSE_URL = "jdbc:clickhouse://172.17.60.10:8123/quality";
    public static final String USER_NAME = "default";
    public static final String PASSWORD = "";

    //pulsar info
    public static final String serviceUrl = "pulsar://pulsar-url.com:6650";
    public static final String adminUrl = "http://pulsar-url.com:8080";
    public static final String topic = "persistent://data/uu/octopus.metrics.result";

}
