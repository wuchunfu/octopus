package org.metahut.octopus.executor.flink;

import org.metahut.octopus.executor.api.AbstractExecutor;
import org.metahut.octopus.executor.api.RunMode;

public class FlinkSQLExecutor extends AbstractExecutor {


    @Override
    protected RunMode getRunMode() {
        return RunMode.Lazy;
    }

    @Override
    public void addTransform(String script) {

    }

    @Override
    public void execute() {

    }
}
