package org.metahut.octopus.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description = "monitor flow instance conditions request dto")
public class MonitorFlowInstanceConditionsRequestDTO extends PageRequestDTO {

    @ApiModelProperty(value = "data source instance name")
    private String datasourceName;

    @ApiModelProperty(value = "data set name")
    private String datasetName;

    @ApiModelProperty(value = "flow name")
    private String flowName;

    private String executionStatus;

    @ApiModelProperty(value = "startTask start time")
    private Date taskStartStartTime;

    @ApiModelProperty(value = "startTask end time")
    private Date taskStartEndTime;

    @ApiModelProperty(value = "endTask start time")
    private Date taskEndStartTime;

    @ApiModelProperty(value = "endTask end time")
    private Date taskEndEndTime;

    public String getDatasourceName() {
        return datasourceName;
    }

    public void setDatasourceName(String datasourceName) {
        this.datasourceName = datasourceName;
    }

    public String getDatasetName() {
        return datasetName;
    }

    public void setDatasetName(String datasetName) {
        this.datasetName = datasetName;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    public String getExecutionStatus() {
        return executionStatus;
    }

    public void setExecutionStatus(String executionStatus) {
        this.executionStatus = executionStatus;
    }

    public Date getTaskStartStartTime() {
        return taskStartStartTime;
    }

    public void setTaskStartStartTime(Date taskStartStartTime) {
        this.taskStartStartTime = taskStartStartTime;
    }

    public Date getTaskStartEndTime() {
        return taskStartEndTime;
    }

    public void setTaskStartEndTime(Date taskStartEndTime) {
        this.taskStartEndTime = taskStartEndTime;
    }

    public Date getTaskEndStartTime() {
        return taskEndStartTime;
    }

    public void setTaskEndStartTime(Date taskEndStartTime) {
        this.taskEndStartTime = taskEndStartTime;
    }

    public Date getTaskEndEndTime() {
        return taskEndEndTime;
    }

    public void setTaskEndEndTime(Date taskEndEndTime) {
        this.taskEndEndTime = taskEndEndTime;
    }
}
