package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.AlerterInstanceCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.UserResponseDTO;
import org.metahut.octopus.dao.entity.AlerterInstance;
import org.metahut.octopus.metrics.api.JSONUtils;

import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.core.convert.converter.Converter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AlerterInstanceFromDTOConverter extends Converter<AlerterInstanceCreateOrUpdateRequestDTO, AlerterInstance> {

    @Override
    @Mapping(source = "source", target = "parameter", qualifiedByName = "generateParameter")
    AlerterInstance convert(AlerterInstanceCreateOrUpdateRequestDTO source);

    @Named("generateParameter")
    default String generateParameter(AlerterInstanceCreateOrUpdateRequestDTO source) {
        Map<String, Object> map = new HashMap<>();
        if ("Email".equals(source.getAlerterType())) {
            Set<String> collect = source.getUsers()
                    .stream()
                    .map(UserResponseDTO::getEmail)
                    .filter(StringUtils::isNotBlank)
                    .collect(Collectors.toSet());
            map.put("to", collect);
        } else if ("DingTalk".equals(source.getAlerterType())) {
            Set<String> collect = source.getUsers()
                    .stream()
                    .map(UserResponseDTO::getPhoneNumber)
                    .filter(StringUtils::isNotBlank)
                    .collect(Collectors.toSet());
            map.put("mobileList", collect);
        }
        return JSONUtils.toJSONString(map);
    }

    List<AlerterInstance> convert(List<AlerterInstanceCreateOrUpdateRequestDTO> sources);
}
