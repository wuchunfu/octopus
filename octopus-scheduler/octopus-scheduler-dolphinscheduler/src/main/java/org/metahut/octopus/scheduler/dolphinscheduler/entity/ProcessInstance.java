package org.metahut.octopus.scheduler.dolphinscheduler.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * the instance of a process
 */

@Data
public class ProcessInstance {
    /**
     * id
     */
    private int id;

    /**
     * process definition code
     */
    private Long processDefinitionCode;

    /**
     * process definition version
     */
    private int processDefinitionVersion;

    /**
     * process state
     */
    private String state;
    /**
     * recovery flag for failover
     */
    private String recovery;
    /**
     * start time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startTime;

    /**
     * end time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;

    /**
     * run time
     */
    private int runTimes;

    /**
     * name
     */
    private String name;

    /**
     * host
     */
    private String host;

    /**
     * process command type
     */
    private String commandType;

    /**
     * command parameters
     */
    private String commandParam;

    /**
     * node depend type
     */
    private String taskDependType;

    /**
     * task max try times
     */
    private int maxTryTimes;

    /**
     * failure strategy when task failed.
     */
    private String failureStrategy;

    /**
     * warning type
     */
    private String warningType;

    /**
     * warning group
     */
    private Integer warningGroupId;

    /**
     * schedule time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date scheduleTime;

    /**
     * command start time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date commandStartTime;

    /**
     * user define parameters string
     */
    private String globalParams;

    /**
     * executor id
     */
    private int executorId;

    /**
     * executor name
     */
    private String executorName;

    /**
     * tenant code
     */
    private String tenantCode;

    /**
     * queue
     */
    private String queue;

    /**
     * process is sub process
     */
    private String isSubProcess;

    /**
     * task locations for web
     */
    private String locations;

    /**
     * history command
     */
    private String historyCmd;

    /**
     * depend processes schedule time
     */
    private String dependenceScheduleTimes;

    /**
     * process duration
     *
     * @return
     */
    private String duration;

    /**
     * process instance priority
     */
    private String processInstancePriority;

    /**
     * worker group
     */
    private String workerGroup;

    /**
     * environment code
     */
    private Long environmentCode;

    /**
     * process timeout for warning
     */
    private int timeout;

    /**
     * tenant id
     */
    private int tenantId;

    /**
     * varPool string
     */
    private String varPool;
    /**
     * serial queue next processInstanceId
     */
    private int nextProcessInstanceId;

    /**
     * dry run flag
     */
    private int dryRun;

    /**
     * re-start time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date restartTime;

    /**
     * workflow block flag
     */
    private boolean isBlocked;
}
