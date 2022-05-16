package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.MetricsConfigController;
import org.metahut.octopus.api.dto.MetricsConfigConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetricsConfigCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsConfigResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.server.service.MetricsConfigService;
import org.metahut.octopus.server.utils.SnowflakeIdGenerator;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MetricsConfigControllerImpl implements MetricsConfigController {

    private final MetricsConfigService metricsConfigService;

    public MetricsConfigControllerImpl(MetricsConfigService metricsConfigService) {
        this.metricsConfigService = metricsConfigService;
    }

    @Override
    public ResultEntity<List<MetricsConfigResponseDTO>> queryList(MetricsConfigConditionsRequestDTO metricsConfigConditionsRequestDTO) {
        return ResultEntity.success(metricsConfigService.findList(metricsConfigConditionsRequestDTO));
    }

    @Override
    public ResultEntity<PageResponseDTO<MetricsConfigResponseDTO>> queryListPage(MetricsConfigConditionsRequestDTO metricsConfigConditionsRequestDTO) {
        return ResultEntity.success(metricsConfigService.queryListPage(metricsConfigConditionsRequestDTO));
    }

    @Override
    public ResultEntity<MetricsConfigResponseDTO> create(MetricsConfigCreateOrUpdateRequestDTO metricsConfigCreateOrUpdateRequestDTO) {
        metricsConfigCreateOrUpdateRequestDTO.setCode(SnowflakeIdGenerator.getInstance().nextId());
        return ResultEntity.success(metricsConfigService.createOrUpdate(metricsConfigCreateOrUpdateRequestDTO));
    }

    @Override
    public ResultEntity<MetricsConfigResponseDTO> update(MetricsConfigCreateOrUpdateRequestDTO metricsConfigCreateOrUpdateRequestDTO) {
        return ResultEntity.success(metricsConfigService.createOrUpdate(metricsConfigCreateOrUpdateRequestDTO));
    }

    @Override
    public ResultEntity deleteById(Integer id) {
        metricsConfigService.deleteById(id);
        return ResultEntity.success();
    }

    @Override
    public ResultEntity<MetricsConfigResponseDTO> findByCode(Long code) {
        return ResultEntity.success(metricsConfigService.findByCode(code));
    }
}
