package org.metahut.octopus.jobs.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "sampleInstance request")
public class SampleInstanceResponseDTO {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "code")
    private Long code;

    @ApiModelProperty(value = "datasetCode")
    private String datasetCode;

    @ApiModelProperty(value = "executorType")
    private String executorType;

    @ApiModelProperty(value = "parameter")
    private String parameter;

    @ApiModelProperty(value = "creator")
    private Long creator;

    @ApiModelProperty(value = "operator")
    private Long operator;

    @JsonFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "createTime")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "updateTime")
    private Date updateTime;

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

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Long getOperator() {
        return operator;
    }

    public void setOperator(Long operator) {
        this.operator = operator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
