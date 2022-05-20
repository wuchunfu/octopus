package org.metahut.octopus.api.controller;

import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.api.dto.UserConditionsRequestDTO;
import org.metahut.octopus.api.dto.UserResponseDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Api(tags = "USER_TAG")
@RequestMapping("user")
public interface UserController {

    @ApiOperation(value = "queryList", notes = "USER_QUERY_LIST_NOTES")
    @GetMapping("queryList")
    ResultEntity<List<UserResponseDTO>> queryList(UserConditionsRequestDTO requestDTO);
}
