package org.metahut.octopus.api.dto;

import org.metahut.octopus.common.enums.MonitorTaskStatusEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description = "monitor task conditions request dto")
public class MonitorTaskConditionsRequestDTO extends PageRequestDTO {

    @ApiModelProperty(value = "data soucre instance name")
    private String datasourceName;

    @ApiModelProperty(value = "data set name")
    private String datasetName;

    @ApiModelProperty(value = "task name")
    private String taskName;

    @ApiModelProperty(value = "task status")
    private MonitorTaskStatusEnum taskStatus;

    @ApiModelProperty(value = "alarm group")
    private String alarmGroup;

    @ApiModelProperty(value = "startTask start time")
    private Date startTaskStartTime;

    @ApiModelProperty(value = "startTask end time")
    private Date startTaskEndTime;

    @ApiModelProperty(value = "endTask start time")
    private Date endTaskStartTime;

    @ApiModelProperty(value = "endTask end time")
    private Date endTaskEndTime;

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

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public MonitorTaskStatusEnum getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(MonitorTaskStatusEnum taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getAlarmGroup() {
        return alarmGroup;
    }

    public void setAlarmGroup(String alarmGroup) {
        this.alarmGroup = alarmGroup;
    }

    public Date getStartTaskStartTime() {
        return startTaskStartTime;
    }

    public void setStartTaskStartTime(Date startTaskStartTime) {
        this.startTaskStartTime = startTaskStartTime;
    }

    public Date getStartTaskEndTime() {
        return startTaskEndTime;
    }

    public void setStartTaskEndTime(Date startTaskEndTime) {
        this.startTaskEndTime = startTaskEndTime;
    }

    public Date getEndTaskStartTime() {
        return endTaskStartTime;
    }

    public void setEndTaskStartTime(Date endTaskStartTime) {
        this.endTaskStartTime = endTaskStartTime;
    }

    public Date getEndTaskEndTime() {
        return endTaskEndTime;
    }

    public void setEndTaskEndTime(Date endTaskEndTime) {
        this.endTaskEndTime = endTaskEndTime;
    }
}
