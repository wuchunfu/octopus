package org.metahut.octopus.scheduler.api.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TaskInstance {
    private int id;
    private String name;
    private int flowInstanceId;
    private String flowCode;
    private String state;
    private Date startTime;
    private Date endTime;
}
