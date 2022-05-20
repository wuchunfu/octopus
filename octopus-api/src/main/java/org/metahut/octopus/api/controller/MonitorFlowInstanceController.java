package org.metahut.octopus.api.controller;

import org.metahut.octopus.api.dto.MonitorFlowInstanceConditionsRequestDTO;
import org.metahut.octopus.api.dto.MonitorFlowInstanceResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;

import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "MONITOR_FLOW_INSTANCE_TAG")
@RequestMapping("monitorFlowInstance")
@Validated
public interface MonitorFlowInstanceController {
    ResultEntity<PageResponseDTO<MonitorFlowInstanceResponseDTO>> queryListPage(MonitorFlowInstanceConditionsRequestDTO requestDTO);
}
