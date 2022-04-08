package org.metahut.octopus.executor.api;

public abstract class AbstractExecutor {

    protected RunMode getRunMode() {
        return RunMode.Instant;
    }

    public final boolean isLazyRunMode() {
        return RunMode.Lazy == getRunMode();
    }

    public abstract void execute();

    public void addTransform(String script) {

    }

}
