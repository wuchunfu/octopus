package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.MetricsController;

import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.server.service.MetricsService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetricsControllerImpl implements MetricsController {

    private MetricsService metricsService;

    public MetricsControllerImpl(MetricsService metricsService) {
        this.metricsService = metricsService;
    }

    @Override
    public ResultEntity queryAll() {
        return ResultEntity.success(metricsService.findAll());
    }
}
