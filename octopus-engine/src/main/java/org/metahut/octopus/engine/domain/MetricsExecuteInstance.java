package org.metahut.octopus.engine.domain;

import org.metahut.octopus.common.enums.SubjectCategoryEnum;
import org.metahut.octopus.common.utils.JSONUtils;

import java.util.ArrayList;
import java.util.List;

public class MetricsExecuteInstance {

    private SubjectCategoryEnum subjectCategory;
    private String subjectCode;
    private String metricsCode;
    private String filter;
    private String metricsParams;
    private String metricsUniqueKey;
    private List<RuleExecuteInstance> rules = new ArrayList<>();

    public String generateParameter() {
        return JSONUtils.toJSONString(this);
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

    public String getMetricsCode() {
        return metricsCode;
    }

    public void setMetricsCode(String metricsCode) {
        this.metricsCode = metricsCode;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getMetricsParams() {
        return metricsParams;
    }

    public void setMetricsParams(String metricsParams) {
        this.metricsParams = metricsParams;
    }

    public String getMetricsUniqueKey() {
        return metricsUniqueKey;
    }

    public void setMetricsUniqueKey(String metricsUniqueKey) {
        this.metricsUniqueKey = metricsUniqueKey;
    }

    public List<RuleExecuteInstance> getRules() {
        return rules;
    }

    public void setRules(List<RuleExecuteInstance> rules) {
        this.rules = rules;
    }
}
