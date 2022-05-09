package org.metahut.octopus.server.service;

import org.metahut.octopus.api.dto.MetricsConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetricsResponseDTO;

import java.util.List;

public interface MetricsService {

    List<MetricsResponseDTO> findAll(MetricsConditionsRequestDTO requestDTO);
}
