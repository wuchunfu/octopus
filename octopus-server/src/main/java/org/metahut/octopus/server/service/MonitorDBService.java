package org.metahut.octopus.server.service;

import org.metahut.octopus.api.dto.MetricsResultConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetricsResultResponseDTO;
import org.metahut.octopus.api.dto.MonitorLogConditionsRequestDTO;
import org.metahut.octopus.api.dto.MonitorLogResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;

import java.util.List;
import java.util.Map;

public interface MonitorDBService {

    List<Map<String, Object>> customSQLQuery(String sql);

    PageResponseDTO<MonitorLogResponseDTO> queryMonitorLogListPage(MonitorLogConditionsRequestDTO requestDTO);

    PageResponseDTO<MetricsResultResponseDTO> queryMetricsResultListPage(MetricsResultConditionsRequestDTO requestDTO);
}
