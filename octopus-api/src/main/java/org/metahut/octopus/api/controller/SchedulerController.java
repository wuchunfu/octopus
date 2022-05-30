package org.metahut.octopus.api.controller;

import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.api.dto.SchedulerCronRequestDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "SCHEDULER_TAG")
@RequestMapping("scheduler")
public interface SchedulerController {

    @ApiOperation(value = "previewSchedule", notes = "SCHEDULER_PREVIEW_SCHEDULE_NOTES")
    @GetMapping("previewSchedule")
    ResultEntity previewSchedule(SchedulerCronRequestDTO schedulerCronRequestDTO);
}
