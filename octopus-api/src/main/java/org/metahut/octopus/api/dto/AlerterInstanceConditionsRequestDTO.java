package org.metahut.octopus.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AlerterInstanceConditionsRequestDTO")
public class AlerterInstanceConditionsRequestDTO {

    @ApiModelProperty(value = "name")
    private String name;
    @ApiModelProperty(value = "type")
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
