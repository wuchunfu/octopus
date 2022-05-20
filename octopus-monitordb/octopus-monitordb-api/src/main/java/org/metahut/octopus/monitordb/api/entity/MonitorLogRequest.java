package org.metahut.octopus.monitordb.api.entity;

import java.util.Date;
import java.util.List;

public class MonitorLogRequest {
    private List<Integer> ids;
    private List<String> sourceCodes;
    private List<String> alerterCodes;
    private List<String> metricsCodes;
    private List<String> metricsConfigCodes;
    private Date logStartTime;
    private Date logEndTime;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public List<String> getSourceCodes() {
        return sourceCodes;
    }

    public void setSourceCodes(List<String> sourceCodes) {
        this.sourceCodes = sourceCodes;
    }

    public List<String> getAlerterCodes() {
        return alerterCodes;
    }

    public void setAlerterCodes(List<String> alerterCodes) {
        this.alerterCodes = alerterCodes;
    }

    public List<String> getMetricsCodes() {
        return metricsCodes;
    }

    public void setMetricsCodes(List<String> metricsCodes) {
        this.metricsCodes = metricsCodes;
    }

    public List<String> getMetricsConfigCodes() {
        return metricsConfigCodes;
    }

    public void setMetricsConfigCodes(List<String> metricsConfigCodes) {
        metricsConfigCodes = metricsConfigCodes;
    }

    public Date getLogStartTime() {
        return logStartTime;
    }

    public void setLogStartTime(Date logStartTime) {
        this.logStartTime = logStartTime;
    }

    public Date getLogEndTime() {
        return logEndTime;
    }

    public void setLogEndTime(Date logEndTime) {
        this.logEndTime = logEndTime;
    }
}
