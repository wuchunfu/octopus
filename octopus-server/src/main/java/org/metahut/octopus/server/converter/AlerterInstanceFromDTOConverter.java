package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.AlerterInstanceCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.UserResponseDTO;
import org.metahut.octopus.common.utils.JSONUtils;
import org.metahut.octopus.dao.entity.AlerterInstance;
import org.metahut.octopus.server.service.AlerterSourceService;

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

@Mapper(componentModel = "spring", uses = {AlerterSourceService.class})
public interface AlerterInstanceFromDTOConverter extends Converter<AlerterInstanceCreateOrUpdateRequestDTO, AlerterInstance> {

    @Override
    @Mapping(source = "source", target = "parameter", qualifiedByName = "generateParameter")
    @Mapping(source = "alerterSourceCode", target = "source")
    AlerterInstance convert(AlerterInstanceCreateOrUpdateRequestDTO source);

    @Deprecated
    String ALERTER_TYPE_EMAIL = "Email";
    @Deprecated
    String ALERTER_TYPE_DINGTALK = "DingTalk";
    @Deprecated
    String ALERTER_EMAIL_PARAMETER_DEFAULT_PROPERTY = "to";
    @Deprecated
    String ALERTER_DINGTALK_PARAMETER_DEFAULT_PROPERTY = "mobileList";

    @Deprecated
    @Named("generateParameter")
    default String generateParameter(AlerterInstanceCreateOrUpdateRequestDTO source) {
        Map<String, Object> map = new HashMap<>();
        if (ALERTER_TYPE_EMAIL.equals(source.getAlerterType())) {
            Set<String> collect = source.getUsers()
                    .stream()
                    .map(UserResponseDTO::getEmail)
                    .filter(StringUtils::isNotBlank)
                    .collect(Collectors.toSet());
            map.put(ALERTER_EMAIL_PARAMETER_DEFAULT_PROPERTY, collect);
        } else if (ALERTER_TYPE_DINGTALK.equals(source.getAlerterType())) {
            Set<String> collect = source.getUsers()
                    .stream()
                    .map(UserResponseDTO::getPhoneNumber)
                    .filter(StringUtils::isNotBlank)
                    .collect(Collectors.toSet());
            map.put(ALERTER_DINGTALK_PARAMETER_DEFAULT_PROPERTY, collect);
        }
        return JSONUtils.toJSONString(map);
    }

    List<AlerterInstance> convert(List<AlerterInstanceCreateOrUpdateRequestDTO> sources);

}
