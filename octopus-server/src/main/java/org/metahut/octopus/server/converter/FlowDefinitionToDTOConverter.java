package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MonitorTaskResponseDTO;
import org.metahut.octopus.dao.entity.FlowDefinition;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface FlowDefinitionToDTOConverter extends Converter<FlowDefinition, MonitorTaskResponseDTO> {
}
