package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MonitorFlowDefinitionCreateOrUpdateRequestDTO;
import org.metahut.octopus.dao.entity.FlowDefinition;

import org.apache.commons.lang3.BooleanUtils;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring", uses = { AlerterInstanceFromDTOConverter.class })
public interface FlowDefinitionFromDTOConverter extends Converter<MonitorFlowDefinitionCreateOrUpdateRequestDTO, FlowDefinition> {

    @BeforeMapping
    default void sampleHandler(MonitorFlowDefinitionCreateOrUpdateRequestDTO source) {
        source.getRuleInstances().stream()
                .filter(rule -> BooleanUtils.isTrue(rule.getSample()))
                .forEach(rule -> {
                    rule.setSampleInstance(source.getSampleInstance());
                });
    }

    @Override
    FlowDefinition convert(MonitorFlowDefinitionCreateOrUpdateRequestDTO source);


}
