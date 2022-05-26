package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.MetaDatabaseResponseDTO;
import org.metahut.octopus.api.dto.MetaDatasetRequestDTO;
import org.metahut.octopus.api.dto.MetaDatasetResponseDTO;
import org.metahut.octopus.api.dto.MetaDatasourceResponseDTO;
import org.metahut.octopus.meta.api.IMeta;
import org.metahut.octopus.meta.api.MetaDatabaseEntity;
import org.metahut.octopus.meta.api.MetaDatasetEntity;
import org.metahut.octopus.meta.api.MetaDatasetEntityRequest;
import org.metahut.octopus.meta.api.MetaDatasourceEntity;
import org.metahut.octopus.server.service.MetaService;
import org.metahut.octopus.server.service.MonitorFlowDefinitionService;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
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
    public Collection<MetaDatasourceResponseDTO> queryDatasourceList(String name) {
        Collection<MetaDatasourceEntity> metaDatasourceEntities = meta.queryDatasourceList(name);
        return (Collection<MetaDatasourceResponseDTO>) conversionService.convert(metaDatasourceEntities,
                TypeDescriptor.collection(Collection.class, TypeDescriptor.valueOf(MetaDatasourceEntity.class)),
                TypeDescriptor.collection(Collection.class, TypeDescriptor.valueOf(MetaDatasourceResponseDTO.class)));
    }

    @Override
    public Collection<MetaDatabaseResponseDTO> queryDatabaseList(String datasourceCode) {
        Collection<MetaDatabaseEntity> metaDatabaseEntities = meta.queryDatabaseList(datasourceCode);
        return (Collection<MetaDatabaseResponseDTO>) conversionService.convert(metaDatabaseEntities,
                TypeDescriptor.collection(Collection.class, TypeDescriptor.valueOf(MetaDatabaseEntity.class)),
                TypeDescriptor.collection(Collection.class, TypeDescriptor.valueOf(MetaDatabaseResponseDTO.class)));
    }

    @Override
    public Collection<MetaDatasetResponseDTO> queryDatasetList(MetaDatasetRequestDTO requestDTO) {
        MetaDatasetEntityRequest convert = conversionService.convert(requestDTO, MetaDatasetEntityRequest.class);
        Collection<MetaDatasetEntity> metaDatasetEntities = meta.queryDatasetList(convert);
        return (Collection<MetaDatasetResponseDTO>) conversionService.convert(metaDatasetEntities,
                TypeDescriptor.collection(Collection.class, TypeDescriptor.valueOf(MetaDatasetEntity.class)),
                TypeDescriptor.collection(Collection.class, TypeDescriptor.valueOf(MetaDatasetResponseDTO.class)));
    }

    @Override
    public Collection<MetaDatasetResponseDTO> queryUnregisteredDatasetList(MetaDatasetRequestDTO requestDTO) {
        Collection<MetaDatasetResponseDTO> metaDatasetResponseDTOS = queryDatasetList(requestDTO);
        Map<String, Integer> collect = monitorFlowDefinitionService.queryRegisteredDatasetCodes().stream().collect(Collectors.toMap(Function.identity(), code -> 1));
        return metaDatasetResponseDTOS.stream().filter(dataset -> Objects.isNull(collect.get(dataset.getCode()))).collect(Collectors.toList());
    }

    @Override
    public MetaDatasetResponseDTO queryDatasetByCode(String datasetCode) {
        MetaDatasetEntity metaDatasetEntity = meta.queryDatasetByCode(datasetCode);
        return conversionService.convert(metaDatasetEntity, MetaDatasetResponseDTO.class);
    }

    @Override
    public Collection<String> queryAllSourceCategories() {
        Collection<MetaDatasourceEntity> metaDatasourceEntities = meta.queryDatasourceList(null);
        return metaDatasourceEntities.stream().map(MetaDatasourceEntity::getType).collect(Collectors.toSet());
    }

}
