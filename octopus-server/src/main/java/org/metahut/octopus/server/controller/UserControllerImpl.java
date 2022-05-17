package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.UserController;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.api.dto.UserResponseDTO;
import org.metahut.octopus.server.service.UserService;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResultEntity<List<UserResponseDTO>> queryList() {
        return ResultEntity.success(userService.findList());
    }
}
