package org.metahut.octopus.server.service;

import org.metahut.octopus.api.dto.*;

import java.util.Collection;

public interface MetaService {
    Collection<MetaDatasourceResponseDTO> queryDatasourceList(String name);

    Collection<MetaDatabaseResponseDTO> queryDatabaseList(String datasourceCode);

    Collection<MetaDatasetResponseDTO> queryDatasetList(MetaDatasetRequestDTO requestDTO);

    Collection<MetaDatasetResponseDTO> queryUnregisteredDatasetList(MetaDatasetRequestDTO requestDTO);

    PageResponseDTO<MetaDatasetResponseDTO> queryUnregisteredDatasetListPage(MetaDatasetRequestDTO requestDTO);

    MetaDatasetResponseDTO queryDatasetByCode(String datasetCode);

    Collection<String> queryAllSourceCategories();
}
