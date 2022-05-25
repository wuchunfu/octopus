package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.AlerterSourceController;
import org.metahut.octopus.api.dto.AlerterSourceConditionsRequestDTO;
import org.metahut.octopus.api.dto.AlerterSourceCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.AlerterSourceResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.server.service.AlerterSourceService;
import org.metahut.octopus.server.utils.SnowflakeIdGenerator;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlerterSourceControllerImpl implements AlerterSourceController {

    private final AlerterSourceService alerterSourceService;

    public AlerterSourceControllerImpl(AlerterSourceService alerterSourceService) {
        this.alerterSourceService = alerterSourceService;
    }

    @Override
    public ResultEntity queryAllPluginTypes() {
        return ResultEntity.success(alerterSourceService.queryAllPluginTypes());
    }

    @Override
    public ResultEntity queryListPage(AlerterSourceConditionsRequestDTO requestDTO) {
        return ResultEntity.success(alerterSourceService.queryListPage(requestDTO));
    }

    @Override
    public ResultEntity queryList(AlerterSourceConditionsRequestDTO requestDTO) {
        return ResultEntity.success(alerterSourceService.queryList(requestDTO));
    }

    @Override
    public ResultEntity<AlerterSourceResponseDTO> create(AlerterSourceCreateOrUpdateRequestDTO requestDTO) {
        requestDTO.setCode(SnowflakeIdGenerator.getInstance().nextId());
        return ResultEntity.success(alerterSourceService.createOrUpdate(requestDTO));
    }

    @Override
    public ResultEntity<AlerterSourceResponseDTO> update(AlerterSourceCreateOrUpdateRequestDTO requestDTO) {
        return ResultEntity.success(alerterSourceService.createOrUpdate(requestDTO));
    }

    @Override
    public ResultEntity deleteById(Integer id) {
        alerterSourceService.deleteById(id);
        return ResultEntity.success();
    }
}
