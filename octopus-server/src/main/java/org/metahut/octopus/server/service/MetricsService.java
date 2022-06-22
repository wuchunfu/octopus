package org.metahut.octopus.server.service;

import org.metahut.octopus.api.dto.MetricsConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetricsCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.dao.entity.Metrics;

import java.util.List;

public interface MetricsService {

    Metrics findOneByCode(String metricsCode);

    MetricsResponseDTO findByCode(String metricsCode);

    List<MetricsResponseDTO> findList(MetricsConditionsRequestDTO requestDTO);

    PageResponseDTO<MetricsResponseDTO> queryListPage(MetricsConditionsRequestDTO requestDTO);

    MetricsResponseDTO create(MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO);

    MetricsResponseDTO update(MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO);

    void deleteById(Integer id);
}
