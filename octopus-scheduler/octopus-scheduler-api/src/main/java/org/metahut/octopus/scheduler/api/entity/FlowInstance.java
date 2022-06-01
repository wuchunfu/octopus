package org.metahut.octopus.scheduler.api.entity;

import lombok.Data;

import java.util.Date;

/**
 * the instance of a flow
 */

@Data
public class FlowInstance {
    /**
     * id
     */
    private int id;

    /**
     * the flow code
     */
    private Long flowCode;

    /**
     * flow instance state
     */
    private String state;

    /**
     * start time
     */
    private Date startTime;

    /**
     * end time
     */
    private Date endTime;

    /**
     * name
     */
    private String name;

    /**
     * description
     */
    private String desc;

    /**
     * schedule time
     */
    private Date scheduleTime;

    /**
     * re-start time
     */
    private Date restartTime;
}
