package org.metahut.octopus.server.service;

import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.RuleInstanceConditionRequestDTO;
import org.metahut.octopus.api.dto.RuleInstanceCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.RuleInstanceResponseDTO;

import java.util.List;

public interface RuleInstanceService {

    PageResponseDTO<RuleInstanceResponseDTO> queryListPage(RuleInstanceConditionRequestDTO requestDTO);

    List<RuleInstanceResponseDTO> batchCreate(List<RuleInstanceCreateOrUpdateRequestDTO> requestDTOs);

    RuleInstanceResponseDTO update(RuleInstanceCreateOrUpdateRequestDTO requestDTO);

    void deleteById(Integer id);
}
