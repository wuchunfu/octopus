package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.MonitorFlowDefinitionController;
import org.metahut.octopus.api.dto.MonitorFlowDefinitionConditionsRequestDTO;
import org.metahut.octopus.api.dto.MonitorFlowDefinitionCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MonitorFlowDefinitionResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.server.service.MonitorFlowDefinitionService;
import org.metahut.octopus.server.utils.SnowflakeIdGenerator;

import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class MonitorFlowDefinitionControllerImpl implements MonitorFlowDefinitionController {

    private final MonitorFlowDefinitionService monitorFlowDefinitionService;

    public MonitorFlowDefinitionControllerImpl(MonitorFlowDefinitionService monitorFlowDefinitionService) {
        this.monitorFlowDefinitionService = monitorFlowDefinitionService;
    }

    @Override
    public ResultEntity<PageResponseDTO<MonitorFlowDefinitionResponseDTO>> queryListPage(MonitorFlowDefinitionConditionsRequestDTO requestDTO) {
        return ResultEntity.success(monitorFlowDefinitionService.queryListPage(requestDTO));
    }

    @Override
    public ResultEntity deleteById(Integer id) {
        // delete flow definition and rule instances and alert instance relations and sample instance
        monitorFlowDefinitionService.deleteById(id);
        return ResultEntity.success();
    }

    @Override
    public ResultEntity<MonitorFlowDefinitionResponseDTO> create(MonitorFlowDefinitionCreateOrUpdateRequestDTO requestDTO) {
        requestDTO.setCode(SnowflakeIdGenerator.getInstance().nextId());
        if(Objects.nonNull(requestDTO.getSampleInstance())) {
            requestDTO.getSampleInstance().setCode(SnowflakeIdGenerator.getInstance().nextId());
        }
        return ResultEntity.success(monitorFlowDefinitionService.createOrUpdate(requestDTO));
    }

    @Override
    public ResultEntity<MonitorFlowDefinitionResponseDTO> update(MonitorFlowDefinitionCreateOrUpdateRequestDTO requestDTO) {
        return ResultEntity.success(monitorFlowDefinitionService.createOrUpdate(requestDTO));
    }

    @Override
    public ResultEntity testRun(Long code) {
        // TODO Subsequent implementation
        return ResultEntity.success();
    }
}
