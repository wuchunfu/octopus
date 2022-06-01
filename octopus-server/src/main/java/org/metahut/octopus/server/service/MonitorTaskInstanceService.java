package org.metahut.octopus.server.service;

import org.metahut.octopus.api.dto.MonitorTaskInstanceConditionsRequestDTO;
import org.metahut.octopus.api.dto.MonitorTaskInstanceResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;

public interface MonitorTaskInstanceService {
    PageResponseDTO<MonitorTaskInstanceResponseDTO> queryListPage(MonitorTaskInstanceConditionsRequestDTO requestDTO);

}
