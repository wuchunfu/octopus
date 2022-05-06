package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.MetricsConfigController;
import org.metahut.octopus.api.dto.MetricsConfigConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetricsConfigCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.PageRequestDTO;
import org.metahut.octopus.api.dto.ResultEntity;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetricsConfigControllerImpl implements MetricsConfigController {

    @Override
    public ResultEntity queryAll() {
        return ResultEntity.success();
    }

    @Override
    public ResultEntity queryListPage(PageRequestDTO<MetricsConfigConditionsRequestDTO> pageRequestDTO) {
        return ResultEntity.success();
    }

    @Override
    public ResultEntity create(MetricsConfigCreateOrUpdateRequestDTO metricsConfigCreateOrUpdateRequestDTO) {
        return ResultEntity.success();
    }

    @Override
    public ResultEntity update(MetricsConfigCreateOrUpdateRequestDTO metricsConfigCreateOrUpdateRequestDTO) {
        return ResultEntity.success();
    }

    @Override
    public ResultEntity deleteById(Integer id) {
        return ResultEntity.success();
    }
}
