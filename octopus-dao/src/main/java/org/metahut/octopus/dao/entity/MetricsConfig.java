package org.metahut.octopus.dao.entity;

import org.metahut.octopus.common.enums.CreateTypeEnum;
import org.metahut.octopus.common.enums.SubjectCategoryEnum;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_octopus_metrics_config")
public class MetricsConfig {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer code;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "metrics_code", referencedColumnName = "code")
    private Metrics metrics;

    @Enumerated(value = EnumType.STRING)
    private CreateTypeEnum createType;

    private String metricsParams;

    @Enumerated(value = EnumType.STRING)
    private SubjectCategoryEnum subjectCategory;

    private String sourceCategory;

    private String description;

    private String computeMode;

    private String computeScript;

    private Date createTime;

    private Date updateTime;

    private Integer creator;

    private Integer updater;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Metrics getMetrics() {
        return metrics;
    }

    public void setMetrics(Metrics metrics) {
        this.metrics = metrics;
    }

    public CreateTypeEnum getCreateType() {
        return createType;
    }

    public void setCreateType(CreateTypeEnum createType) {
        this.createType = createType;
    }

    public String getMetricsParams() {
        return metricsParams;
    }

    public void setMetricsParams(String metricsParams) {
        this.metricsParams = metricsParams;
    }

    public SubjectCategoryEnum getSubjectCategory() {
        return subjectCategory;
    }

    public void setSubjectCategory(SubjectCategoryEnum subjectCategory) {
        this.subjectCategory = subjectCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Integer getUpdater() {
        return updater;
    }

    public void setUpdater(Integer updater) {
        this.updater = updater;
    }

    public String getSourceCategory() {
        return sourceCategory;
    }

    public void setSourceCategory(String sourceCategory) {
        this.sourceCategory = sourceCategory;
    }

    public String getComputeMode() {
        return computeMode;
    }

    public void setComputeMode(String computeMode) {
        this.computeMode = computeMode;
    }

    public String getComputeScript() {
        return computeScript;
    }

    public void setComputeScript(String computeScript) {
        this.computeScript = computeScript;
    }
}
