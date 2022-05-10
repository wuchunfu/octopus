package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MetricsConfigResponseDTO;
import org.metahut.octopus.dao.entity.MetricsConfig;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface MetricsConfigToDTOConverter extends Converter<MetricsConfig, MetricsConfigResponseDTO> {
}
