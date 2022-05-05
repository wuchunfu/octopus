package org.metahut.octopus.api.controller;

import org.metahut.octopus.api.dto.AlerterInstanceConditionsRequestDTO;
import org.metahut.octopus.api.dto.PageRequestDTO;
import org.metahut.octopus.api.dto.ResultEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@RequestMapping("alerter")
public interface AlerterInstanceController {

    @GetMapping("queryAllTypes")
    ResultEntity<Collection<String>> queryAllTypes();

    @GetMapping("queryListPage")
    ResultEntity queryListPage(@RequestBody PageRequestDTO<AlerterInstanceConditionsRequestDTO> pageRequestDTO);

    @GetMapping("queryList")
    ResultEntity queryList(@RequestBody AlerterInstanceConditionsRequestDTO alerterInstanceConditionsRequestDTO);
}
