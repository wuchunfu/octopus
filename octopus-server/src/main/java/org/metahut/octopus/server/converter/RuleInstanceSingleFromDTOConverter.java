package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.RuleInstanceSingleCreateOrUpdateRequestDTO;
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

@Mapper(componentModel = "spring", uses = {MetricsService.class, MetricsConfigService.class})
public abstract class RuleInstanceSingleFromDTOConverter implements Converter<RuleInstanceSingleCreateOrUpdateRequestDTO, RuleInstance>, RuleInstanceConverter {

    @Override
    @Mappings({@Mapping(source = "metricsCode", target = "metrics"), @Mapping(source = "metricsConfigCode", target = "metricsConfig")})
    public abstract RuleInstance convert(RuleInstanceSingleCreateOrUpdateRequestDTO source);

    public abstract List<RuleInstance> convert(List<RuleInstanceSingleCreateOrUpdateRequestDTO> sources);

    @AfterMapping
    public void paramHandler(@MappingTarget RuleInstance ruleInstance) {
        String parameter = ruleInstance.getSampleInstance().getParameter();
        ruleInstance.getSampleInstance().setRuntimeParameter("{\"method\":\"BLOCK\",\"number\":" + parameter + ", \"unit\": \"percent\"}");
    }
}
