package org.metahut.octopus.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

@ApiModel(description = "meta database conditions request dto")
public class MetaDatabaseConditionsRequestDTO extends PageRequestDTO {

    @ApiModelProperty(value = "dataSourceType")
    @NotEmpty(message = "{parameter.not.null}")
    private String dataSourceType;

    @ApiModelProperty(value = "datasourece code")
    private String datasoureceCode;

    @ApiModelProperty(value = "code")
    private String code;

    @ApiModelProperty(value = "name")
    private String name;

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

    public String getDataSourceType() {
        return dataSourceType;
    }

    public void setDataSourceType(String dataSourceType) {
        this.dataSourceType = dataSourceType;
    }

    public String getDatasoureceCode() {
        return datasoureceCode;
    }

    public void setDatasoureceCode(String datasoureceCode) {
        this.datasoureceCode = datasoureceCode;
    }
}
