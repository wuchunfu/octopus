package org.metahut.octopus.server.service;

import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.RuleTemplateRequestDTO;
import org.metahut.octopus.api.dto.RuleTemplateResponseDTO;

public interface RuleTemplateService {

    PageResponseDTO<RuleTemplateResponseDTO> queryListPage(RuleTemplateRequestDTO ruleTemplateRequestDTO);

    RuleTemplateResponseDTO createOrUpdate(RuleTemplateRequestDTO ruleTemplateRequestDTO);

    void deleteById(Integer id);
}
