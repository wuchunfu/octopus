package org.metahut.octopus.api.dto;

import org.metahut.octopus.common.enums.SubjectCategoryEnum;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class RuleInstanceResponseDTO {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "code")
    private Long code;

    @ApiModelProperty(value = "name")
    private String name;

    @ApiModelProperty(value = "subjectCategory")
    private SubjectCategoryEnum subjectCategory;

    @ApiModelProperty(value = "metricsCode")
    private MetricsResponseDTO metrics;

    @ApiModelProperty(value = "metricsConfigCode")
    private MetricsConfigResponseDTO metricsConfig;

    @ApiModelProperty(value = "checkType")
    private String checkType;

    @ApiModelProperty(value = "checkMethod")
    private String checkMethod;

    @ApiModelProperty(value = "comparisonMethod")
    private String comparisonMethod;

    @ApiModelProperty(value = "expectedValue")
    private String expectedValue;

    @ApiModelProperty(value = "sampleInstance")
    private SampleInstanceResponseDTO sampleInstance;

    @ApiModelProperty(value = "sourceCode")
    private String sourceCode;

    @ApiModelProperty(value = "subjectCode")
    private String subjectCode;

    @ApiModelProperty(value = "flowDefinition")
    private FlowDefinitionResponseDTO flowDefinition;

    @ApiModelProperty(value = "sourceAlertRelations")
    List<SourceAlertRelationResponseDTO> sourceAlertRelations;

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

    public SubjectCategoryEnum getSubjectCategory() {
        return subjectCategory;
    }

    public void setSubjectCategory(SubjectCategoryEnum subjectCategory) {
        this.subjectCategory = subjectCategory;
    }

    public MetricsResponseDTO getMetrics() {
        return metrics;
    }

    public void setMetrics(MetricsResponseDTO metrics) {
        this.metrics = metrics;
    }

    public MetricsConfigResponseDTO getMetricsConfig() {
        return metricsConfig;
    }

    public void setMetricsConfig(MetricsConfigResponseDTO metricsConfig) {
        this.metricsConfig = metricsConfig;
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

    public FlowDefinitionResponseDTO getFlowDefinition() {
        return flowDefinition;
    }

    public void setFlowDefinition(FlowDefinitionResponseDTO flowDefinition) {
        this.flowDefinition = flowDefinition;
    }

    public List<SourceAlertRelationResponseDTO> getSourceAlertRelations() {
        return sourceAlertRelations;
    }

    public void setSourceAlertRelations(List<SourceAlertRelationResponseDTO> sourceAlertRelations) {
        this.sourceAlertRelations = sourceAlertRelations;
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
