package org.metahut.octopus.jobs.common;

import java.io.Serializable;
import java.util.List;

public class RuleInstance implements Serializable {
    private Long ruleInstanceCode;
    private String checkType;
    private String checkMethod;
    private String comparisonUnit;
    private String comparisonMethod;
    private List<String> expectedValue;

    public Long getRuleInstanceCode() {
        return ruleInstanceCode;
    }

    public void setRuleInstanceCode(Long ruleInstanceCode) {
        this.ruleInstanceCode = ruleInstanceCode;
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

    public String getComparisonUnit() {
        return comparisonUnit;
    }

    public void setComparisonUnit(String comparisonUnit) {
        this.comparisonUnit = comparisonUnit;
    }

    public String getComparisonMethod() {
        return comparisonMethod;
    }

    public void setComparisonMethod(String comparisonMethod) {
        this.comparisonMethod = comparisonMethod;
    }

    public List<String> getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(List<String> expectedValue) {
        this.expectedValue = expectedValue;
    }
}
