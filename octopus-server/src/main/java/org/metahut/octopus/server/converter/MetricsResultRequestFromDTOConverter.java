package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MetricsResultConditionsRequestDTO;
import org.metahut.octopus.monitordb.api.MetricsResultRequest;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface MetricsResultRequestFromDTOConverter extends Converter<MetricsResultConditionsRequestDTO, MetricsResultRequest> {
}
