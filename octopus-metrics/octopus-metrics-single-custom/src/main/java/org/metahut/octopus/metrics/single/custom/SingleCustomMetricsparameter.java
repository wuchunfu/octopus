package org.metahut.octopus.metrics.single.custom;

import org.metahut.octopus.metrics.api.AbstractMetricsParameter;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(value = "SingleCustom")
public class SingleCustomMetricsparameter extends AbstractMetricsParameter {

    private String executorType;
    private String executorScript;

    public String getExecutorType() {
        return executorType;
    }

    public void setExecutorType(String executorType) {
        this.executorType = executorType;
    }

    public String getExecutorScript() {
        return executorScript;
    }

    public void setExecutorScript(String executorScript) {
        this.executorScript = executorScript;
    }
}
