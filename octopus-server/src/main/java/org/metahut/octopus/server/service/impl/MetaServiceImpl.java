package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.MetaDatabaseConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetaDatabaseResponseDTO;
import org.metahut.octopus.api.dto.MetaDatasetRequestDTO;
import org.metahut.octopus.api.dto.MetaDatasetResponseDTO;
import org.metahut.octopus.api.dto.MetaDatasourceRequestDTO;
import org.metahut.octopus.api.dto.MetaDatasourceResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.meta.api.IMeta;
import org.metahut.octopus.meta.api.MetaDatabaseEntity;
import org.metahut.octopus.meta.api.MetaDatabaseRequest;
import org.metahut.octopus.meta.api.MetaDatasetEntity;
import org.metahut.octopus.meta.api.MetaDatasetRequest;
import org.metahut.octopus.meta.api.MetaDatasourceEntity;
import org.metahut.octopus.meta.api.MetaDatasourceRequest;
import org.metahut.octopus.meta.api.MetaDatasourceTypeEntity;
import org.metahut.octopus.meta.api.MetaDatasourceTypeRequest;
import org.metahut.octopus.server.service.MetaService;
import org.metahut.octopus.server.service.MonitorFlowDefinitionService;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MetaServiceImpl implements MetaService {

    private final IMeta meta;
    private final ConversionService conversionService;

    private final MonitorFlowDefinitionService monitorFlowDefinitionService;

    public MetaServiceImpl(IMeta meta, ConversionService conversionService, MonitorFlowDefinitionService monitorFlowDefinitionService) {
        this.meta = meta;
        this.conversionService = conversionService;
        this.monitorFlowDefinitionService = monitorFlowDefinitionService;
    }

    @Override
    public PageResponseDTO<MetaDatasourceResponseDTO> queryDatasourceListPage(MetaDatasourceRequestDTO requestDTO) {
        MetaDatasourceRequest request = conversionService.convert(requestDTO, MetaDatasourceRequest.class);
        org.metahut.octopus.meta.api.PageResponseDTO<MetaDatasourceEntity> responseDTO = meta.queryDatasourceListPage(request);
        List<MetaDatasourceResponseDTO> convert = (List<MetaDatasourceResponseDTO>) conversionService.convert(responseDTO.getData(),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MetaDatasourceEntity.class)),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MetaDatasourceResponseDTO.class)));

        return PageResponseDTO.of(responseDTO.getPageNo(), responseDTO.getPageSize(), responseDTO.getTotal(), convert);
    }

    @Override
    public PageResponseDTO<MetaDatabaseResponseDTO> queryDatabaseListPage(MetaDatabaseConditionsRequestDTO requestDTO) {

        MetaDatabaseRequest request = conversionService.convert(requestDTO, MetaDatabaseRequest.class);
        org.metahut.octopus.meta.api.PageResponseDTO<MetaDatabaseEntity> responseDTO = meta.queryDatabaseListPage(request);
        List<MetaDatabaseResponseDTO> convert = (List<MetaDatabaseResponseDTO>) conversionService.convert(responseDTO.getData(),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MetaDatabaseEntity.class)),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MetaDatabaseResponseDTO.class)));

        return PageResponseDTO.of(responseDTO.getPageNo(), responseDTO.getPageSize(), responseDTO.getTotal(), convert);
    }

    @Override
    public PageResponseDTO<MetaDatasetResponseDTO> queryDatasetListPage(MetaDatasetRequestDTO requestDTO) {
        MetaDatasetRequest request = conversionService.convert(requestDTO, MetaDatasetRequest.class);

        org.metahut.octopus.meta.api.PageResponseDTO<MetaDatasetEntity> responseDTO = meta.queryDatasetListPage(request);

        List<MetaDatasetResponseDTO> convert = (List<MetaDatasetResponseDTO>) conversionService.convert(responseDTO.getData(),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MetaDatasetEntity.class)),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MetaDatasetResponseDTO.class)));

        return PageResponseDTO.of(responseDTO.getPageNo(), responseDTO.getPageSize(), responseDTO.getTotal(), convert);
    }

    @Override
    public PageResponseDTO<MetaDatasetResponseDTO> queryUnregisteredDatasetListPage(MetaDatasetRequestDTO requestDTO) {
        // TODO The amount of metadata data is large, which makes it impossible to query all of them, and then exclude the dataset data that has been recorded by the system
        Collection<String> registeredDatasetCodes = monitorFlowDefinitionService.queryRegisteredDatasetCodes();
        PageResponseDTO<MetaDatasetResponseDTO> metaDatasetResponseDTOPageResponseDTO = queryDatasetListPage(requestDTO);
        List<MetaDatasetResponseDTO> collect = metaDatasetResponseDTOPageResponseDTO.getData().stream().filter(value -> !registeredDatasetCodes.contains(value.getCode())).collect(Collectors.toList());
        metaDatasetResponseDTOPageResponseDTO.setData(collect);
        return metaDatasetResponseDTOPageResponseDTO;
    }

    @Override
    public MetaDatasetResponseDTO queryDatasetByCode(String datasetCode) {
        MetaDatasetEntity metaDatasetEntity = meta.queryDatasetByCode(datasetCode);
        return conversionService.convert(metaDatasetEntity, MetaDatasetResponseDTO.class);
    }

    @Override
    public Collection<String> queryAllSourceCategories() {
        MetaDatasourceTypeRequest request = new MetaDatasourceTypeRequest();
        request.setPageNo(1);
        request.setPageSize(100);
        org.metahut.octopus.meta.api.PageResponseDTO<MetaDatasourceTypeEntity> responseDTO = meta.queryDatasourceTypeListPage(request);
        return responseDTO.getData().stream().map(MetaDatasourceTypeEntity::getName).collect(Collectors.toSet());
    }

}
