package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.MetaController;
import org.metahut.octopus.api.dto.*;
import org.metahut.octopus.server.service.MetaService;

import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class MetaControllerImpl implements MetaController {

    private final MetaService metaService;

    public MetaControllerImpl(MetaService metaService) {
        this.metaService = metaService;
    }

    @Override
    public ResultEntity<Collection<MetaDatasourceResponseDTO>> queryDatasourceList(String name) {
        return ResultEntity.success(metaService.queryDatasourceList(name));
    }

    @Override
    public ResultEntity<Collection<MetaDatabaseResponseDTO>> queryDatabaseList(String datasourceCode) {
        return ResultEntity.success(metaService.queryDatabaseList(datasourceCode));
    }

    @Override
    public ResultEntity<Collection<MetaDatasetResponseDTO>> queryDatasetList(MetaDatasetRequestDTO requestDTO) {
        return ResultEntity.success(metaService.queryDatasetList(requestDTO));
    }

    @Override
    public ResultEntity<Collection<MetaDatasetResponseDTO>> queryUnregisteredDatasetList(MetaDatasetRequestDTO requestDTO) {
        return ResultEntity.success(metaService.queryUnregisteredDatasetList(requestDTO));
    }

    @Override
    public ResultEntity<PageResponseDTO<MetaDatasetResponseDTO>> queryUnregisteredDatasetListPage(MetaDatasetRequestDTO requestDTO) {
        return ResultEntity.success(metaService.queryUnregisteredDatasetListPage(requestDTO));
    }


}
