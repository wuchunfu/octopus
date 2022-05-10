package org.metahut.octopus.executor.api;

public interface IExecutorManager {

    String getType();

    AbstractExecutor generateInstance(String parameter);

    boolean isLazyRunMode();
}
