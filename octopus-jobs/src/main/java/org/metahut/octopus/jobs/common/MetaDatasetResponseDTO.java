package org.metahut.octopus.jobs.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Collection;

@ApiModel(description = "meta dataset response dto")
public class MetaDatasetResponseDTO {

    @ApiModelProperty(value = "code")
    private String code;

    @ApiModelProperty(value = "name")
    private String name;

    @ApiModelProperty(value = "comment")
    private String comment;

    @ApiModelProperty(value = "database")
    private MetaDatabaseResponseDTO database;

    @ApiModelProperty(value = "datasource")
    private MetaDatasourceResponseDTO datasource;

    @ApiModelProperty(value = "schemas")
    private Collection<MetaSchemaSingleResponseDTO> schemas;

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

    public Collection<MetaSchemaSingleResponseDTO> getSchemas() {
        return schemas;
    }

    public void setSchemas(Collection<MetaSchemaSingleResponseDTO> schemas) {
        this.schemas = schemas;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
