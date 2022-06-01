package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.MetaDatabaseResponseDTO;
import org.metahut.octopus.api.dto.MetaDatasetRequestDTO;
import org.metahut.octopus.api.dto.MetaDatasetResponseDTO;
import org.metahut.octopus.api.dto.MetaDatasourceRequestDTO;
import org.metahut.octopus.api.dto.MetaDatasourceResponseDTO;
import org.metahut.octopus.api.dto.MetaDatasourceTypeRequestDTO;
import org.metahut.octopus.meta.api.IMeta;
import org.metahut.octopus.meta.api.MetaDatasetEntity;
import org.metahut.octopus.meta.api.MetaDatasetRequest;
import org.metahut.octopus.meta.api.MetaDatasourceEntity;
import org.metahut.octopus.meta.api.MetaDatasourceRequest;
import org.metahut.octopus.meta.api.MetaDatasourceTypeRequest;
import org.metahut.octopus.meta.api.PageResponseDTO;
import org.metahut.octopus.server.service.MetaService;
import org.metahut.octopus.server.service.MonitorFlowDefinitionService;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import java.util.Collection;

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
    public org.metahut.octopus.api.dto.PageResponseDTO<MetaDatasourceResponseDTO> queryDatasourceTypeListPage(MetaDatasourceTypeRequestDTO requestDTO) {
        MetaDatasourceTypeRequest request = conversionService.convert(requestDTO, MetaDatasourceTypeRequest.class);
        return (org.metahut.octopus.api.dto.PageResponseDTO<MetaDatasourceResponseDTO>) conversionService.convert(meta.queryDatasourceTypeListPage(request),
                TypeDescriptor.collection(PageResponseDTO.class, TypeDescriptor.valueOf(MetaDatasourceEntity.class)),
                TypeDescriptor.collection(org.metahut.octopus.api.dto.PageResponseDTO.class, TypeDescriptor.valueOf(MetaDatasourceResponseDTO.class)));
    }

    @Override
    public org.metahut.octopus.api.dto.PageResponseDTO<MetaDatasourceResponseDTO> queryDatasourceListPage(MetaDatasourceRequestDTO requestDTO) {
        MetaDatasourceRequest request = conversionService.convert(requestDTO, MetaDatasourceRequest.class);
        return (org.metahut.octopus.api.dto.PageResponseDTO<MetaDatasourceResponseDTO>) conversionService.convert(meta.queryDatasourceListPage(request),
            TypeDescriptor.collection(PageResponseDTO.class, TypeDescriptor.valueOf(MetaDatasourceEntity.class)),
            TypeDescriptor.collection(org.metahut.octopus.api.dto.PageResponseDTO.class, TypeDescriptor.valueOf(MetaDatasourceResponseDTO.class)));
    }

    @Override
    public org.metahut.octopus.api.dto.PageResponseDTO<MetaDatabaseResponseDTO> queryDatabaseListPage(String datasourceCode) {
        return null;
    }

    @Override
    public org.metahut.octopus.api.dto.PageResponseDTO<MetaDatasetResponseDTO> queryDatasetList(MetaDatasetRequestDTO requestDTO) {
        MetaDatasetRequest convert = conversionService.convert(requestDTO, MetaDatasetRequest.class);
        return (org.metahut.octopus.api.dto.PageResponseDTO<MetaDatasetResponseDTO>) conversionService.convert(meta.queryDatasetListPage(convert),
            TypeDescriptor.collection(PageResponseDTO.class, TypeDescriptor.valueOf(MetaDatasetEntity.class)),
            TypeDescriptor.collection(org.metahut.octopus.api.dto.PageResponseDTO.class, TypeDescriptor.valueOf(MetaDatasetResponseDTO.class)));
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
