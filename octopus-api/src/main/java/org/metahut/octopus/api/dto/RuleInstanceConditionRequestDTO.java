package org.metahut.octopus.api.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class RuleInstanceConditionRequestDTO {

    @ApiModelProperty(value = "tableCode")
    private Integer tableCode;

    @ApiModelProperty(value = "sourceCode")
    private Integer sourceCode;

    @ApiModelProperty(value = "dataType")
    private Integer dataType;

    @ApiModelProperty(value = "createStartTime")
    private Date createStartTime;

    @ApiModelProperty(value = "createEndTime")
    private Date createEndTime;

    @ApiModelProperty(value = "updateStartTime")
    private Date updateStartTime;

    @ApiModelProperty(value = "updateEndTime")
    private Date updateEndTime;
}
