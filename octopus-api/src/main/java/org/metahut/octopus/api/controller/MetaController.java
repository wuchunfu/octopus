package org.metahut.octopus.api.controller;

import org.metahut.octopus.api.dto.MetaDatabaseConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetaDatabaseResponseDTO;
import org.metahut.octopus.api.dto.MetaDatasetRequestDTO;
import org.metahut.octopus.api.dto.MetaDatasetResponseDTO;
import org.metahut.octopus.api.dto.MetaDatasourceRequestDTO;
import org.metahut.octopus.api.dto.MetaDatasourceResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Api(tags = "META_TAG")
@RequestMapping("meta")
public interface MetaController {

    @ApiOperation(value = "queryDatasourceListPage", notes = "META_DATASOURCE_QUERY_LIST_NOTES")
    @GetMapping("queryDatasourceListPage")
    ResultEntity<PageResponseDTO<MetaDatasourceResponseDTO>> queryDatasourceListPage(@Validated MetaDatasourceRequestDTO requestDTO);

    @ApiOperation(value = "queryDatabaseListPage", notes = "META_DATABASE_QUERY_LIST_NOTES")
    @GetMapping("queryDatabaseListPage")
    ResultEntity<PageResponseDTO<MetaDatabaseResponseDTO>> queryDatabaseListPage(@Validated MetaDatabaseConditionsRequestDTO requestDTO);

    @ApiOperation(value = "queryDatasetListPage", notes = "META_DATASET_QUERY_LIST_NOTES")
    @GetMapping("queryDatasetListPage")
    ResultEntity<PageResponseDTO<MetaDatasetResponseDTO>> queryDatasetListPage(@Validated MetaDatasetRequestDTO requestDTO);

    @ApiOperation(value = "queryUnregisteredDatasetListPage", notes = "META_UNREGISTERED_DATASET_QUERY_LIST_NOTES")
    @GetMapping("queryUnregisteredDatasetListPage")
    ResultEntity<PageResponseDTO<MetaDatasetResponseDTO>> queryUnregisteredDatasetListPage(MetaDatasetRequestDTO requestDTO);
}
