package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MonitorFlowDefinitionResponseDTO;
import org.metahut.octopus.dao.entity.FlowDefinition;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FlowDefinitionToDTOConverter extends Converter<FlowDefinition, MonitorFlowDefinitionResponseDTO> {

    List<MonitorFlowDefinitionResponseDTO> convert(List<FlowDefinition> sources);
}
