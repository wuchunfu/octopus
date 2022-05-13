package org.metahut.octopus.api.dto;

import org.metahut.octopus.common.enums.SubjectCategoryEnum;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class RuleTemplateConditionRequestDTO extends PageRequestDTO {

    @ApiModelProperty(value = "name")
    private String name;

    @ApiModelProperty(value = "metricsCode")
    private String metricsCode;

    @ApiModelProperty(value = "metricsName")
    private String metricsName;

    @ApiModelProperty(value = "subjectCategories")
    private List<SubjectCategoryEnum> subjectCategories;

    @ApiModelProperty(value = "checkTypes")
    private List<String> checkTypes;

    @ApiModelProperty(value = "checkMethods")
    private List<String> checkMethods;

    @ApiModelProperty(value = "createStartTime")
    private Date createStartTime;

    @ApiModelProperty(value = "createEndTime")
    private Date createEndTime;

    @ApiModelProperty(value = "updateStartTime")
    private Date updateStartTime;

    @ApiModelProperty(value = "updateEndTime")
    private Date updateEndTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMetricsCode() {
        return metricsCode;
    }

    public void setMetricsCode(String metricsCode) {
        this.metricsCode = metricsCode;
    }

    public String getMetricsName() {
        return metricsName;
    }

    public void setMetricsName(String metricsName) {
        this.metricsName = metricsName;
    }

    public List<SubjectCategoryEnum> getSubjectCategories() {
        return subjectCategories;
    }

    public void setSubjectCategories(List<SubjectCategoryEnum> subjectCategories) {
        this.subjectCategories = subjectCategories;
    }

    public List<String> getCheckTypes() {
        return checkTypes;
    }

    public void setCheckTypes(List<String> checkTypes) {
        this.checkTypes = checkTypes;
    }

    public List<String> getCheckMethods() {
        return checkMethods;
    }

    public void setCheckMethods(List<String> checkMethods) {
        this.checkMethods = checkMethods;
    }

    public Date getCreateStartTime() {
        return createStartTime;
    }

    public void setCreateStartTime(Date createStartTime) {
        this.createStartTime = createStartTime;
    }

    public Date getCreateEndTime() {
        return createEndTime;
    }

    public void setCreateEndTime(Date createEndTime) {
        this.createEndTime = createEndTime;
    }

    public Date getUpdateStartTime() {
        return updateStartTime;
    }

    public void setUpdateStartTime(Date updateStartTime) {
        this.updateStartTime = updateStartTime;
    }

    public Date getUpdateEndTime() {
        return updateEndTime;
    }

    public void setUpdateEndTime(Date updateEndTime) {
        this.updateEndTime = updateEndTime;
    }
}
