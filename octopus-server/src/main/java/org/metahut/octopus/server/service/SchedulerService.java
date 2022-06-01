package org.metahut.octopus.server.service;

import org.metahut.octopus.api.dto.SchedulerCronRequestDTO;
import org.metahut.octopus.scheduler.api.PageResponse;
import org.metahut.octopus.scheduler.api.entity.TaskInstance;
import org.metahut.octopus.scheduler.api.parameters.ScheduleParameter;
import org.metahut.octopus.scheduler.api.parameters.TaskInstanceRequestParameter;
import org.metahut.octopus.scheduler.api.parameters.TaskParameter;

import java.util.Collection;

public interface SchedulerService {

    Collection<String> previewSchedule(SchedulerCronRequestDTO schedulerCronRequestDTO);

    String createSingleTaskAndAddSchedule(TaskParameter taskParameter, ScheduleParameter scheduleParameter);

    String createMetricsProductionTaskAndAddSchedule(String taskName, Long code, String cron);

    PageResponse<TaskInstance> queryTaskInstanceListPage(TaskInstanceRequestParameter parameter);
}
