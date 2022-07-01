package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.SampleInstanceCreateOrUpdateRequestDTO;
import org.metahut.octopus.common.utils.JSONUtils;
import org.metahut.octopus.dao.entity.SampleInstance;

import org.apache.commons.lang3.StringUtils;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.core.convert.converter.Converter;

import java.util.HashMap;

@Mapper(componentModel = "spring", uses = { CodeCommonConverter.class })
public interface SampleInstanceFromDTOConverter extends Converter<SampleInstanceCreateOrUpdateRequestDTO, SampleInstance> {

    @AfterMapping
    default void parameterHandler(@MappingTarget SampleInstance sampleInstance) {
        // TODO This is a issue
        if (StringUtils.isNotBlank(sampleInstance.getParameter())) {
            HashMap<String, String> map = new HashMap<>();
            map.put("method", "BLOCK");
            map.put("number", sampleInstance.getParameter());
            map.put("unit", "percent");
            sampleInstance.setRuntimeParameter(JSONUtils.toJSONString(map));
        }
    }
}
