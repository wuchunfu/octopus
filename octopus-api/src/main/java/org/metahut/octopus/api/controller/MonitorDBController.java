package org.metahut.octopus.api.controller;

import org.metahut.octopus.api.dto.ResultEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "MONITOR_DB_TAG")
@RequestMapping("monitorDB")
public interface MonitorDBController {

    @ApiOperation(value = "customSQLQuery", notes = "EXECUTE_CUSTOM_SQL_QUERY_NOTES")
    @GetMapping("customSQLQuery")
    ResultEntity customSQLQuery(String sql);
}
