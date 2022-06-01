package org.metahut.octopus.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.Collection;

@ApiModel(description = "alerter instance create or update request dto")
public class AlerterInstanceCreateOrUpdateRequestDTO {

    @ApiModelProperty(value = "id")
    @NotNull(message = "{parameter.not.null}", groups = Update.class)
    private Integer id;

    @ApiModelProperty(value = "alerterSourceCode")
    @NotNull(message = "{parameter.not.null}")
    private Long alerterSourceCode;

    @ApiModelProperty(value = "parameter")
    private String parameter;

    @Deprecated
    @ApiModelProperty(value = "alerterType")
    private String alerterType;

    @Deprecated
    @ApiModelProperty(value = "users")
    private Collection<UserResponseDTO> users;

    public interface Update {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getAlerterSourceCode() {
        return alerterSourceCode;
    }

    public void setAlerterSourceCode(Long alerterSourceCode) {
        this.alerterSourceCode = alerterSourceCode;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    @Deprecated
    public String getAlerterType() {
        return alerterType;
    }

    @Deprecated
    public void setAlerterType(String alerterType) {
        this.alerterType = alerterType;
    }

    @Deprecated
    public Collection<UserResponseDTO> getUsers() {
        return users;
    }

    @Deprecated
    public void setUsers(Collection<UserResponseDTO> users) {
        this.users = users;
    }
}
