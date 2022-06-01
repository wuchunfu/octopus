package org.metahut.octopus.api.dto;

/**
 *
 */
public class MetaDatasourceRequestDTO extends PageRequestDTO {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
