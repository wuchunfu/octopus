package org.metahut.octopus.server.service;

import org.metahut.octopus.api.dto.MonitorFlowInstanceConditionsRequestDTO;
import org.metahut.octopus.api.dto.MonitorFlowInstanceResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;

public interface MonitorFlowInstanceService {
    PageResponseDTO<MonitorFlowInstanceResponseDTO> queryListPage(MonitorFlowInstanceConditionsRequestDTO requestDTO);

}
