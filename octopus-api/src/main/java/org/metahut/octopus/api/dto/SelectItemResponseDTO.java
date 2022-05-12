package org.metahut.octopus.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "select item response dto")
public class SelectItemResponseDTO {

    @ApiModelProperty(value = "value")
    private Object value;

    @ApiModelProperty(value = "label")
    private Object label;

    public static SelectItemResponseDTO of(Object value, Object label) {
        SelectItemResponseDTO responseDTO = new SelectItemResponseDTO();
        responseDTO.setLabel(label);
        responseDTO.setValue(value);
        return responseDTO;
    }

    public Object getLabel() {
        return label;
    }

    public void setLabel(Object label) {
        this.label = label;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
