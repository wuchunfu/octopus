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

    @ApiModelProperty(value = "source code")
    private String sourceCode;

    @ApiModelProperty(value = "crontab")
    private String crontab;

    @ApiModelProperty(value = "rule tnstances")
    private List<RuleInstanceCreateOrUpdateRequestDTO> ruleInstances;

    @ApiModelProperty(value = "source alert relations")
    private List<SourceAlertRelationCreateOrUpdateRequestDTO> sourceAlertRelations;

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

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
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

    public List<SourceAlertRelationCreateOrUpdateRequestDTO> getSourceAlertRelations() {
        return sourceAlertRelations;
    }

    public void setSourceAlertRelations(List<SourceAlertRelationCreateOrUpdateRequestDTO> sourceAlertRelations) {
        this.sourceAlertRelations = sourceAlertRelations;
    }

    public SampleInstanceCreateOrUpdateRequestDTO getSampleInstance() {
        return sampleInstance;
    }

    public void setSampleInstance(SampleInstanceCreateOrUpdateRequestDTO sampleInstance) {
        this.sampleInstance = sampleInstance;
    }
}
