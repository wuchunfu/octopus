package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.MetaController;
import org.metahut.octopus.api.dto.MetaDatabaseConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetaDatabaseResponseDTO;
import org.metahut.octopus.api.dto.MetaDatasetRequestDTO;
import org.metahut.octopus.api.dto.MetaDatasetResponseDTO;
import org.metahut.octopus.api.dto.MetaDatasourceRequestDTO;
import org.metahut.octopus.api.dto.MetaDatasourceResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
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
    public ResultEntity<PageResponseDTO<MetaDatasourceResponseDTO>> queryDatasourceListPage(MetaDatasourceRequestDTO metaDatasourceRequestDTO) {
        return ResultEntity.success(metaService.queryDatasourceListPage(metaDatasourceRequestDTO));
    }

    @Override
    public ResultEntity<PageResponseDTO<MetaDatabaseResponseDTO>> queryDatabaseListPage(MetaDatabaseConditionsRequestDTO requestDTO) {
        return ResultEntity.success(metaService.queryDatabaseListPage(requestDTO));
    }

    @Override
    public ResultEntity<PageResponseDTO<MetaDatasetResponseDTO>> queryDatasetListPage(MetaDatasetRequestDTO requestDTO) {
        return ResultEntity.success(metaService.queryDatasetList(requestDTO));
    }

    @Override
    public ResultEntity<Collection<MetaDatasetResponseDTO>> queryUnregisteredDatasetList(MetaDatasetRequestDTO requestDTO) {
        //return ResultEntity.success(metaService.queryDatasetList(requestDTO));
        return ResultEntity.success();
    }
}
