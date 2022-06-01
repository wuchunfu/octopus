package org.metahut.octopus.server.service;

import org.metahut.octopus.api.dto.MetaDatabaseResponseDTO;
import org.metahut.octopus.api.dto.MetaDatasetRequestDTO;
import org.metahut.octopus.api.dto.MetaDatasetResponseDTO;
import org.metahut.octopus.api.dto.MetaDatasourceRequestDTO;
import org.metahut.octopus.api.dto.MetaDatasourceResponseDTO;
import org.metahut.octopus.api.dto.MetaDatasourceTypeRequestDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;

import java.util.Collection;

public interface MetaService {

    PageResponseDTO<MetaDatasourceResponseDTO> queryDatasourceTypeListPage(MetaDatasourceTypeRequestDTO requestDTO);

    PageResponseDTO<MetaDatasourceResponseDTO> queryDatasourceListPage(MetaDatasourceRequestDTO requestDTO);

    PageResponseDTO<MetaDatabaseResponseDTO> queryDatabaseListPage(String datasourceCode);

    PageResponseDTO<MetaDatasetResponseDTO> queryDatasetList(MetaDatasetRequestDTO requestDTO);

    PageResponseDTO<MetaDatasetResponseDTO> queryUnregisteredDatasetList(MetaDatasetRequestDTO requestDTO);

    PageResponseDTO<MetaDatasetResponseDTO> queryUnregisteredDatasetListPage(MetaDatasetRequestDTO requestDTO);

    MetaDatasetResponseDTO queryDatasetByCode(String datasetCode);

    Collection<String> queryAllSourceCategories();
}
