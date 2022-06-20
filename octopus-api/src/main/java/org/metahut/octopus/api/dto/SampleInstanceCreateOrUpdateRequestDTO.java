package org.metahut.octopus.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "sample instance create or update request dto")
public class SampleInstanceCreateOrUpdateRequestDTO {

    @ApiModelProperty(value = "id")
    @NotNull(message = "{parameter.not.null}", groups = Update.class)
    private Integer id;

    @NotNull(message = "{parameter.not.null}", groups = Update.class)
    @ApiModelProperty(value = "code")
    private Long code;

    @ApiModelProperty(value = "datasetCode")
    @NotEmpty(message = "{parameter.not.null}")
    private String datasetCode;

    @ApiModelProperty(value = "executorType")
    private String executorType;

    @ApiModelProperty(value = "parameter")
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

    public String getDatasetCode() {
        return datasetCode;
    }

    public void setDatasetCode(String datasetCode) {
        this.datasetCode = datasetCode;
    }

    public String getExecutorType() {
        return executorType;
    }

    public void setExecutorType(String executorType) {
        this.executorType = executorType;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

}


