package org.metahut.octopus.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "alerter instance conditions request dto")
public class AlerterInstanceConditionsRequestDTO extends PageRequestDTO {

    @ApiModelProperty(value = "name")
    private String name;
    @ApiModelProperty(value = "type")
    private String alertType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }
}
