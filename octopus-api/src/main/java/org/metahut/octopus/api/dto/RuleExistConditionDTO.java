package org.metahut.octopus.api.dto;

import org.metahut.octopus.common.enums.SubjectCategoryEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.Collection;

@ApiModel(description = "check whether or not rule request DTO")
public class RuleExistConditionDTO {

    @ApiModelProperty(value = "metricsCode")
    @NotEmpty(message = "{parameter.not.null}")
    private String metricsCode;

    @ApiModelProperty(value = "subjectCodes")
    @NotNull(message = "{parameter.not.null}")
    private Collection<String> subjectCodes;

    @ApiModelProperty(value = "subjectCategory")
    @NotNull(message = "{parameter.not.null}")
    private SubjectCategoryEnum subjectCategory;

    public String getMetricsCode() {
        return metricsCode;
    }

    public void setMetricsCode(String metricsCode) {
        this.metricsCode = metricsCode;
    }

    public Collection<String> getSubjectCodes() {
        return subjectCodes;
    }

    public void setSubjectCodes(Collection<String> subjectCodes) {
        this.subjectCodes = subjectCodes;
    }

    public SubjectCategoryEnum getSubjectCategory() {
        return subjectCategory;
    }

    public void setSubjectCategory(SubjectCategoryEnum subjectCategory) {
        this.subjectCategory = subjectCategory;
    }
}
