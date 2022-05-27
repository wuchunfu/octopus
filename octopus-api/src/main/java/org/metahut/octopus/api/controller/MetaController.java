package org.metahut.octopus.api.controller;

import org.metahut.octopus.api.dto.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Api(tags = "META_TAG")
@RequestMapping("meta")
public interface MetaController {

    @ApiOperation(value = "queryDatasourceList", notes = "META_DATASOURCE_QUERY_LIST_NOTES")
    @GetMapping("queryDatasourceList")
    ResultEntity<Collection<MetaDatasourceResponseDTO>> queryDatasourceList(String name);

    @ApiOperation(value = "queryDatabaseList", notes = "META_DATABASE_QUERY_LIST_NOTES")
    @GetMapping("queryDatabaseList")
    ResultEntity<Collection<MetaDatabaseResponseDTO>> queryDatabaseList(String datasourceCode);

    @ApiOperation(value = "queryDatasetList", notes = "META_DATASET_QUERY_LIST_NOTES")
    @GetMapping("queryDatasetList")
    ResultEntity<Collection<MetaDatasetResponseDTO>> queryDatasetList(MetaDatasetRequestDTO requestDTO);

    @ApiOperation(value = "queryUnregisteredDatasetList", notes = "META_UNREGISTERED_DATASET_QUERY_LIST_NOTES")
    @GetMapping("queryUnregisteredDatasetList")
    ResultEntity<Collection<MetaDatasetResponseDTO>> queryUnregisteredDatasetList(MetaDatasetRequestDTO requestDTO);

    @ApiOperation(value = "queryUnregisteredDatasetListPage", notes = "META_UNREGISTERED_DATASET_QUERY_LIST_PAGE_NOTES")
    @GetMapping("queryUnregisteredDatasetListPage")
    ResultEntity<PageResponseDTO<MetaDatasetResponseDTO>> queryUnregisteredDatasetListPage(MetaDatasetRequestDTO requestDTO);
}
