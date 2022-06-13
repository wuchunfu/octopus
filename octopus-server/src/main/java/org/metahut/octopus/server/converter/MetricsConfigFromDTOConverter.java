package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MetricsConfigCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.exception.BusinessException;
import org.metahut.octopus.common.enums.StatusEnum;
import org.metahut.octopus.dao.entity.MetricsConfig;
import org.metahut.octopus.server.service.MetricsService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.core.convert.converter.Converter;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

@Mapper(componentModel = "spring", uses = {MetricsService.class})
public interface MetricsConfigFromDTOConverter extends Converter<MetricsConfigCreateOrUpdateRequestDTO, MetricsConfig> {

    @Override
    @Mapping(source = "metricsCode", target = "metrics")
    MetricsConfig convert(MetricsConfigCreateOrUpdateRequestDTO source);

    @AfterMapping
    default void nameHandler(MetricsConfigCreateOrUpdateRequestDTO source, @MappingTarget MetricsConfig metricsConfig) {
        String join = new StringJoiner("_")
            .add(metricsConfig.getSubjectCategory().name())
            .add(metricsConfig.getMetrics().getName())
            .add(metricsConfig.getSourceCategory())
            .add(source.getExecutorType())
            .toString();
        metricsConfig.setName(join);
    }

    @AfterMapping
    default void metricsParamsHandler(MetricsConfigCreateOrUpdateRequestDTO source, @MappingTarget MetricsConfig metricsConfig) {
        try {
            Map<String, String> map = new HashMap<>();
            map.put("executorType", source.getExecutorType());
            map.put("executorScript", source.getExecutorScript());
            metricsConfig.setMetricsParams(new ObjectMapper().writeValueAsString(map));
        } catch (JsonProcessingException e) {
            throw new BusinessException(StatusEnum.CONVERTER_EXCEPTION, e);
        }

    }
}
