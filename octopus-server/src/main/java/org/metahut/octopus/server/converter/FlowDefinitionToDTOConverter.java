package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MonitorFlowDefinitionResponseDTO;
import org.metahut.octopus.dao.entity.FlowDefinition;
import org.metahut.octopus.server.service.MetaService;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Mapper(componentModel = "spring", uses = { MetaService.class, AlerterInstanceToDTOConverter.class})
public interface FlowDefinitionToDTOConverter extends Converter<FlowDefinition, MonitorFlowDefinitionResponseDTO> {

    @Mapping(source = "datasetCode", target = "meta")
    @Override
    MonitorFlowDefinitionResponseDTO convert(FlowDefinition source);

    List<MonitorFlowDefinitionResponseDTO> convert(List<FlowDefinition> sources);

}
