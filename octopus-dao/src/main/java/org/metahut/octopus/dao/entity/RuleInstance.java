package org.metahut.octopus.dao.entity;

import org.metahut.octopus.common.enums.RuleStateEnum;
import org.metahut.octopus.common.enums.SubjectCategoryEnum;
import org.metahut.octopus.common.enums.TaskTypeEnum;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "tb_octopus_rule_instance")
public class RuleInstance extends BaseEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private Long code;

    private String name;

    @ManyToOne
    @JoinColumn(name = "metrics_code", referencedColumnName = "code")
    private Metrics metrics;

    @ManyToOne
    @JoinColumn(name = "metrics_config_code", referencedColumnName = "code")
    private MetricsConfig metricsConfig;

    private String metricsParams;

    @Enumerated(value = EnumType.STRING)
    private SubjectCategoryEnum subjectCategory;

    private String subjectCode;

    private String metricsUniqueKey;

    private String filter;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sample_code", referencedColumnName = "code")
    private SampleInstance sampleInstance;

    @Enumerated(value = EnumType.STRING)
    private TaskTypeEnum taskType;

    private String checkType;

    private String checkMethod;

    private String comparisonMethod;

    private String expectedValue;

    @Enumerated(value = EnumType.STRING)
    private RuleStateEnum state;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "source_code", referencedColumnName = "sourceCode")
    private FlowDefinition flowDefinition;

    private String description;

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

    public Metrics getMetrics() {
        return metrics;
    }

    public void setMetrics(Metrics metrics) {
        this.metrics = metrics;
    }

    public MetricsConfig getMetricsConfig() {
        return metricsConfig;
    }

    public void setMetricsConfig(MetricsConfig metricsConfig) {
        this.metricsConfig = metricsConfig;
    }

    public FlowDefinition getFlowDefinition() {
        return flowDefinition;
    }

    public void setFlowDefinition(FlowDefinition flowDefinition) {
        this.flowDefinition = flowDefinition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getMetricsUniqueKey() {
        return metricsUniqueKey;
    }

    public void setMetricsUniqueKey(String metricsUniqueKey) {
        this.metricsUniqueKey = metricsUniqueKey;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public SampleInstance getSampleInstance() {
        return sampleInstance;
    }

    public void setSampleInstance(SampleInstance sampleInstance) {
        this.sampleInstance = sampleInstance;
    }

    public TaskTypeEnum getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskTypeEnum taskType) {
        this.taskType = taskType;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public String getCheckMethod() {
        return checkMethod;
    }

    public void setCheckMethod(String checkMethod) {
        this.checkMethod = checkMethod;
    }

    public String getComparisonMethod() {
        return comparisonMethod;
    }

    public void setComparisonMethod(String comparisonMethod) {
        this.comparisonMethod = comparisonMethod;
    }

    public String getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(String expectedValue) {
        this.expectedValue = expectedValue;
    }

    public RuleStateEnum getState() {
        return state;
    }

    public void setState(RuleStateEnum state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
