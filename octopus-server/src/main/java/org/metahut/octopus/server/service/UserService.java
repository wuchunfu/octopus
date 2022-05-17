package org.metahut.octopus.server.service;

import org.metahut.octopus.api.dto.UserResponseDTO;

import java.util.List;

public interface UserService {

    List<UserResponseDTO> findList();
}
