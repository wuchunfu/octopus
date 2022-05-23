package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.AlerterInstanceController;
import org.metahut.octopus.api.dto.AlerterInstanceConditionsRequestDTO;
import org.metahut.octopus.api.dto.AlerterInstanceCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.AlerterInstanceResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.server.service.AlerterInstanceService;
import org.metahut.octopus.server.utils.SnowflakeIdGenerator;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlerterInstanceControllerImpl implements AlerterInstanceController {

    private final AlerterInstanceService alerterInstanceService;

    public AlerterInstanceControllerImpl(AlerterInstanceService alerterInstanceService) {
        this.alerterInstanceService = alerterInstanceService;
    }

    @Override
    public ResultEntity queryAllPluginTypes() {
        return ResultEntity.success(alerterInstanceService.queryAllPluginTypes());
    }

    @Override
    public ResultEntity queryListPage(AlerterInstanceConditionsRequestDTO requestDTO) {
        return ResultEntity.success(alerterInstanceService.queryListPage(requestDTO));
    }

    @Override
    public ResultEntity queryList(AlerterInstanceConditionsRequestDTO requestDTO) {
        return ResultEntity.success(alerterInstanceService.queryList(requestDTO));
    }

    @Override
    public ResultEntity<AlerterInstanceResponseDTO> create(AlerterInstanceCreateOrUpdateRequestDTO requestDTO) {
        requestDTO.setCode(SnowflakeIdGenerator.getInstance().nextId());
        return ResultEntity.success(alerterInstanceService.createOrUpdate(requestDTO));
    }

    @Override
    public ResultEntity<AlerterInstanceResponseDTO> update(AlerterInstanceCreateOrUpdateRequestDTO requestDTO) {
        return ResultEntity.success(alerterInstanceService.createOrUpdate(requestDTO));
    }

    @Override
    public ResultEntity deleteById(Integer id) {
        alerterInstanceService.deleteById(id);
        return ResultEntity.success();
    }
}
