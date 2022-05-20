package org.metahut.octopus.server.service;

import org.metahut.octopus.api.dto.MonitorFlowDefinitionConditionsRequestDTO;
import org.metahut.octopus.api.dto.MonitorFlowDefinitionCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MonitorFlowDefinitionResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;

public interface MonitorFlowDefinitionService {
    PageResponseDTO<MonitorFlowDefinitionResponseDTO> queryListPage(MonitorFlowDefinitionConditionsRequestDTO requestDTO);

    MonitorFlowDefinitionResponseDTO createOrUpdate(MonitorFlowDefinitionCreateOrUpdateRequestDTO requestDTO);

    void deleteById(Integer id);
}
