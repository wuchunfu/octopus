package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MetricsConfigCreateOrUpdateRequestDTO;
import org.metahut.octopus.dao.entity.MetricsConfig;
import org.metahut.octopus.server.service.MetricsService;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring", uses = {MetricsService.class})
public interface MetricsConfigFromDTOConverter extends Converter<MetricsConfigCreateOrUpdateRequestDTO, MetricsConfig> {

    @Override
    @Mapping(source = "metricsCode", target = "metrics")
    MetricsConfig convert(MetricsConfigCreateOrUpdateRequestDTO source);

}
