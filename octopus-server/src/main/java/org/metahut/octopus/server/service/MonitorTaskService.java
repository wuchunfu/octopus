package org.metahut.octopus.server.service;

import org.metahut.octopus.api.dto.FlowDefinitionCreateRequestDTO;
import org.metahut.octopus.api.dto.MonitorTaskConditionsRequestDTO;
import org.metahut.octopus.api.dto.MonitorTaskResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;

public interface MonitorTaskService {
    PageResponseDTO<MonitorTaskResponseDTO> queryListPage(MonitorTaskConditionsRequestDTO requestDTO);

    MonitorTaskResponseDTO queryById(Integer id);

    MonitorTaskResponseDTO create(FlowDefinitionCreateRequestDTO createRequest);

}
