package org.metahut.octopus.api.controller;

import org.metahut.octopus.api.dto.ResultEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("metrics")
public interface MetricsController {

    @GetMapping("queryAll")
    ResultEntity queryAll();
}
