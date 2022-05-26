package org.metahut.octopus.api.dto;

import org.metahut.octopus.common.enums.SubjectCategoryEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description = "monitor log response dto")
public class MonitorLogResponseDTO {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "meta data")
    private MetaSchemaResponseDTO meta;

    @ApiModelProperty(value = "subject code")
    private String subjectCode;

    @ApiModelProperty(value = "subject category")
    private SubjectCategoryEnum subjectCategory;

    @ApiModelProperty(value = "metrics name")
    private String metricsName;

    @ApiModelProperty(value = "metrics code")
    private String metricsCode;

    @ApiModelProperty(value = "metrics config name")
    private String metricsConfigName;

    @ApiModelProperty(value = "metrics config code")
    private Long metricsConfigCode;

    @ApiModelProperty(value = "check type")
    private String checkType;

    @ApiModelProperty(value = "check method")
    private String checkMethod;

    @ApiModelProperty(value = "comparison method")
    private String comparisonMethod;

    @ApiModelProperty(value = "expected value")
    private String expectedValue;

    @ApiModelProperty(value = "sample instance")
    private SampleInstanceResponseDTO sampleInstance;

    @ApiModelProperty(value = "result")
    private String result;

    @ApiModelProperty(value = "error")
    private Boolean error;

    @ApiModelProperty(value = "error info")
    private String errorInfo;

    @ApiModelProperty(value = "error time")
    private Date errorTime;

    @ApiModelProperty(value = "create time")
    private Date createTime;

    @ApiModelProperty(value = "rule instance code")
    private Long ruleInstanceCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MetaSchemaResponseDTO getMeta() {
        return meta;
    }

    public void setMeta(MetaSchemaResponseDTO meta) {
        this.meta = meta;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public SubjectCategoryEnum getSubjectCategory() {
        return subjectCategory;
    }

    public void setSubjectCategory(SubjectCategoryEnum subjectCategory) {
        this.subjectCategory = subjectCategory;
    }

    public String getMetricsName() {
        return metricsName;
    }

    public void setMetricsName(String metricsName) {
        this.metricsName = metricsName;
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

    public Long getMetricsConfigCode() {
        return metricsConfigCode;
    }

    public void setMetricsConfigCode(Long metricsConfigCode) {
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

    public SampleInstanceResponseDTO getSampleInstance() {
        return sampleInstance;
    }

    public void setSampleInstance(SampleInstanceResponseDTO sampleInstance) {
        this.sampleInstance = sampleInstance;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public Date getErrorTime() {
        return errorTime;
    }

    public void setErrorTime(Date errorTime) {
        this.errorTime = errorTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getRuleInstanceCode() {
        return ruleInstanceCode;
    }

    public void setRuleInstanceCode(Long ruleInstanceCode) {
        this.ruleInstanceCode = ruleInstanceCode;
    }
}
