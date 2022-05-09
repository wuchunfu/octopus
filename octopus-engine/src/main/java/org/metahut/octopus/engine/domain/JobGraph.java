package org.metahut.octopus.engine.domain;

import org.metahut.octopus.executor.api.IExecutor;

import java.util.ArrayList;
import java.util.List;

public class JobGraph {

    private IExecutor executor;

    private List<IExecutor> nextNodes = new ArrayList<>();

    public IExecutor getExecutor() {
        return executor;
    }

    public void setExecutor(IExecutor executor) {
        this.executor = executor;
    }

    public List<IExecutor> getNextNodes() {
        return nextNodes;
    }

    public void setNextNodes(List<IExecutor> nextNodes) {
        this.nextNodes = nextNodes;
    }
}
