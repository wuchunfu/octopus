package org.metahut.octopus.server.alerter;

import org.metahut.octopus.alerter.api.AbstractAlerterParameter;
import org.metahut.octopus.alerter.api.AbstractAlerterSourceParameter;
import org.metahut.octopus.alerter.api.IAlerterManager;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceLoader;

@Component
public class AlerterPluginParameterHelper {

    private static final Map<String, IAlerterManager> ALERTER_MANAGER_HASH_MAP = new HashMap<>();

    @PostConstruct
    public void init() {
        ServiceLoader.load(IAlerterManager.class).forEach(manager -> {

            String type = manager.getType();

            IAlerterManager alerterManager = ALERTER_MANAGER_HASH_MAP.get(type);

            if (Objects.nonNull(alerterManager)) {
                throw new IllegalArgumentException(MessageFormat.format("Duplicate alerter type exists: {0}", type));
            }

            ALERTER_MANAGER_HASH_MAP.put(type, manager);

        });
    }

    private IAlerterManager getAlerter(String type) {
        IAlerterManager manager = ALERTER_MANAGER_HASH_MAP.get(type);
        if (Objects.isNull(manager)) {
            throw new IllegalArgumentException(MessageFormat.format("alerter type does not exists: {0}", type));
        }
        return manager;
    }

    public Collection<String> queryAllTypes() {
        return ALERTER_MANAGER_HASH_MAP.keySet();
    }

    public AbstractAlerterParameter deserializeParameter(String type, String parameter) {
        return getAlerter(type).deserializeParameter(parameter);
    }

    public AbstractAlerterSourceParameter deserializeSourceParameter(String type, String parameter) {
        return getAlerter(type).deserializeSourceParameter(parameter);
    }

}
