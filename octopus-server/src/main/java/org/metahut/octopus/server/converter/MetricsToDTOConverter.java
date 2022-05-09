package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MetricsResponseDTO;
import org.metahut.octopus.dao.entity.Metrics;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface MetricsToDTOConverter extends Converter<Metrics, MetricsResponseDTO> {
}
