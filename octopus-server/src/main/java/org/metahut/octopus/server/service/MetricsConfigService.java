package org.metahut.octopus.server.service;

import org.metahut.octopus.api.dto.MetricsConfigConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetricsConfigCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsConfigResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.dao.entity.MetricsConfig;

import java.util.List;

public interface MetricsConfigService {
    List<MetricsConfigResponseDTO> findList(MetricsConfigConditionsRequestDTO requestDTO);

    PageResponseDTO<MetricsConfigResponseDTO> queryListPage(MetricsConfigConditionsRequestDTO requestDTO);

    MetricsConfigResponseDTO create(MetricsConfigCreateOrUpdateRequestDTO metricsConfigCreateOrUpdateRequestDTO);

    MetricsConfigResponseDTO update(MetricsConfigCreateOrUpdateRequestDTO metricsConfigCreateOrUpdateRequestDTO);

    void deleteById(Integer id);

    MetricsConfigResponseDTO findByCode(Long metricsConfigCode);

    MetricsConfig findOneByCode(Long metricsConfigCode);

    long count(MetricsConfigConditionsRequestDTO requestDTO);
}
