package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.SchedulerCronRequestDTO;
import org.metahut.octopus.scheduler.api.IScheduler;
import org.metahut.octopus.scheduler.api.PageResponse;
import org.metahut.octopus.scheduler.api.entity.TaskInstance;
import org.metahut.octopus.scheduler.api.parameters.*;
import org.metahut.octopus.scheduler.dolphinscheduler.JSONUtils;
import org.metahut.octopus.server.service.SchedulerService;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SchedulerServiceImpl implements SchedulerService {

    private final IScheduler scheduler;

    public SchedulerServiceImpl(IScheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public Collection<String> previewSchedule(SchedulerCronRequestDTO schedulerCronRequestDTO) {
        ScheduleCronParameter parameter = new ScheduleCronParameter();
        parameter.setCrontab(schedulerCronRequestDTO.getCron());
        parameter.setStartTime(schedulerCronRequestDTO.getStartTime());
        parameter.setEndTime(schedulerCronRequestDTO.getEndTime());
        parameter.setTimezoneId(schedulerCronRequestDTO.getTimezoneId());
        return scheduler.previewSchedule(parameter);
    }

    @Override
    public String createSingleTaskAndAddSchedule(TaskParameter taskParameter, ScheduleParameter scheduleParameter) {
        String schedulerFlowCode = scheduler.createSingleTask(taskParameter);
        // configure a timing expression
        scheduleParameter.setFlowCode(schedulerFlowCode);
        scheduler.createSchedule(scheduleParameter);
        return schedulerFlowCode;
    }

    @Override
    public String createMetricsProductionTaskAndAddSchedule(String taskName, Long code, String cron) {
        String script = "echo '==========='";
        // create single http task
        TaskParameter taskParameter = new TaskParameter();
        taskParameter.setTaskType("SHELL");
        taskParameter.setName(taskName);
        ShellTaskParameter shellTaskParameter = new ShellTaskParameter();
        shellTaskParameter.setRawScript(script);
        taskParameter.setTaskParams(JSONUtils.toJSONString(shellTaskParameter));

        // configure a timing expression
        ScheduleParameter scheduleParameter = new ScheduleParameter();
        ScheduleCronParameter scheduleCronParameter = new ScheduleCronParameter();
        scheduleCronParameter.setCrontab(cron);
        scheduleParameter.setScheduleCronParameter(scheduleCronParameter);
        return createSingleTaskAndAddSchedule(taskParameter, scheduleParameter);
    }

    @Override
    public PageResponse<TaskInstance> queryTaskInstanceListPage(TaskInstanceRequestParameter parameter) {
        return scheduler.queryTaskInstanceListPage(parameter);
    }
}
