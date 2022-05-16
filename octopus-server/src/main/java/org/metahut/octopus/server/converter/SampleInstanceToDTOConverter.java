package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.SampleInstanceResponseDTO;
import org.metahut.octopus.dao.entity.SampleInstance;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SampleInstanceToDTOConverter extends Converter<SampleInstance, SampleInstanceResponseDTO> {

    List<SampleInstanceResponseDTO> convert(List<SampleInstance> sources);
}
