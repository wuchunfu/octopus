package org.metahut.octopus.server.converter;

import org.mapstruct.Mapper;
import org.metahut.octopus.api.dto.MetricsConfigCreateOrUpdateRequestDTO;
import org.metahut.octopus.dao.entity.MetricsConfig;

import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface MetricsConfigFromDTOConverter extends Converter<MetricsConfigCreateOrUpdateRequestDTO, MetricsConfig> {
}
