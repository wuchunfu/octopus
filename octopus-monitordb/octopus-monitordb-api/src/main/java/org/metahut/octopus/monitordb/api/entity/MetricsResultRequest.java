package org.metahut.octopus.monitordb.api.entity;

import java.util.Date;
import java.util.List;

public class MetricsResultRequest {

    private List<String> sourceCodes;
    private List<String> metricsCodes;
    private List<String> metricsConfigCodes;
    private Date resultStartTime;
    private Date resultEndTime;

    public List<String> getSourceCodes() {
        return sourceCodes;
    }

    public void setSourceCodes(List<String> sourceCodes) {
        this.sourceCodes = sourceCodes;
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
        this.metricsConfigCodes = metricsConfigCodes;
    }

    public Date getResultStartTime() {
        return resultStartTime;
    }

    public void setResultStartTime(Date resultStartTime) {
        this.resultStartTime = resultStartTime;
    }

    public Date getResultEndTime() {
        return resultEndTime;
    }

    public void setResultEndTime(Date resultEndTime) {
        this.resultEndTime = resultEndTime;
    }
}
