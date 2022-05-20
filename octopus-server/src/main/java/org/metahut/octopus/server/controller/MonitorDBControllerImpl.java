package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.MonitorDBController;
import org.metahut.octopus.api.dto.MetricsResultConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetricsResultResponseDTO;
import org.metahut.octopus.api.dto.MonitorLogConditionsRequestDTO;
import org.metahut.octopus.api.dto.MonitorLogResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.server.service.MonitorDBService;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MonitorDBControllerImpl implements MonitorDBController {

    private final MonitorDBService monitorDBService;

    public MonitorDBControllerImpl(MonitorDBService monitorDBService) {
        this.monitorDBService = monitorDBService;
    }

    @Override
    public ResultEntity<List<Map<String, Object>>> customSQLQuery(String sql) {
        return ResultEntity.success(monitorDBService.customSQLQuery(sql));
    }

    @Override
    public ResultEntity<PageResponseDTO<MonitorLogResponseDTO>> queryMonitorLogListPage(MonitorLogConditionsRequestDTO requestDTO) {
        return ResultEntity.success(monitorDBService.queryMonitorLogListPage(requestDTO));
    }

    @Override
    public ResultEntity<PageResponseDTO<MetricsResultResponseDTO>> queryMetricsResultListPage(MetricsResultConditionsRequestDTO requestDTO) {
        return ResultEntity.success(monitorDBService.queryMetricsResultListPage(requestDTO));
    }
}
