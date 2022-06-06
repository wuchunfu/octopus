package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.SampleInstanceCreateOrUpdateRequestDTO;
import org.metahut.octopus.dao.entity.SampleInstance;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface SampleInstanceFromDTOConverter extends Converter<SampleInstanceCreateOrUpdateRequestDTO, SampleInstance> {
}
