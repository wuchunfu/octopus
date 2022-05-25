package org.metahut.octopus.api.controller;

import org.metahut.octopus.api.dto.MetaDatabaseResponseDTO;
import org.metahut.octopus.api.dto.MetaDatasetRequestDTO;
import org.metahut.octopus.api.dto.MetaDatasetResponseDTO;
import org.metahut.octopus.api.dto.MetaDatasourceResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "META_TAG")
@RequestMapping("meta")
public interface MetaController {

    @ApiOperation(value = "queryDatasourceList", notes = "META_DATASOURCE_QUERY_LIST_NOTES")
    @GetMapping("queryDatasourceList")
    ResultEntity<MetaDatasourceResponseDTO> queryDatasourceList(String name);

    @ApiOperation(value = "queryDatabaseList", notes = "META_DATABASE_QUERY_LIST_NOTES")
    @GetMapping("queryDatabaseList")
    ResultEntity<MetaDatabaseResponseDTO> queryDatabaseList(String datasourceCode);

    @ApiOperation(value = "queryDatasetList", notes = "META_DATASET_QUERY_LIST_NOTES")
    @GetMapping("queryDatasetList")
    ResultEntity<MetaDatasetResponseDTO> queryDatasetList(MetaDatasetRequestDTO requestDTO);

}
