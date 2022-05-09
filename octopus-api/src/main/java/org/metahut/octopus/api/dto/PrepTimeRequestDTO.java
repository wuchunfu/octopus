package org.metahut.octopus.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "prepTime response")
public class PrepTimeRequestDTO {

    @ApiModelProperty(value = "partitionExp")
    private String partitionExp;

    @ApiModelProperty(value = "date")
    private Date date;
}
