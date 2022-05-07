package org.metahut.octopus.api.dto;

import org.metahut.octopus.common.enums.SubjectCategoryEnum;
import org.metahut.octopus.common.enums.ThresholdUnitEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@ApiModel(value = "ruleTemplate response")
public class RuleTemplateResponseDTO {
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "code")
    private Long code;

    @ApiModelProperty(value = "templateName")
    private String templateName;

    @ApiModelProperty(value = "metricsName")
    private String metricsName;

    @ApiModelProperty(value = "subjectCategoryEnum")
    private SubjectCategoryEnum subjectCategoryEnum;

    @ApiModelProperty(value = "verificationType")
    private String verificationType;

    @ApiModelProperty(value = "verificationWay")
    private String verificationWay;

    @ApiModelProperty(value = "thresholdUnit")
    private ThresholdUnitEnum thresholdUnit;

    @ApiModelProperty(value = "thresholds")
    private List<BigDecimal> thresholds;

    @ApiModelProperty(value = "creator")
    private Integer creator;

    @ApiModelProperty(value = "operator")
    private Integer operator;

    @ApiModelProperty(value = "createTime")
    private Date createTime;

    @ApiModelProperty(value = "updateTime")
    private Date updateTime;
}
