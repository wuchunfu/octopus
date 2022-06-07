package org.metahut.octopus.api.dto;

import org.metahut.octopus.common.enums.SubjectCategoryEnum;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.List;

public class RuleTemplateCreateOrUpdateRequestDTO {

    @ApiModelProperty(value = "id")
    @NotNull(message = "{parameter.not.null}", groups = Update.class)
    private Integer id;

    @ApiModelProperty(value = "code")
    @NotNull(message = "{parameter.not.null}", groups = Update.class)
    private Long code;

    @ApiModelProperty(value = "name")
    private String name;

    @ApiModelProperty(value = "metricsCode")
    @NotBlank(message = "{parameter.not.null}")
    private String metricsCode;

    @ApiModelProperty(value = "subjectCategory")
    @NotNull(message = "{parameter.not.null}")
    private SubjectCategoryEnum subjectCategory;

    @ApiModelProperty(value = "checkType")
    @NotBlank(message = "{parameter.not.null}")
    private String checkType;

    @ApiModelProperty(value = "checkMethod")
    @NotBlank(message = "{parameter.not.null}")
    private String checkMethod;

    @ApiModelProperty(value = "comparisonMethod")
    @NotBlank(message = "{parameter.not.null}")
    private String comparisonMethod;

    @ApiModelProperty(value = "expectedValue")
    @NotEmpty(message = "{parameter.not.null}")
    private List<String> expectedValue;

    @ApiModelProperty(value = "comparisonUnit")
    @NotBlank(message = "{parameter.not.null}")
    private String comparisonUnit;

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

    public String getMetricsCode() {
        return metricsCode;
    }

    public void setMetricsCode(String metricsCode) {
        this.metricsCode = metricsCode;
    }

    public SubjectCategoryEnum getSubjectCategory() {
        return subjectCategory;
    }

    public void setSubjectCategory(SubjectCategoryEnum subjectCategory) {
        this.subjectCategory = subjectCategory;
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

    public List<String> getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(List<String> expectedValue) {
        this.expectedValue = expectedValue;
    }

    public String getComparisonUnit() {
        return comparisonUnit;
    }

    public void setComparisonUnit(String comparisonUnit) {
        this.comparisonUnit = comparisonUnit;
    }
}
