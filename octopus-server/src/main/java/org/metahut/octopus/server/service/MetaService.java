package org.metahut.octopus.server.service;

import org.metahut.octopus.api.dto.MetaDatabaseResponseDTO;
import org.metahut.octopus.api.dto.MetaDatasetRequestDTO;
import org.metahut.octopus.api.dto.MetaDatasetResponseDTO;
import org.metahut.octopus.api.dto.MetaDatasourceResponseDTO;

import java.util.Collection;

public interface MetaService {
    Collection<MetaDatasourceResponseDTO> queryDatasourceList(String name);

    Collection<MetaDatabaseResponseDTO> queryDatabaseList(String datasourceCode);

    Collection<MetaDatasetResponseDTO> queryDatasetList(MetaDatasetRequestDTO requestDTO);

    Collection<MetaDatasetResponseDTO> queryUnregisteredDatasetList(MetaDatasetRequestDTO requestDTO);

    MetaDatasetResponseDTO queryDatasetByCode(String datasetCode);

    Collection<String> queryAllSourceCategories();
}
