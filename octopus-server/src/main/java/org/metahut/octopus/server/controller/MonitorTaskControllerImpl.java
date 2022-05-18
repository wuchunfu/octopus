package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.MonitorTaskController;
import org.metahut.octopus.api.dto.FlowDefinitionCreateRequestDTO;
import org.metahut.octopus.api.dto.MonitorTaskConditionsRequestDTO;
import org.metahut.octopus.api.dto.MonitorTaskResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.server.service.MonitorTaskService;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonitorTaskControllerImpl implements MonitorTaskController {

    private final MonitorTaskService monitorTaskService;

    public MonitorTaskControllerImpl(MonitorTaskService monitorTaskService) {
        this.monitorTaskService = monitorTaskService;
    }

    @Override
    public ResultEntity<PageResponseDTO<MonitorTaskResponseDTO>> queryListPage(MonitorTaskConditionsRequestDTO requestDTO) {
        return ResultEntity.success(monitorTaskService.queryListPage(requestDTO));
    }

    @Override
    public ResultEntity<MonitorTaskResponseDTO> queryById(Integer id) {
        return ResultEntity.success(monitorTaskService.queryById(id));
    }

    @Override
    public ResultEntity<MonitorTaskResponseDTO> create(FlowDefinitionCreateRequestDTO createRequest) {
        return ResultEntity.success(monitorTaskService.create(createRequest));
    }

}
