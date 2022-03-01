package org.metahut.octopus.alerter.server;

import org.metahut.octopus.alerter.api.AlerterManager;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceLoader;

@Component
public class AlerterPluginHelper {

    private static final Map<String, AlerterManager> alerterMap = new HashMap<>();

    @PostConstruct
    public void init() {
        ServiceLoader.load(AlerterManager.class).forEach(manager -> {

            String type = manager.getType();

            AlerterManager alerterManager = alerterMap.get(type);

            if (Objects.nonNull(alerterManager)) {
                throw new IllegalArgumentException(MessageFormat.format("Duplicate alerter type exists: {0}", type));
            }

            alerterMap.put(type, manager);

        });
    }

    public AlerterManager getAlerter(String type) {
        return alerterMap.get(type);
    }
}
