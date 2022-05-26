package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MonitorFlowDefinitionCreateOrUpdateRequestDTO;
import org.metahut.octopus.dao.entity.FlowDefinition;

import org.apache.commons.lang3.BooleanUtils;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring", uses = { AlerterInstanceFromDTOConverter.class })
public interface FlowDefinitionFromDTOConverter extends Converter<MonitorFlowDefinitionCreateOrUpdateRequestDTO, FlowDefinition> {

    @Override
    FlowDefinition convert(MonitorFlowDefinitionCreateOrUpdateRequestDTO source);

    @AfterMapping
    default void sampleHandler(@MappingTarget FlowDefinition target) {
        target.getRuleInstances().stream()
                .filter(ruleInstance -> BooleanUtils.isTrue(ruleInstance.getSample()))
                .forEach(ruleInstance -> ruleInstance.setSampleInstance(target.getSampleInstance()));
    }

}
