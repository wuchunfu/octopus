package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.MetaController;
import org.metahut.octopus.api.dto.MetaDatabaseConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetaDatabaseResponseDTO;
import org.metahut.octopus.api.dto.MetaDatasetRequestDTO;
import org.metahut.octopus.api.dto.MetaDatasetResponseDTO;
import org.metahut.octopus.api.dto.MetaDatasourceRequestDTO;
import org.metahut.octopus.api.dto.MetaDatasourceResponseDTO;
import org.metahut.octopus.api.dto.PageRequestDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.server.service.MetaService;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetaControllerImpl implements MetaController {

    private final MetaService metaService;

    public MetaControllerImpl(MetaService metaService) {
        this.metaService = metaService;
    }

    private void defaultPage(PageRequestDTO pageRequestDTO) {
        if (pageRequestDTO != null) {
            if (pageRequestDTO.getPageNo() == null || pageRequestDTO.getPageNo() < 1) {
                pageRequestDTO.setPageNo(1);
            }
            if (pageRequestDTO.getPageSize() == null || pageRequestDTO.getPageSize() < 1) {
                pageRequestDTO.setPageSize(50);
            }
        }
    }

    @Override
    public ResultEntity<PageResponseDTO<MetaDatasourceResponseDTO>> queryDatasourceListPage(MetaDatasourceRequestDTO metaDatasourceRequestDTO) {
        defaultPage(metaDatasourceRequestDTO);
        return ResultEntity.success(metaService.queryDatasourceListPage(metaDatasourceRequestDTO));
    }

    @Override
    public ResultEntity<PageResponseDTO<MetaDatabaseResponseDTO>> queryDatabaseListPage(MetaDatabaseConditionsRequestDTO requestDTO) {
        defaultPage(requestDTO);
        return ResultEntity.success(metaService.queryDatabaseListPage(requestDTO));
    }

    @Override
    public ResultEntity<PageResponseDTO<MetaDatasetResponseDTO>> queryDatasetListPage(MetaDatasetRequestDTO requestDTO) {
        defaultPage(requestDTO);
        return ResultEntity.success(metaService.queryDatasetListPage(requestDTO));
    }

    @Override
    public ResultEntity<PageResponseDTO<MetaDatasetResponseDTO>> queryUnregisteredDatasetListPage(MetaDatasetRequestDTO requestDTO) {
        defaultPage(requestDTO);
        return ResultEntity.success(metaService.queryDatasetListPage(requestDTO));
    }
}
