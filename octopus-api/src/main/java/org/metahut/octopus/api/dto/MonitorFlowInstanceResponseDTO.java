package org.metahut.octopus.api.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class MonitorFlowInstanceResponseDTO {

    @ApiModelProperty(value = "datasource code")
    private MonitorFlowDefinitionResponseDTO flowDefinition;

    @ApiModelProperty(value = "datasource code")
    private String schedulerInstanceCode;

    @ApiModelProperty(value = "datasource code")
    private String schedulerInstanceName;

    @ApiModelProperty(value = "executionStatus")
    private String executionStatus;

    @ApiModelProperty(value = "taskBeginTime")
    private Date taskBeginTime;

    @ApiModelProperty(value = "taskEndTime")
    private Date taskEndTime;

    public MonitorFlowDefinitionResponseDTO getFlowDefinition() {
        return flowDefinition;
    }

    public void setFlowDefinition(MonitorFlowDefinitionResponseDTO flowDefinition) {
        this.flowDefinition = flowDefinition;
    }

    public String getSchedulerInstanceCode() {
        return schedulerInstanceCode;
    }

    public void setSchedulerInstanceCode(String schedulerInstanceCode) {
        this.schedulerInstanceCode = schedulerInstanceCode;
    }

    public String getSchedulerInstanceName() {
        return schedulerInstanceName;
    }

    public void setSchedulerInstanceName(String schedulerInstanceName) {
        this.schedulerInstanceName = schedulerInstanceName;
    }

    public String getExecutionStatus() {
        return executionStatus;
    }

    public void setExecutionStatus(String executionStatus) {
        this.executionStatus = executionStatus;
    }

    public Date getTaskBeginTime() {
        return taskBeginTime;
    }

    public void setTaskBeginTime(Date taskBeginTime) {
        this.taskBeginTime = taskBeginTime;
    }

    public Date getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(Date taskEndTime) {
        this.taskEndTime = taskEndTime;
    }
}
