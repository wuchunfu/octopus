package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MetricsConfigResponseDTO;
import org.metahut.octopus.dao.entity.MetricsConfig;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MetricsConfigToDTOListConverter extends Converter<List<MetricsConfig>, List<MetricsConfigResponseDTO>> {

}
