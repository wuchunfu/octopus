package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.MetricsResultController;
import org.metahut.octopus.api.dto.MetricsResultConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetricsResultResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.server.service.MonitorDBService;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MetricsResultControllerImpl implements MetricsResultController {

    private final MonitorDBService monitorDBService;

    public MetricsResultControllerImpl(MonitorDBService monitorDBService) {
        this.monitorDBService = monitorDBService;
    }

    @Override
    public ResultEntity<List<MetricsResultResponseDTO>> queryAll(MetricsResultConditionsRequestDTO request) {
        return ResultEntity.success(monitorDBService.metricsResultQueryAll(request));
    }

    @Override
    public ResultEntity<PageResponseDTO<MetricsResultResponseDTO>> queryListPage(MetricsResultConditionsRequestDTO request) {
        return ResultEntity.success(monitorDBService.metricsResultQueryListPage(request));
    }
}
