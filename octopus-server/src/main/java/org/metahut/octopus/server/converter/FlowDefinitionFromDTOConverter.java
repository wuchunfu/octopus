package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MonitorFlowDefinitionCreateOrUpdateRequestDTO;
import org.metahut.octopus.dao.entity.FlowDefinition;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface FlowDefinitionFromDTOConverter extends Converter<MonitorFlowDefinitionCreateOrUpdateRequestDTO, FlowDefinition> {

    @Override
    FlowDefinition convert(MonitorFlowDefinitionCreateOrUpdateRequestDTO source);
}
