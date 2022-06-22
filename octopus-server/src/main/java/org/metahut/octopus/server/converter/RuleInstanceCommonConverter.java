package org.metahut.octopus.server.converter;

import org.metahut.octopus.dao.entity.MetricsConfig;
import org.metahut.octopus.dao.entity.RuleInstance;

import org.mapstruct.AfterMapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.StringJoiner;

import static org.metahut.octopus.server.utils.Constants.NAME_SPLICE_SYMBOL;

@Component
public class RuleInstanceCommonConverter {

    @Deprecated
    @AfterMapping
    public void metricsParameterHandler(@MappingTarget RuleInstance ruleInstance) {
        MetricsConfig metricsConfig = ruleInstance.getMetricsConfig();
        if (Objects.nonNull(metricsConfig)) {
            ruleInstance.setMetricsParams(metricsConfig.getMetricsParams());
        }
    }

    @Deprecated
    @AfterMapping
    public void metricsHandler(@MappingTarget RuleInstance ruleInstance) {
        ruleInstance.setMetricsUniqueKey(new StringJoiner(NAME_SPLICE_SYMBOL)
                .add(ruleInstance.getSubjectCategory().name())
                .add(ruleInstance.getSubjectCode())
                .add(ruleInstance.getMetrics().getCode())
                .add(ruleInstance.getFilter())
                .toString());
    }

}
