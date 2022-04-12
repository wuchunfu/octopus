package org.metahut.octopus.server.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.metahut.octopus.api.dto.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MetricsControllerImplTest {

    @Autowired
    private MetricsControllerImpl metricsController;

    @Test
    public void testQueryAll() {
        ResultEntity resultEntity = metricsController.queryAll();
        Assertions.assertEquals(200, resultEntity.getCode());
    }
}
