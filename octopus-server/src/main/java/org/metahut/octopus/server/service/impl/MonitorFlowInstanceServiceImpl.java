package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.MonitorFlowInstanceConditionsRequestDTO;
import org.metahut.octopus.api.dto.MonitorFlowInstanceResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.dao.repository.FlowDefinitionRepository;
import org.metahut.octopus.server.service.MonitorFlowInstanceService;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class MonitorFlowInstanceServiceImpl implements MonitorFlowInstanceService {

    private final FlowDefinitionRepository flowDefinitionRepository;
    private final ConversionService conversionService;

    public MonitorFlowInstanceServiceImpl(FlowDefinitionRepository flowDefinitionRepository, ConversionService conversionService) {
        this.flowDefinitionRepository = flowDefinitionRepository;
        this.conversionService = conversionService;
    }

    @Override
    public PageResponseDTO<MonitorFlowInstanceResponseDTO> queryListPage(MonitorFlowInstanceConditionsRequestDTO requestDTO) {

        return null;
    }

}
