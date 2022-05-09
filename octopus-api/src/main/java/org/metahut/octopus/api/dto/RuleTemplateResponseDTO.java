package org.metahut.octopus.api.dto;

import org.metahut.octopus.common.enums.SubjectCategoryEnum;
import org.metahut.octopus.common.enums.ThresholdUnitEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "ruleTemplate response")
public class RuleTemplateResponseDTO {
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "code")
    private Long code;

    @ApiModelProperty(value = "name")
    private String name;

    @ApiModelProperty(value = "metricsCode")
    private String metricsCode;

    @ApiModelProperty(value = "subjectCategory")
    private SubjectCategoryEnum subjectCategory;

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

    @ApiModelProperty(value = "creator")
    private Integer creator;

    @ApiModelProperty(value = "operator")
    private Integer operator;

    @ApiModelProperty(value = "createTime")
    private Date createTime;

    @ApiModelProperty(value = "updateTime")
    private Date updateTime;
}
