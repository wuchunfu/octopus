package org.metahut.octopus.engine.domain;

import java.util.HashMap;
import java.util.Map;

public class SampleExecuteInstance {

    private String parameter;

    private Map<String, MetricsExecuteInstance> nextNodes = new HashMap<>();

    public SampleExecuteInstance() {
    }

    public SampleExecuteInstance(String parameter) {
        this.parameter = parameter;
    }

    public static SampleExecuteInstance of(String parameter) {
        return new SampleExecuteInstance(parameter);
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public Map<String, MetricsExecuteInstance> getNextNodes() {
        return nextNodes;
    }

    public void setNextNodes(Map<String, MetricsExecuteInstance> nextNodes) {
        this.nextNodes = nextNodes;
    }
}
