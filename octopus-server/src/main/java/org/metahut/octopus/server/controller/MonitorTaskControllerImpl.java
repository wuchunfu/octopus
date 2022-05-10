package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.MonitorTaskController;
import org.metahut.octopus.api.dto.MonitorTaskConditionsRequestDTO;
import org.metahut.octopus.api.dto.MonitorTaskResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonitorTaskControllerImpl implements MonitorTaskController {

    @Override
    public ResultEntity<PageResponseDTO<MonitorTaskResponseDTO>> queryListPage(MonitorTaskConditionsRequestDTO requestDTO) {
        return ResultEntity.success();
    }

    @Override
    public ResultEntity<MonitorTaskResponseDTO> queryById(Integer id) {
        return ResultEntity.success();
    }

}
