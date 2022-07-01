package org.metahut.octopus.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "meta database response dto")
public class MetaDatabaseResponseDTO {
    @ApiModelProperty(value = "code")
    private String code;

    @ApiModelProperty(value = "name")
    private String name;

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

    public MetaDatasourceResponseDTO getDatasource() {
        return datasource;
    }

    public void setDatasource(MetaDatasourceResponseDTO datasource) {
        this.datasource = datasource;
    }
}
