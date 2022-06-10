package org.metahut.octopus.api.dto;

import javax.validation.constraints.NotEmpty;

/**
 *
 */
public class MetaDatasourceRequestDTO extends PageRequestDTO {

    private String code;

    private String name;

    @NotEmpty(message = "{parameter.not.null}")
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
