package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.MonitorLogController;
import org.metahut.octopus.api.dto.MonitorLogConditionsRequestDTO;
import org.metahut.octopus.api.dto.MonitorLogResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.server.service.MonitorDBService;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MonitorLogControllerImpl implements MonitorLogController {

    private final MonitorDBService monitorDBService;

    public MonitorLogControllerImpl(MonitorDBService monitorDBService) {
        this.monitorDBService = monitorDBService;
    }

    @Override
    public ResultEntity<List<MonitorLogResponseDTO>> queryAll(MonitorLogConditionsRequestDTO request) {
        return ResultEntity.success(monitorDBService.monitorLogQueryAll(request));
    }

    @Override
    public ResultEntity<PageResponseDTO<MonitorLogResponseDTO>> queryListPage(MonitorLogConditionsRequestDTO request) {
        return ResultEntity.success(monitorDBService.monitorLogQueryListPage(request));
    }

    @Override
    public ResultEntity<MonitorLogResponseDTO> queryById(Integer id) {
        return ResultEntity.success(monitorDBService.monitorLogQueryById(id));
    }
}
