package org.metahut.octopus.server.service;

import org.metahut.octopus.api.dto.MetricsConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetricsCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.dao.entity.Metrics;

import java.util.List;

public interface MetricsService {

    Metrics findOneByCode(String metricsCode);

    List<MetricsResponseDTO> findList(MetricsConditionsRequestDTO requestDTO);

    PageResponseDTO<MetricsResponseDTO> queryListPage(MetricsConditionsRequestDTO requestDTO);

    MetricsResponseDTO createOrUpdate(MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO);

    void deleteById(Integer id);
}
