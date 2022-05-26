package org.metahut.octopus.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "meta schema response dto")
public class MetaSchemaResponseDTO {

    @ApiModelProperty(value = "code")
    private String code;

    @ApiModelProperty(value = "name")
    private String name;

    @ApiModelProperty(value = "dataset")
    private MetaDatasetSingleResponseDTO dataset;

    @ApiModelProperty(value = "database")
    private MetaDatabaseResponseDTO database;

    @ApiModelProperty(value = "datasource")
    private MetaDatasourceResponseDTO datasource;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MetaDatasetSingleResponseDTO getDataset() {
        return dataset;
    }

    public void setDataset(MetaDatasetSingleResponseDTO dataset) {
        this.dataset = dataset;
    }

    public MetaDatabaseResponseDTO getDatabase() {
        return database;
    }

    public void setDatabase(MetaDatabaseResponseDTO database) {
        this.database = database;
    }

    public MetaDatasourceResponseDTO getDatasource() {
        return datasource;
    }

    public void setDatasource(MetaDatasourceResponseDTO datasource) {
        this.datasource = datasource;
    }
}
