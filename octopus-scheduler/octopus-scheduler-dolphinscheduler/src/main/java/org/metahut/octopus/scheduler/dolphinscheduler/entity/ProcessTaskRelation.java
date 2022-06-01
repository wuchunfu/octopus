package org.metahut.octopus.scheduler.dolphinscheduler.entity;

import lombok.Data;

import java.util.Date;

/**
 * the relation between those tasks in a process
 */

@Data
public class ProcessTaskRelation {

    /**
     * id
     */
    private int id;

    /**
     * name
     */
    private String name;

    /**
     * process version
     */
    private int processDefinitionVersion;

    /**
     * project code
     */
    private long projectCode;

    /**
     * process code
     */
    private long processDefinitionCode;

    /**
     * pre task code
     */
    private long preTaskCode;

    /**
     * pre node version
     */
    private int preTaskVersion;

    /**
     * post task code
     */
    private long postTaskCode;

    /**
     * post node version
     */
    private int postTaskVersion;

    /**
     * condition type
     */
    // private ConditionType conditionType;

    /**
     * condition parameters
     */
    private String conditionParams;

    /**
     * create time
     */
    private Date createTime;

    /**
     * update time
     */
    private Date updateTime;
}
