package org.metahut.octopus.api.dto;

import org.metahut.octopus.common.enums.MonitorTaskStatusEnum;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class MonitorTaskResponseDTO {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "data soucre instance name")
    private String sourceName;

    @ApiModelProperty(value = "data set name")
    private String sourceCode;

    @ApiModelProperty(value = "task name")
    private String taskName;

    @ApiModelProperty(value = "task status")
    private MonitorTaskStatusEnum taskStatus;

    @ApiModelProperty(value = "alarm group")
    private String alarmGroup;

    @ApiModelProperty(value = "task start time")
    private Date taskStartTime;

    @ApiModelProperty(value = "task end time")
    private Date taskEndTime;

    @ApiModelProperty(value = "crontab")
    private String crontab;

    @ApiModelProperty(value = "task execution description")
    private String taskExecDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
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

    public String getCrontab() {
        return crontab;
    }

    public void setCrontab(String crontab) {
        this.crontab = crontab;
    }

    public String getTaskExecDesc() {
        return taskExecDesc;
    }

    public void setTaskExecDesc(String taskExecDesc) {
        this.taskExecDesc = taskExecDesc;
    }
}
