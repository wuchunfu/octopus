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
import java.util.StringJoiner;

import static org.metahut.octopus.server.utils.Constants.NAME_SPLICE_SYMBOL;

@Mapper(componentModel = "spring", uses = { MetricsService.class, MetricsConfigService.class })
public interface RuleInstanceFromDTOConverter extends Converter<RuleInstanceCreateOrUpdateRequestDTO, RuleInstance> {

    @Override
    @Mappings({
        @Mapping(source = "metricsCode", target = "metrics"),
        //@Mapping(source = "metricsConfigCode", target = "metricsConfig", nullValueCheckStrategy = ALWAYS)
        // TODO The metricConfig parameter is required. When custom scripts are supported later, the metricConfig parameter is not required.
        @Mapping(source = "metricsConfigCode", target = "metricsConfig")
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

    @Deprecated
    @AfterMapping
    default void metricsHandler(@MappingTarget RuleInstance ruleInstance) {
        ruleInstance.setMetricsUniqueKey(new StringJoiner(NAME_SPLICE_SYMBOL)
                .add(ruleInstance.getSubjectCategory().name())
                .add(ruleInstance.getSubjectCode())
                .add(ruleInstance.getMetrics().getCode())
                .add(ruleInstance.getFilter())
                .toString());
    }

    List<RuleInstance> convert(List<RuleInstanceCreateOrUpdateRequestDTO> sources);
}
