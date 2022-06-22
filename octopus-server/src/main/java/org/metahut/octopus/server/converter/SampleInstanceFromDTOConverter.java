package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.SampleInstanceCreateOrUpdateRequestDTO;
import org.metahut.octopus.dao.entity.SampleInstance;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring", uses = { CodeCommonConverter.class })
public interface SampleInstanceFromDTOConverter extends Converter<SampleInstanceCreateOrUpdateRequestDTO, SampleInstance> {

    @AfterMapping
    default void parameterHandler(@MappingTarget SampleInstance sampleInstance) {
        // TODO This is a issue
        sampleInstance.setRuntimeParameter("{\"method\":\"BLOCK\",\"number\":" + sampleInstance.getParameter() + ", \"unit\": \"percent\"}");
    }
}
