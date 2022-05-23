package org.metahut.octopus.monitordb.api;

import java.util.Date;
import java.util.List;

public class MetricsResultRequest extends PageRequest {

    private List<String> metricsCodes;

    private Date createStartTime;
    private Date createEndTime;

    public List<String> getMetricsCodes() {
        return metricsCodes;
    }

    public void setMetricsCodes(List<String> metricsCodes) {
        this.metricsCodes = metricsCodes;
    }

    public Date getCreateStartTime() {
        return createStartTime;
    }

    public void setCreateStartTime(Date createStartTime) {
        this.createStartTime = createStartTime;
    }

    public Date getCreateEndTime() {
        return createEndTime;
    }

    public void setCreateEndTime(Date createEndTime) {
        this.createEndTime = createEndTime;
    }
}
