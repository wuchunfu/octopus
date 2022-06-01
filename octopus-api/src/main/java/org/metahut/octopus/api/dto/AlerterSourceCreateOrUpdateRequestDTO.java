package org.metahut.octopus.api.dto;

import javax.validation.constraints.NotNull;

public class AlerterSourceCreateOrUpdateRequestDTO {

    @NotNull(message = "{parameter.not.null}", groups = Update.class)
    private Integer id;

    @NotNull(message = "{parameter.not.null}", groups = Update.class)
    private Long code;

    @NotNull(message = "{parameter.not.null}")
    private String name;

    @NotNull(message = "{parameter.not.null}")
    private String alertType;

    @NotNull(message = "{parameter.not.null}")
    private String parameter;

    public interface Update {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

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

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
}
