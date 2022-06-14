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

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
    public ResultEntity<MonitorFlowDefinitionResponseDTO> queryByCode(Long code) {
        return ResultEntity.success(monitorFlowDefinitionService.queryByCode(code));
    }

    @Override
    public ResultEntity<MonitorFlowDefinitionResponseDTO> create(MonitorFlowDefinitionCreateOrUpdateRequestDTO requestDTO) {
        if (Objects.isNull(requestDTO.getCode())) {
            requestDTO.setCode(SnowflakeIdGenerator.getInstance().nextId());
        }
        if (Objects.nonNull(requestDTO.getSampleInstance())) {
            requestDTO.getSampleInstance().setCode(SnowflakeIdGenerator.getInstance().nextId());
        }
        if (Objects.nonNull(requestDTO.getRuleInstances())) {
            requestDTO.getRuleInstances().forEach(i -> i.setCode(SnowflakeIdGenerator.getInstance().nextId()));
        }
        return ResultEntity.success(monitorFlowDefinitionService.createOrUpdate(requestDTO));
    }

    @Override
    public ResultEntity<List<MonitorFlowDefinitionResponseDTO>> batchCreate(List<MonitorFlowDefinitionCreateOrUpdateRequestDTO> requestDTOs) {
        List<MonitorFlowDefinitionResponseDTO> list = requestDTOs.stream().map(requestDTO -> {
            ResultEntity<MonitorFlowDefinitionResponseDTO> monitorFlowDefinitionResponseDTOResultEntity = create(requestDTO);
            return monitorFlowDefinitionResponseDTOResultEntity.getData();
        }).collect(Collectors.toList());
        return ResultEntity.success(list);
    }

    @Override
    public ResultEntity<MonitorFlowDefinitionResponseDTO> update(MonitorFlowDefinitionCreateOrUpdateRequestDTO requestDTO) {
        requestDTO.getRuleInstances().forEach(i -> {
            if (Objects.isNull(i.getCode())) {
                i.setCode(SnowflakeIdGenerator.getInstance().nextId());
            }
        });
        return ResultEntity.success(monitorFlowDefinitionService.createOrUpdate(requestDTO));
    }

    @Override
    public ResultEntity testRun(Long code) {
        // TODO Subsequent implementation
        return ResultEntity.success();
    }
}
