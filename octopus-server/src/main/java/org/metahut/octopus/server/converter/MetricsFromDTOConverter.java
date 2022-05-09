package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MetricsCreateOrUpdateRequestDTO;
import org.metahut.octopus.dao.entity.Metrics;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface MetricsFromDTOConverter extends Converter<MetricsCreateOrUpdateRequestDTO, Metrics> {
}
