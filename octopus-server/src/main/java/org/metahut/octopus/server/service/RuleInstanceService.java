package org.metahut.octopus.server.service;

import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.RuleInstanceConditionRequestDTO;
import org.metahut.octopus.api.dto.RuleInstanceResponseDTO;
import org.metahut.octopus.api.dto.RuleInstanceSingleCreateOrUpdateRequestDTO;

public interface RuleInstanceService {

    PageResponseDTO<RuleInstanceResponseDTO> queryListPage(RuleInstanceConditionRequestDTO requestDTO);

    RuleInstanceResponseDTO createOrUpdate(RuleInstanceSingleCreateOrUpdateRequestDTO requestDTO);

    void deleteById(Integer id);
}
