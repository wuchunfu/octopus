package org.metahut.octopus.executor.api;

public interface IExecutor {

    void execute();

    void addTransform(String script);
}
