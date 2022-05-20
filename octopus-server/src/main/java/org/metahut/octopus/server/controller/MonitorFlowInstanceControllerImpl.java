package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.MonitorFlowInstanceController;
import org.metahut.octopus.api.dto.MonitorFlowInstanceConditionsRequestDTO;
import org.metahut.octopus.api.dto.MonitorFlowInstanceResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.server.service.MonitorFlowInstanceService;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonitorFlowInstanceControllerImpl implements MonitorFlowInstanceController {

    private final MonitorFlowInstanceService monitorFlowInstanceService;

    public MonitorFlowInstanceControllerImpl(MonitorFlowInstanceService monitorFlowInstanceService) {
        this.monitorFlowInstanceService = monitorFlowInstanceService;
    }

    @Override
    public ResultEntity<PageResponseDTO<MonitorFlowInstanceResponseDTO>> queryListPage(MonitorFlowInstanceConditionsRequestDTO requestDTO) {
        return ResultEntity.success(monitorFlowInstanceService.queryListPage(requestDTO));
    }

}
