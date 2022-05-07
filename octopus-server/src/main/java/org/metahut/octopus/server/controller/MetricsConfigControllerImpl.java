package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.MetricsConfigController;
import org.metahut.octopus.api.dto.MetricsConfigConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetricsConfigCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.PageRequestDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.api.dto.response.MetricsConfigResponseDTO;
import org.metahut.octopus.api.dto.response.PageResponseDTO;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MetricsConfigControllerImpl implements MetricsConfigController {

    @Override
    public ResultEntity<List<MetricsConfigResponseDTO>> queryAll() {
        return ResultEntity.success();
    }

    @Override
    public ResultEntity<PageResponseDTO<MetricsConfigResponseDTO>> queryListPage(PageRequestDTO<MetricsConfigConditionsRequestDTO> pageRequestDTO) {
        return ResultEntity.success();
    }

    @Override
    public ResultEntity<MetricsConfigResponseDTO> create(MetricsConfigCreateOrUpdateRequestDTO metricsConfigCreateOrUpdateRequestDTO) {
        return ResultEntity.success();
    }

    @Override
    public ResultEntity<MetricsConfigResponseDTO> update(MetricsConfigCreateOrUpdateRequestDTO metricsConfigCreateOrUpdateRequestDTO) {
        return ResultEntity.success();
    }

    @Override
    public ResultEntity deleteById(Integer id) {
        return ResultEntity.success();
    }
}
