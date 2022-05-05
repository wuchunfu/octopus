package org.metahut.octopus.server.alerter;

import org.metahut.octopus.alerter.api.AbstractParameter;
import org.metahut.octopus.alerter.api.IAlerter;
import org.metahut.octopus.alerter.api.IAlerterManager;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.MessageFormat;
import java.util.*;

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

    private IAlerterManager getAlerter(String type) {
        IAlerterManager manager = alerterMap.get(type);
        if (Objects.isNull(manager)) {
            throw new IllegalArgumentException(MessageFormat.format("alerter type does not exists: {0}", type));
        }
        return manager;
    }

    public Collection<String> queryAllTypes() {
        return alerterMap.keySet();
    }

    public AbstractParameter getParameter(String type, String parameter) {
        return getAlerter(type).getParameter(parameter);
    }

    public IAlerter generateInstance(String type, String parameter) {
        return getAlerter(type).generateInstance(parameter);
    }
}
