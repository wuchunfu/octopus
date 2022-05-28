package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.RuleInstanceCreateOrUpdateRequestDTO;
import org.metahut.octopus.dao.entity.MetricsConfig;
import org.metahut.octopus.dao.entity.RuleInstance;
import org.metahut.octopus.server.service.MetricsConfigService;
import org.metahut.octopus.server.service.MetricsService;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.Objects;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;

@Mapper(componentModel = "spring", uses = { MetricsService.class, MetricsConfigService.class })
public interface RuleInstanceFromDTOConverter extends Converter<RuleInstanceCreateOrUpdateRequestDTO, RuleInstance> {

    @Override
    @Mappings({
        @Mapping(source = "metricsCode", target = "metrics"),
        @Mapping(source = "metricsConfigCode", target = "metricsConfig", nullValueCheckStrategy = ALWAYS)
    })
    RuleInstance convert(RuleInstanceCreateOrUpdateRequestDTO source);

    @Deprecated
    @AfterMapping
    default void metricsParameterHandler(@MappingTarget RuleInstance ruleInstance) {
        MetricsConfig metricsConfig = ruleInstance.getMetricsConfig();

        if (Objects.nonNull(metricsConfig)) {
            ruleInstance.setMetricsParams(metricsConfig.getMetricsParams());
        }

    }

    List<RuleInstance> convert(List<RuleInstanceCreateOrUpdateRequestDTO> sources);
}
