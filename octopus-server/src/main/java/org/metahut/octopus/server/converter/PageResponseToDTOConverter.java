package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.monitordb.api.PageResponse;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface PageResponseToDTOConverter extends Converter<PageResponse, PageResponseDTO> {
}
