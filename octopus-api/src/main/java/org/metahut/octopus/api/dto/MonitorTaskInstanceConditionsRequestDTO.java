package org.metahut.octopus.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description = "monitor task instance conditions request dto")
public class MonitorTaskInstanceConditionsRequestDTO extends PageRequestDTO {

    @ApiModelProperty(value = "datasource code")
    private String datasourceCode;

    @ApiModelProperty(value = "dataset code")
    private String datasetCode;

    @ApiModelProperty(value = "flow name")
    private String flowName;

    @ApiModelProperty(value = "execution status")
    private String executionStatus;

    @ApiModelProperty(value = "startTask start time")
    private Date taskStartStartTime;

    @ApiModelProperty(value = "startTask end time")
    private Date taskStartEndTime;

    public String getDatasourceCode() {
        return datasourceCode;
    }

    public void setDatasourceCode(String datasourceCode) {
        this.datasourceCode = datasourceCode;
    }

    public String getDatasetCode() {
        return datasetCode;
    }

    public void setDatasetCode(String datasetCode) {
        this.datasetCode = datasetCode;
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

}
