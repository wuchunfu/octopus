package org.metahut.octopus.api.dto;

import org.metahut.octopus.common.enums.SubjectCategoryEnum;
import org.metahut.octopus.common.enums.ThresholdUnitEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "rule create or update request dto")
public class RuleInstanceRequestDTO extends PageRequestDTO {

    @ApiModelProperty(value = "id")
    private Integer id;

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
}
