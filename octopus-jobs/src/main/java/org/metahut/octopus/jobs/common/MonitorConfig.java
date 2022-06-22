package org.metahut.octopus.jobs.common;

import org.metahut.octopus.monitordb.api.MonitorDBProperties;

import org.apache.flink.shaded.jackson2.org.yaml.snakeyaml.Yaml;

import java.io.Serializable;
import java.util.Objects;

public class MonitorConfig implements Serializable {

    private static final String monitorConfigResourcePath = "monitor-config.yaml";

    private MetricMessageQueue messageQueue;

    private String alertService;

    private HiveConfig hiveConfig;

    public HiveConfig getHiveConfig() {
        return hiveConfig;
    }

    public void setHiveConfig(HiveConfig hiveConfig) {
        this.hiveConfig = hiveConfig;
    }

    private String monitorFlowDefinitionService;

    private MonitorDBProperties monitorStorage;

    private MonitorRuleTaskConfig monitorRuleTask;

    private MonitorConfig() {

    }

    private static MonitorConfig monitorConfig;

    public static MonitorConfig getMonitorConfig() {
        if (Objects.isNull(monitorConfig)) {
            synchronized (MonitorConfig.class) {
                if (Objects.isNull(monitorConfig)) {
                    monitorConfig = new Yaml().loadAs(
                        MonitorConfig.class.getClassLoader().getResourceAsStream(monitorConfigResourcePath), MonitorConfig.class);
                }
            }
        }
        return monitorConfig;
    }

    public MetricMessageQueue getMessageQueue() {
        return messageQueue;
    }

    public void setMessageQueue(
        MetricMessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    public String getAlertService() {
        return alertService;
    }

    public void setAlertService(String alertService) {
        this.alertService = alertService;
    }

    public String getMonitorFlowDefinitionService() {
        return monitorFlowDefinitionService;
    }

    public void setMonitorFlowDefinitionService(String monitorFlowDefinitionService) {
        this.monitorFlowDefinitionService = monitorFlowDefinitionService;
    }

    public MonitorRuleTaskConfig getMonitorRuleTask() {
        return monitorRuleTask;
    }

    public void setMonitorRuleTask(
        MonitorRuleTaskConfig monitorRuleTask) {
        this.monitorRuleTask = monitorRuleTask;
    }

    public MonitorDBProperties getMonitorStorage() {
        return monitorStorage;
    }

    public void setMonitorStorage(MonitorDBProperties monitorStorage) {
        this.monitorStorage = monitorStorage;
    }

    public static class MetricMessageQueue {
        private MonitorMessageTypeEnum type;
        private Pulsar pulsar;

        public MonitorMessageTypeEnum getType() {
            return type;
        }

        public void setType(MonitorMessageTypeEnum type) {
            this.type = type;
        }

        public Pulsar getPulsar() {
            return pulsar;
        }

        public void setPulsar(Pulsar pulsar) {
            this.pulsar = pulsar;
        }
    }

    public static class Pulsar {
        private String serviceUrl;
        private String adminUrl;
        private String topic;
        private String subscriptionName;

        public String getServiceUrl() {
            return serviceUrl;
        }

        public void setServiceUrl(String serviceUrl) {
            this.serviceUrl = serviceUrl;
        }

        public String getAdminUrl() {
            return adminUrl;
        }

        public void setAdminUrl(String adminUrl) {
            this.adminUrl = adminUrl;
        }

        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }

        public String getSubscriptionName() {
            return subscriptionName;
        }

        public void setSubscriptionName(String subscriptionName) {
            this.subscriptionName = subscriptionName;
        }
    }

    public static class MonitorRuleTaskConfig {
        private ComputeEngineTypeEnum type;
        private String jobName;

        public ComputeEngineTypeEnum getType() {
            return type;
        }

        public void setType(ComputeEngineTypeEnum type) {
            this.type = type;
        }

        public String getJobName() {
            return jobName;
        }

        public void setJobName(String jobName) {
            this.jobName = jobName;
        }
    }

    public static class HiveConfig {
        private String hiveConfDir;
        private String version;

        public String getHiveConfDir() {
            return hiveConfDir;
        }

        public void setHiveConfDir(String hiveConfDir) {
            this.hiveConfDir = hiveConfDir;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }

}
