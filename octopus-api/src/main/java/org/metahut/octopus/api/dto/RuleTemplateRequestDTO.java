package org.metahut.octopus.api.dto;

import org.metahut.octopus.common.enums.SubjectCategoryEnum;
import org.metahut.octopus.common.enums.ThresholdUnitEnum;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class RuleTemplateRequestDTO {

    private Long code;

    private String templateName;

    private String metricsName;

    private SubjectCategoryEnum subjectCategoryEnum;

    private String verificationType;

    private String verificationWay;

    private ThresholdUnitEnum thresholdUnit;

    private List<BigDecimal> thresholds;

    private Date createStartTime;

    private Date createEndTime;

    private Date updateStartTime;

    private Date updateEndTime;

    public RuleTemplateRequestDTO() {
    }

    public RuleTemplateRequestDTO(Long code, String templateName, String metricsName, SubjectCategoryEnum subjectCategoryEnum, String verificationType, String verificationWay, ThresholdUnitEnum thresholdUnit, List<BigDecimal> thresholds,
                                  Date createStartTime, Date createEndTime, Date updateStartTime, Date updateEndTime) {
        this.code = code;
        this.templateName = templateName;
        this.metricsName = metricsName;
        this.subjectCategoryEnum = subjectCategoryEnum;
        this.verificationType = verificationType;
        this.verificationWay = verificationWay;
        this.thresholdUnit = thresholdUnit;
        this.thresholds = thresholds;
        this.createStartTime = createStartTime;
        this.createEndTime = createEndTime;
        this.updateStartTime = updateStartTime;
        this.updateEndTime = updateEndTime;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getMetricsName() {
        return metricsName;
    }

    public void setMetricsName(String metricsName) {
        this.metricsName = metricsName;
    }

    public SubjectCategoryEnum getSubjectCategoryEnum() {
        return subjectCategoryEnum;
    }

    public void setSubjectCategoryEnum(SubjectCategoryEnum subjectCategoryEnum) {
        this.subjectCategoryEnum = subjectCategoryEnum;
    }

    public String getVerificationType() {
        return verificationType;
    }

    public void setVerificationType(String verificationType) {
        this.verificationType = verificationType;
    }

    public String getVerificationWay() {
        return verificationWay;
    }

    public void setVerificationWay(String verificationWay) {
        this.verificationWay = verificationWay;
    }

    public ThresholdUnitEnum getThresholdUnit() {
        return thresholdUnit;
    }

    public void setThresholdUnit(ThresholdUnitEnum thresholdUnit) {
        this.thresholdUnit = thresholdUnit;
    }

    public List<BigDecimal> getThresholds() {
        return thresholds;
    }

    public void setThresholds(List<BigDecimal> thresholds) {
        this.thresholds = thresholds;
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
