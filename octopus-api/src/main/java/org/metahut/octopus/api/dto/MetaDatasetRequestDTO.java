package org.metahut.octopus.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "meta dataset request dto")
public class MetaDatasetRequestDTO {

    @ApiModelProperty(value = "code")
    private String code;

    @ApiModelProperty(value = "name")
    private String name;

    @ApiModelProperty(value = "databaseCode")
    private String databaseCode;

    @ApiModelProperty(value = "datasourceCode")
    private String datasourceCode;

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

    public String getDatabaseCode() {
        return databaseCode;
    }

    public void setDatabaseCode(String databaseCode) {
        this.databaseCode = databaseCode;
    }

    public String getDatasourceCode() {
        return datasourceCode;
    }

    public void setDatasourceCode(String datasourceCode) {
        this.datasourceCode = datasourceCode;
    }
}
