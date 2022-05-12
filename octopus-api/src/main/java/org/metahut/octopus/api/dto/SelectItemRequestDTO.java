package org.metahut.octopus.api.dto;

import org.metahut.octopus.common.enums.SelectItemNameEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Set;

@ApiModel(value = "select item request dto")
public class SelectItemRequestDTO {

    @ApiModelProperty(value = "component names")
    private Set<SelectItemNameEnum> componentNames;

    public Set<SelectItemNameEnum> getComponentNames() {
        return componentNames;
    }

    public void setComponentNames(Set<SelectItemNameEnum> componentNames) {
        this.componentNames = componentNames;
    }
}
