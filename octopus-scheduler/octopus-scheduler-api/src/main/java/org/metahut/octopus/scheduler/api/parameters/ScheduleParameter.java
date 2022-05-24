package org.metahut.octopus.scheduler.api.parameters;

public class ScheduleParameter {

    private String flowCode;
    private String scheduleCode;
    private ScheduleCronParameter scheduleCronParameter;

    public String getFlowCode() {
        return flowCode;
    }

    public void setFlowCode(String flowCode) {
        this.flowCode = flowCode;
    }

    public ScheduleCronParameter getScheduleCronParameter() {
        return scheduleCronParameter;
    }

    public void setScheduleCronParameter(ScheduleCronParameter scheduleCronParameter) {
        this.scheduleCronParameter = scheduleCronParameter;
    }

    public String getScheduleCode() {
        return scheduleCode;
    }

    public void setScheduleCode(String scheduleCode) {
        this.scheduleCode = scheduleCode;
    }
}
