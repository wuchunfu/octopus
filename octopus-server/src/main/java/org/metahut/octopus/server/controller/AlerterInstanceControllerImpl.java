package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.AlerterInstanceController;
import org.metahut.octopus.api.dto.AlerterInstanceConditionsRequestDTO;
import org.metahut.octopus.api.dto.PageRequestDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.server.service.AlerterInstanceService;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlerterInstanceControllerImpl implements AlerterInstanceController {

    private AlerterInstanceService alerterInstanceService;

    public AlerterInstanceControllerImpl(AlerterInstanceService alerterInstanceService) {
        this.alerterInstanceService = alerterInstanceService;
    }

    @Override
    public ResultEntity queryAllTypes() {
        return ResultEntity.success(alerterInstanceService.queryAllTypes());
    }

    @Override
    public ResultEntity queryListPage(PageRequestDTO<AlerterInstanceConditionsRequestDTO> pageRequestDTO) {
        return ResultEntity.success(alerterInstanceService.queryListPage(pageRequestDTO));
    }

    @Override
    public ResultEntity queryList(AlerterInstanceConditionsRequestDTO alerterInstanceConditionsRequestDTO) {
        return ResultEntity.success(alerterInstanceService.queryList(alerterInstanceConditionsRequestDTO));
    }
}
