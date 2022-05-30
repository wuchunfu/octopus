package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.UserResponseDTO;
import org.metahut.octopus.dao.entity.User;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserToDTOConverter extends Converter<User, UserResponseDTO> {

    List<UserResponseDTO> convert(List<User> sources);
}
