package org.metahut.octopus.parser.metrics.custom.script;

import org.metahut.octopus.parser.api.AbstractParameter;

import java.util.List;

public class MetricsCustomScriptParserParameter extends AbstractParameter {

    private String executorType;
    private String executorScript;

    @Override
    public boolean checkParameter() {
        return false;
    }

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
