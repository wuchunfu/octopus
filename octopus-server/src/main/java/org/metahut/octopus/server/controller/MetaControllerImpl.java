package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.MetaController;
import org.metahut.octopus.api.dto.*;
import org.metahut.octopus.server.service.MetaService;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetaControllerImpl implements MetaController {

    private final MetaService metaService;

    public MetaControllerImpl(MetaService metaService) {
        this.metaService = metaService;
    }


    @Override
    public ResultEntity<MetaDatasourceResponseDTO> queryDatasourceList(String name) {
        return null;
    }

    @Override
    public ResultEntity<MetaDatabaseResponseDTO> queryDatabaseList(String datasourceCode) {
        return null;
    }

    @Override
    public ResultEntity<MetaDatasetResponseDTO> queryDatasetList(MetaDatasetRequestDTO requestDTO) {
        return null;
    }
}
