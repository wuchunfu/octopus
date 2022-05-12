package org.metahut.octopus.api.dto;

import org.metahut.octopus.common.enums.SubjectCategoryEnum;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class RuleInstanceResponseDTO {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "code")
    private Integer code;

    @ApiModelProperty(value = "name")
    private String name;

    @ApiModelProperty(value = "subjectCategory")
    private SubjectCategoryEnum subjectCategory;

    @ApiModelProperty(value = "metricsCode")
    private String metricsCode;

    @ApiModelProperty(value = "metricsConfigCode")
    private Integer metricsConfigCode;

    @ApiModelProperty(value = "checkType")
    private String checkType;

    @ApiModelProperty(value = "checkMethod")
    private String checkMethod;

    @ApiModelProperty(value = "comparisonMethod")
    private String comparisonMethod;

    @ApiModelProperty(value = "expectedValue")
    private String expectedValue;

    @ApiModelProperty(value = "samplevlue")
    private String samplevlue;

    @ApiModelProperty(value = "sourceCode")
    private String sourceCode;

    @ApiModelProperty(value = "subjectCode")
    private String subjectCode;

    @ApiModelProperty(value = "crontab")
    private String crontab;

    @ApiModelProperty(value = "alarmGoup")
    private String alarmGoup;

    @ApiModelProperty(value = "creator")
    private Integer creator;

    @ApiModelProperty(value = "operator")
    private Integer operator;

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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SubjectCategoryEnum getSubjectCategory() {
        return subjectCategory;
    }

    public void setSubjectCategory(SubjectCategoryEnum subjectCategory) {
        this.subjectCategory = subjectCategory;
    }

    public String getMetricsCode() {
        return metricsCode;
    }

    public void setMetricsCode(String metricsCode) {
        this.metricsCode = metricsCode;
    }

    public Integer getMetricsConfigCode() {
        return metricsConfigCode;
    }

    public void setMetricsConfigCode(Integer metricsConfigCode) {
        this.metricsConfigCode = metricsConfigCode;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public String getCheckMethod() {
        return checkMethod;
    }

    public void setCheckMethod(String checkMethod) {
        this.checkMethod = checkMethod;
    }

    public String getComparisonMethod() {
        return comparisonMethod;
    }

    public void setComparisonMethod(String comparisonMethod) {
        this.comparisonMethod = comparisonMethod;
    }

    public String getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(String expectedValue) {
        this.expectedValue = expectedValue;
    }

    public String getSamplevlue() {
        return samplevlue;
    }

    public void setSamplevlue(String samplevlue) {
        this.samplevlue = samplevlue;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getCrontab() {
        return crontab;
    }

    public void setCrontab(String crontab) {
        this.crontab = crontab;
    }

    public String getAlarmGoup() {
        return alarmGoup;
    }

    public void setAlarmGoup(String alarmGoup) {
        this.alarmGoup = alarmGoup;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
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
