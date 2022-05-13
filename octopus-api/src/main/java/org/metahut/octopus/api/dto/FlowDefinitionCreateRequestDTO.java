package org.metahut.octopus.api.dto;

import javax.validation.constraints.NotEmpty;

public class FlowDefinitionCreateRequestDTO {

    @NotEmpty(message = "{parameter.not.null}")
    private String sourceCode;

    @NotEmpty(message = "{parameter.not.null}")
    private String env;

    @NotEmpty(message = "{parameter.not.null}")
    private String crontab;

    @NotEmpty(message = "{parameter.not.null}")
    private String schedulerCode;

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getCrontab() {
        return crontab;
    }

    public void setCrontab(String crontab) {
        this.crontab = crontab;
    }

    public String getSchedulerCode() {
        return schedulerCode;
    }

    public void setSchedulerCode(String schedulerCode) {
        this.schedulerCode = schedulerCode;
    }
}
