package org.metahut.octopus.api.controller;

import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.api.dto.SchedulerCronRequestDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("scheduler")
public interface SchedulerController {

    @GetMapping("previewSchedule")
    ResultEntity previewSchedule(SchedulerCronRequestDTO schedulerCronRequestDTO);
}
