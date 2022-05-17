package org.metahut.octopus.api.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class SourceAlertRelationResponseDTO {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "source_code")
    private String source_code;

    @ApiModelProperty(value = "alertInstancecode")
    private Long alertInstancecode;

    @ApiModelProperty(value = "alerter")
    private String alerter;

    @ApiModelProperty(value = "creator")
    private Long creator;

    @ApiModelProperty(value = "operator")
    private Long operator;

    @ApiModelProperty(value = "createTime")
    private Date createTime;

    @ApiModelProperty(value = "updateTime")
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSource_code() {
        return source_code;
    }

    public void setSource_code(String source_code) {
        this.source_code = source_code;
    }

    public Long getAlertInstancecode() {
        return alertInstancecode;
    }

    public void setAlertInstancecode(Long alertInstancecode) {
        this.alertInstancecode = alertInstancecode;
    }

    public String getAlerter() {
        return alerter;
    }

    public void setAlerter(String alerter) {
        this.alerter = alerter;
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
