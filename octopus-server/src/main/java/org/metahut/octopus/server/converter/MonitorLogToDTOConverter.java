package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MetaDatasetResponseDTO;
import org.metahut.octopus.api.dto.MetaDatasetSingleResponseDTO;
import org.metahut.octopus.api.dto.MetaSchemaResponseDTO;
import org.metahut.octopus.api.dto.MetaSchemaSingleResponseDTO;
import org.metahut.octopus.api.dto.MonitorLogResponseDTO;
import org.metahut.octopus.common.enums.SubjectCategoryEnum;
import org.metahut.octopus.monitordb.api.MonitorLog;
import org.metahut.octopus.server.service.MetaService;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public abstract class MonitorLogToDTOConverter implements Converter<MonitorLog, MonitorLogResponseDTO> {

    @Override
    @Mapping(source = "source", target = "meta", qualifiedByName = "querySchemaMeta")
    public abstract MonitorLogResponseDTO convert(MonitorLog source);

    @Autowired
    private MetaService metaService;

    @Named("querySchemaMeta")
    public MetaSchemaResponseDTO queryMeta(MonitorLog source) {
        MetaDatasetResponseDTO dataset = metaService.queryDatasetByCode(source.getDatasetCode());
        MetaSchemaResponseDTO metaSchemaResponseDTO = new MetaSchemaResponseDTO();
        metaSchemaResponseDTO.setDatasource(dataset.getDatasource());
        metaSchemaResponseDTO.setDatabase(dataset.getDatabase());
        metaSchemaResponseDTO.setDataset(new MetaDatasetSingleResponseDTO(dataset.getCode(), dataset.getName()));

        if (SubjectCategoryEnum.TABLE.name().equals(source.getSubjectCategory())) {
            return metaSchemaResponseDTO;
        }

        Optional<MetaSchemaSingleResponseDTO> first = dataset.getSchemas().stream().filter(schema -> source.getSubjectCode().equals(schema.getCode())).findFirst();
        if (!first.isPresent()) {
            metaSchemaResponseDTO.setCode("undefined");
            metaSchemaResponseDTO.setName("undefined");
            return metaSchemaResponseDTO;
        }
        MetaSchemaSingleResponseDTO metaSchemaSingleResponseDTO = first.get();
        metaSchemaResponseDTO.setCode(metaSchemaSingleResponseDTO.getCode());
        metaSchemaResponseDTO.setName(metaSchemaSingleResponseDTO.getName());
        return metaSchemaResponseDTO;

    }

    public abstract List<MonitorLogResponseDTO> convert(List<MonitorLog> sources);
}
