package org.metahut.octopus.engine.executor;

import org.metahut.octopus.executor.api.IExecutorManager;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceLoader;

@Component
public class ExecutorPluginHelper {

    private static final Map<String, IExecutorManager> executorMap = new HashMap<>();

    @PostConstruct
    public void init() {
        ServiceLoader.load(IExecutorManager.class).forEach(manager -> {

            String type = manager.getType();

            IExecutorManager executorManager = executorMap.get(type);

            if (Objects.nonNull(executorManager)) {
                throw new IllegalArgumentException(MessageFormat.format("Duplicate executor type exists: {0}", type));
            }

            executorMap.put(type, manager);

        });
    }

    public IExecutorManager getExecutor(String type) {
        return executorMap.get(type);
    }
}
