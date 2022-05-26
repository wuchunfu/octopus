package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MetricsResultResponseDTO;
import org.metahut.octopus.monitordb.api.MetricsResult;
import org.metahut.octopus.server.service.MetaService;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Mapper(componentModel = "spring", uses = MetaService.class)
public interface MetricsResultToDTOConverter extends Converter<MetricsResult, MetricsResultResponseDTO> {

    @Override
    @Mapping(source = "datasetCode", target = "meta")
    MetricsResultResponseDTO convert(MetricsResult source);

    List<MetricsResultResponseDTO> convert(List<MetricsResult> sources);
}
