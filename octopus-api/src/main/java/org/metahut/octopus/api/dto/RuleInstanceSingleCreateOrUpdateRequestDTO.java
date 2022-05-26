package org.metahut.octopus.api.dto;

import io.swagger.annotations.ApiModel;
import org.metahut.octopus.common.enums.RuleStateEnum;
import org.metahut.octopus.common.enums.SubjectCategoryEnum;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel(description = "rule instance single create or update request dto")
public class RuleInstanceSingleCreateOrUpdateRequestDTO {

    @ApiModelProperty(value = "id")
    @NotNull(message = "{parameter.not.null}", groups = MetricsCreateOrUpdateRequestDTO.Update.class)
    private Integer id;

    @ApiModelProperty(value = "code")
    private Long code;

    @ApiModelProperty(value = "name")
    private String name;

    @ApiModelProperty(value = "datasetCode")
    private String datasetCode;

    @ApiModelProperty(value = "metricsCode")
    private String metricsCode;

    @ApiModelProperty(value = "metricsConfigCode")
    private Long metricsConfigCode;

    @ApiModelProperty(value = "subjectCategory")
    private SubjectCategoryEnum subjectCategory;

    @ApiModelProperty(value = "subjectCode")
    private String subjectCode;

    @ApiModelProperty(value = "checkType")
    private String checkType;

    @ApiModelProperty(value = "checkMethod")
    private String checkMethod;

    @ApiModelProperty(value = "comparisonMethod")
    private String comparisonMethod;

    @ApiModelProperty(value = "expectedValue")
    private String expectedValue;

    @ApiModelProperty(value = "state")
    private RuleStateEnum state;

    @ApiModelProperty(value = "description")
    private String description;

    @ApiModelProperty(value = "sampleInstance")
    private SampleInstanceCreateOrUpdateRequestDTO sampleInstance;

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

    public String getDatasetCode() {
        return datasetCode;
    }

    public void setDatasetCode(String datasetCode) {
        this.datasetCode = datasetCode;
    }

    public String getMetricsCode() {
        return metricsCode;
    }

    public void setMetricsCode(String metricsCode) {
        this.metricsCode = metricsCode;
    }

    public Long getMetricsConfigCode() {
        return metricsConfigCode;
    }

    public void setMetricsConfigCode(Long metricsConfigCode) {
        this.metricsConfigCode = metricsConfigCode;
    }

    public SubjectCategoryEnum getSubjectCategory() {
        return subjectCategory;
    }

    public void setSubjectCategory(SubjectCategoryEnum subjectCategory) {
        this.subjectCategory = subjectCategory;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
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

    public RuleStateEnum getState() {
        return state;
    }

    public void setState(RuleStateEnum state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SampleInstanceCreateOrUpdateRequestDTO getSampleInstance() {
        return sampleInstance;
    }

    public void setSampleInstance(SampleInstanceCreateOrUpdateRequestDTO sampleInstance) {
        this.sampleInstance = sampleInstance;
    }
}
