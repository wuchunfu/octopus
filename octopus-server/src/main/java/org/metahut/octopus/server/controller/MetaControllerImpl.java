package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.MetaController;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.server.service.MetaService;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetaControllerImpl implements MetaController {

    private final MetaService metaService;

    public MetaControllerImpl(MetaService metaService) {
        this.metaService = metaService;
    }

    public ResultEntity queryClusterList() {
        return null;
    }

    public ResultEntity queryDatabaseList() {
        return null;
    }

    public ResultEntity queryDatasetList() {
        return null;
    }


}
