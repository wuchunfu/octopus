package org.metahut.octopus.api.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class MonitorTaskInstanceResponseDTO {

    @ApiModelProperty(value = "flow definition")
    private MonitorFlowDefinitionResponseDTO flowDefinition;

    @ApiModelProperty(value = "schedulerTaskInstanceCode")
    private String schedulerTaskInstanceCode;

    @ApiModelProperty(value = "schedulerFlowInstanceCode")
    private String schedulerFlowInstanceCode;

    @ApiModelProperty(value = "executionStatus")
    private String executionStatus;

    @ApiModelProperty(value = "taskStartTime")
    private Date taskStartTime;

    @ApiModelProperty(value = "taskEndTime")
    private Date taskEndTime;

    public MonitorFlowDefinitionResponseDTO getFlowDefinition() {
        return flowDefinition;
    }

    public void setFlowDefinition(MonitorFlowDefinitionResponseDTO flowDefinition) {
        this.flowDefinition = flowDefinition;
    }

    public String getSchedulerTaskInstanceCode() {
        return schedulerTaskInstanceCode;
    }

    public void setSchedulerTaskInstanceCode(String schedulerTaskInstanceCode) {
        this.schedulerTaskInstanceCode = schedulerTaskInstanceCode;
    }

    public String getSchedulerFlowInstanceCode() {
        return schedulerFlowInstanceCode;
    }

    public void setSchedulerFlowInstanceCode(String schedulerFlowInstanceCode) {
        this.schedulerFlowInstanceCode = schedulerFlowInstanceCode;
    }

    public String getExecutionStatus() {
        return executionStatus;
    }

    public void setExecutionStatus(String executionStatus) {
        this.executionStatus = executionStatus;
    }

    public Date getTaskStartTime() {
        return taskStartTime;
    }

    public void setTaskStartTime(Date taskStartTime) {
        this.taskStartTime = taskStartTime;
    }

    public Date getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(Date taskEndTime) {
        this.taskEndTime = taskEndTime;
    }
}
