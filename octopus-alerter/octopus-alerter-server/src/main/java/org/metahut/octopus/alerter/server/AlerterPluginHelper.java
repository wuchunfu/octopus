package org.metahut.octopus.alerter.server;

import org.metahut.octopus.alerter.api.IAlerterManager;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceLoader;

@Component
public class AlerterPluginHelper {

    private static final Map<String, IAlerterManager> alerterMap = new HashMap<>();

    @PostConstruct
    public void init() {
        ServiceLoader.load(IAlerterManager.class).forEach(manager -> {

            String type = manager.getType();

            IAlerterManager alerterManager = alerterMap.get(type);

            if (Objects.nonNull(alerterManager)) {
                throw new IllegalArgumentException(MessageFormat.format("Duplicate alerter type exists: {0}", type));
            }

            alerterMap.put(type, manager);

        });
    }

    public IAlerterManager getAlerter(String type) {
        return alerterMap.get(type);
    }
}
