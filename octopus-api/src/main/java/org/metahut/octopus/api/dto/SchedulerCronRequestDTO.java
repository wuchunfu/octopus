package org.metahut.octopus.api.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

import java.util.Date;

public class SchedulerCronRequestDTO {

    private Date startTime;
    private Date endTime;

    @ApiModelProperty(value = "schedule cron")
    @NotEmpty(message = "{parameter.not.null}")
    private String cron;
    private String timezoneId;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public String getTimezoneId() {
        return timezoneId;
    }

    public void setTimezoneId(String timezoneId) {
        this.timezoneId = timezoneId;
    }
}
