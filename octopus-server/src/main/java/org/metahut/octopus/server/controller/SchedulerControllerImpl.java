package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.SchedulerController;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.api.dto.SchedulerCronRequestDTO;
import org.metahut.octopus.server.service.SchedulerService;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchedulerControllerImpl implements SchedulerController {

    private final SchedulerService schedulerService;

    public SchedulerControllerImpl(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @Override
    public ResultEntity previewSchedule(SchedulerCronRequestDTO schedulerCronRequestDTO) {
        return ResultEntity.success(schedulerService.previewSchedule(schedulerCronRequestDTO));
    }
}
