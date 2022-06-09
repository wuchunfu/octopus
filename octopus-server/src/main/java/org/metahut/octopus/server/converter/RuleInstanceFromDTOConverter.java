package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.RuleInstanceCreateOrUpdateRequestDTO;
import org.metahut.octopus.dao.entity.RuleInstance;
import org.metahut.octopus.server.service.MetricsConfigService;
import org.metahut.octopus.server.service.MetricsService;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MetricsService.class, MetricsConfigService.class})
public abstract class RuleInstanceFromDTOConverter implements Converter<RuleInstanceCreateOrUpdateRequestDTO, RuleInstance>, RuleInstanceConverter {

    @Override
    @Mappings({@Mapping(source = "metricsCode", target = "metrics"), @Mapping(source = "metricsConfigCode", target = "metricsConfig")})
    public abstract RuleInstance convert(RuleInstanceCreateOrUpdateRequestDTO source);

    public abstract List<RuleInstance> convert(List<RuleInstanceCreateOrUpdateRequestDTO> sources);
}
