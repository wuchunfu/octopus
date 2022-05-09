package org.metahut.octopus.api.dto;

import org.metahut.octopus.common.enums.SubjectCategoryEnum;
import org.metahut.octopus.common.enums.ThresholdUnitEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description = "rule create or update request dto")
public class RuleInstanceRequestDTO extends PageRequestDTO {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "code")
    private Integer code;

    @ApiModelProperty(value = "subjectCategory")
    private SubjectCategoryEnum subjectCategory;

    @ApiModelProperty(value = "metricsCode")
    private String metricsCode;

    @ApiModelProperty(value = "metricsConfigName")
    private String metricsConfigName;

    @ApiModelProperty(value = "checkType")
    private String checkType;

    @ApiModelProperty(value = "checkMethod")
    private String checkMethod;

    @ApiModelProperty(value = "comparisonMethod")
    private String comparisonMethod;

    @ApiModelProperty(value = "thresholdUnit")
    private ThresholdUnitEnum thresholdUnit;

    @ApiModelProperty(value = "expectedValue")
    private String expectedValue;

    @ApiModelProperty(value = "sampleCode")
    private Integer sampleCode;

    @ApiModelProperty(value = "sourceCode")
    private String sourceCode;

    @ApiModelProperty(value = "tableCode")
    private Integer tableCode;

    @ApiModelProperty(value = "fieldCode")
    private Integer fieldCode;

    @ApiModelProperty(value = "crontab")
    private String crontab;

    @ApiModelProperty(value = "alarmGoup")
    private String alarmGoup;

    @ApiModelProperty(value = "perpDate")
    private Date perpDate;

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

    public String getMetricsConfigName() {
        return metricsConfigName;
    }

    public void setMetricsConfigName(String metricsConfigName) {
        this.metricsConfigName = metricsConfigName;
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

    public ThresholdUnitEnum getThresholdUnit() {
        return thresholdUnit;
    }

    public void setThresholdUnit(ThresholdUnitEnum thresholdUnit) {
        this.thresholdUnit = thresholdUnit;
    }

    public String getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(String expectedValue) {
        this.expectedValue = expectedValue;
    }

    public Integer getSampleCode() {
        return sampleCode;
    }

    public void setSampleCode(Integer sampleCode) {
        this.sampleCode = sampleCode;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public Integer getTableCode() {
        return tableCode;
    }

    public void setTableCode(Integer tableCode) {
        this.tableCode = tableCode;
    }

    public Integer getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(Integer fieldCode) {
        this.fieldCode = fieldCode;
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

    public Date getPerpDate() {
        return perpDate;
    }

    public void setPerpDate(Date perpDate) {
        this.perpDate = perpDate;
    }
}
