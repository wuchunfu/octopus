package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MetricsResultResponseDTO;
import org.metahut.octopus.monitordb.api.MetricsResult;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MetricsResultToDTOConverter extends Converter<MetricsResult, MetricsResultResponseDTO> {

    List<MetricsResultResponseDTO> convert(List<MetricsResult> sources);
}
