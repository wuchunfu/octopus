package org.metahut.octopus.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description = "monitor flow definition create or update request dto")
public class MonitorFlowDefinitionCreateOrUpdateRequestDTO {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "code")
    private Long code;

    @ApiModelProperty(value = "dataset code")
    private String datasetCode;

    @ApiModelProperty(value = "crontab")
    private String crontab;

    @ApiModelProperty(value = "rule tnstances")
    private List<RuleInstanceCreateOrUpdateRequestDTO> ruleInstances;

    @ApiModelProperty(value = "alert instances")
    private List<AlerterInstanceCreateOrUpdateRequestDTO> alerterInstances;

    @ApiModelProperty(value = "sample instance")
    private SampleInstanceCreateOrUpdateRequestDTO sampleInstance;

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

    public String getDatasetCode() {
        return datasetCode;
    }

    public void setDatasetCode(String datasetCode) {
        this.datasetCode = datasetCode;
    }

    public String getCrontab() {
        return crontab;
    }

    public void setCrontab(String crontab) {
        this.crontab = crontab;
    }

    public List<RuleInstanceCreateOrUpdateRequestDTO> getRuleInstances() {
        return ruleInstances;
    }

    public void setRuleInstances(List<RuleInstanceCreateOrUpdateRequestDTO> ruleInstances) {
        this.ruleInstances = ruleInstances;
    }

    public List<AlerterInstanceCreateOrUpdateRequestDTO> getAlerterInstances() {
        return alerterInstances;
    }

    public void setAlerterInstances(List<AlerterInstanceCreateOrUpdateRequestDTO> alerterInstances) {
        this.alerterInstances = alerterInstances;
    }

    public SampleInstanceCreateOrUpdateRequestDTO getSampleInstance() {
        return sampleInstance;
    }

    public void setSampleInstance(SampleInstanceCreateOrUpdateRequestDTO sampleInstance) {
        this.sampleInstance = sampleInstance;
    }
}
