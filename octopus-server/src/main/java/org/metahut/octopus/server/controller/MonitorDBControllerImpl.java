package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.MonitorDBController;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.server.service.MonitorDBService;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonitorDBControllerImpl implements MonitorDBController {

    private final MonitorDBService monitorDBService;

    public MonitorDBControllerImpl(MonitorDBService monitorDBService) {
        this.monitorDBService = monitorDBService;
    }

    @Override
    public ResultEntity customSQLQuery(String sql) {
        return ResultEntity.success(monitorDBService.customSQLQuery(sql));
    }
}
