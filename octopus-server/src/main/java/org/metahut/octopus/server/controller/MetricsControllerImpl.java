package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.MetricsController;
import org.metahut.octopus.api.dto.MetricsConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetricsCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.server.service.MetricsService;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MetricsControllerImpl implements MetricsController {

    private final MetricsService metricsService;

    public MetricsControllerImpl(MetricsService metricsService) {
        this.metricsService = metricsService;
    }

    @Override
    public ResultEntity<List<MetricsResponseDTO>> queryAll(MetricsConditionsRequestDTO requestDTO) {
        return ResultEntity.success(metricsService.findAll(requestDTO));
    }

    @Override
    public ResultEntity<PageResponseDTO<MetricsResponseDTO>> queryListPage(MetricsConditionsRequestDTO metricsConditionsRequestDTO) {
        return ResultEntity.success();
    }

    @Override
    public ResultEntity<MetricsResponseDTO> create(MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO) {
        return ResultEntity.success();
    }

    @Override
    public ResultEntity<MetricsResponseDTO> update(MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO) {
        return ResultEntity.success();
    }

    @Override
    public ResultEntity deleteById(Integer id) {
        return ResultEntity.success();
    }
}
