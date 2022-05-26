package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.AlerterInstanceResponseDTO;
import org.metahut.octopus.api.dto.UserResponseDTO;
import org.metahut.octopus.dao.entity.AlerterInstance;
import org.metahut.octopus.metrics.api.JSONUtils;
import org.metahut.octopus.server.service.UserService;

import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.commons.collections4.MapUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.metahut.octopus.server.converter.AlerterInstanceFromDTOConverter.*;

@Mapper(componentModel = "spring")
public abstract class AlerterInstanceToDTOConverter implements Converter<AlerterInstance, AlerterInstanceResponseDTO> {

    @Override
    @Mapping(source = "instance", target = "users", qualifiedByName = "deserializeParameter")
    public abstract AlerterInstanceResponseDTO convert(AlerterInstance instance);

    @Autowired
    private UserService userService;

    @Named("deserializeParameter")
    public Collection<UserResponseDTO> deserializeParameter(AlerterInstance instance) {

        Map<String, Object> map = JSONUtils.parseObject(instance.getParameter(), new TypeReference<Map<String, Object>>() {
        });

        if (MapUtils.isEmpty(map)) {
            return Collections.emptyList();
        }
        String alerterType = instance.getSource().getAlertType();
        if (ALERTER_TYPE_EMAIL.equals(alerterType)) {
            List<String> contactInfos = (List<String>) map.get(ALERTER_EMAIL_PARAMETER_DEFAULT_PROPERTY);
            return userService.findListByContactInfo(contactInfos);
        } else if (ALERTER_TYPE_DINGTALK.equals(alerterType)) {
            List<String> contactInfos = (List<String>) map.get(ALERTER_DINGTALK_PARAMETER_DEFAULT_PROPERTY);
            return userService.findListByContactInfo(contactInfos);
        }

        return Collections.emptyList();

    }

    public abstract List<AlerterInstanceResponseDTO> convert(List<AlerterInstance> sources);
}
