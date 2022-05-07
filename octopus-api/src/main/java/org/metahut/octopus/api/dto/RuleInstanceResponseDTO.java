package org.metahut.octopus.api.dto;

import org.metahut.octopus.common.enums.SubjectCategoryEnum;
import org.metahut.octopus.common.enums.ThresholdUnitEnum;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class RuleInstanceResponseDTO {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "code")
    private Long code;

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

    @ApiModelProperty(value = "creator")
    private Integer creator;

    @ApiModelProperty(value = "operator")
    private Integer operator;

    @ApiModelProperty(value = "createTime")
    private Date createTime;

    @ApiModelProperty(value = "updateTime")
    private Date updateTime;
}
