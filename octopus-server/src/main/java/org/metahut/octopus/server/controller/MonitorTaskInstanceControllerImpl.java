package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.MonitorTaskInstanceController;
import org.metahut.octopus.api.dto.MonitorTaskInstanceConditionsRequestDTO;
import org.metahut.octopus.api.dto.MonitorTaskInstanceResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.server.service.MonitorTaskInstanceService;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonitorTaskInstanceControllerImpl implements MonitorTaskInstanceController {

    private final MonitorTaskInstanceService monitorTaskInstanceService;

    public MonitorTaskInstanceControllerImpl(MonitorTaskInstanceService monitorTaskInstanceService) {
        this.monitorTaskInstanceService = monitorTaskInstanceService;
    }

    @Override
    public ResultEntity<PageResponseDTO<MonitorTaskInstanceResponseDTO>> queryListPage(MonitorTaskInstanceConditionsRequestDTO requestDTO) {
        return ResultEntity.success(monitorTaskInstanceService.queryListPage(requestDTO));
    }

}
