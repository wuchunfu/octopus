package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.MetaDatabaseConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetaDatabaseResponseDTO;
import org.metahut.octopus.api.dto.MetaDatasetRequestDTO;
import org.metahut.octopus.api.dto.MetaDatasetResponseDTO;
import org.metahut.octopus.api.dto.MetaDatasourceRequestDTO;
import org.metahut.octopus.api.dto.MetaDatasourceResponseDTO;
import org.metahut.octopus.api.dto.MetaDatasourceTypeRequestDTO;
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
    public PageResponseDTO<MetaDatasourceResponseDTO> queryDatasourceTypeListPage(MetaDatasourceTypeRequestDTO requestDTO) {
        MetaDatasourceTypeRequest request = conversionService.convert(requestDTO, MetaDatasourceTypeRequest.class);
        org.metahut.octopus.meta.api.PageResponseDTO<MetaDatasourceTypeEntity> responseDTO = meta.queryDatasourceTypeListPage(request);
        List<MetaDatasourceResponseDTO> convert = (List<MetaDatasourceResponseDTO>) conversionService.convert(responseDTO.getData(),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MetaDatasourceEntity.class)),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MetaDatasourceResponseDTO.class)));

        return PageResponseDTO.of(responseDTO.getPageNo(), responseDTO.getPageSize(), responseDTO.getTotal(), convert);
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
    public PageResponseDTO<MetaDatasetResponseDTO> queryDatasetList(MetaDatasetRequestDTO requestDTO) {
        MetaDatasetRequest request = conversionService.convert(requestDTO, MetaDatasetRequest.class);

        org.metahut.octopus.meta.api.PageResponseDTO<MetaDatasetEntity> responseDTO = meta.queryDatasetListPage(request);

        List<MetaDatasetResponseDTO> convert = (List<MetaDatasetResponseDTO>) conversionService.convert(responseDTO.getData(),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MetaDatasetEntity.class)),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MetaDatasetResponseDTO.class)));

        return PageResponseDTO.of(responseDTO.getPageNo(), responseDTO.getPageSize(), responseDTO.getTotal(), convert);
    }

    @Override
    public org.metahut.octopus.api.dto.PageResponseDTO<MetaDatasetResponseDTO> queryUnregisteredDatasetList(MetaDatasetRequestDTO requestDTO) {
        //Collection<MetaDatasetResponseDTO> metaDatasetResponseDTOS = queryDatasetList(requestDTO);
        //Map<String, Integer> collect = monitorFlowDefinitionService.queryRegisteredDatasetCodes().stream().collect(Collectors.toMap(Function.identity(), code -> 1));
        //return metaDatasetResponseDTOS.stream().filter(dataset -> Objects.isNull(collect.get(dataset.getCode()))).collect(Collectors.toList());
        return null;
    }

    @Override
    public org.metahut.octopus.api.dto.PageResponseDTO<MetaDatasetResponseDTO> queryUnregisteredDatasetListPage(MetaDatasetRequestDTO requestDTO) {
        //Collection<MetaDatasetResponseDTO> metaDatasetResponseDTOS = queryUnregisteredDatasetList(requestDTO);
        //if (CollectionUtils.isEmpty(metaDatasetResponseDTOS)) {
        //    return PageResponseDTO.of(requestDTO.getPageNo(), 0, 0L, Collections.emptyList());
        //}
        //List<MetaDatasetResponseDTO> collect = metaDatasetResponseDTOS.stream()
        //    .skip((requestDTO.getPageNo() - 1) * requestDTO.getPageSize())
        //    .limit(requestDTO.getPageSize())
        //    .collect(Collectors.toList());
        //Integer size = CollectionUtils.isEmpty(collect) ? 0 : collect.size();
        //return PageResponseDTO.of(requestDTO.getPageNo(), size, Long.valueOf(metaDatasetResponseDTOS.size()), collect);
        return null;
    }

    @Override
    public MetaDatasetResponseDTO queryDatasetByCode(String datasetCode) {
        MetaDatasetEntity metaDatasetEntity = meta.queryDatasetByCode(datasetCode);
        return conversionService.convert(metaDatasetEntity, MetaDatasetResponseDTO.class);
    }

    @Override
    public Collection<String> queryAllSourceCategories() {
        //Collection<MetaDatasourceEntity> metaDatasourceEntities = meta.queryDatasourceListPage(null);
        //return metaDatasourceEntities.stream().map(MetaDatasourceEntity::getType).collect(Collectors.toSet());
        return null;
    }

}
