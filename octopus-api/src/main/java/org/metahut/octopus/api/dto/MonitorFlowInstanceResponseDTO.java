package org.metahut.octopus.api.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class MonitorFlowInstanceResponseDTO {

    private MonitorFlowDefinitionResponseDTO flowDefinition;

    private String schedulerInstanceCode;

    private String executionStatus;

    private Date taskBeginTime;

    private Date taskEndTime;




}
