package org.metahut.octopus.scheduler.dolphinscheduler.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class DolphinTaskInstance {
    private int id;
    private String name;
    private String taskType;
    private int processInstanceId;
    private long taskCode;
    private String state;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", timezone = "GMT+8")
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", timezone = "GMT+8")
    private Date endTime;
}
