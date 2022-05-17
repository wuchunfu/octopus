package org.metahut.octopus.server.monitordb;

import org.metahut.octopus.alerter.api.AbstractParameter;
import org.metahut.octopus.alerter.api.IAlerter;
import org.metahut.octopus.alerter.api.IAlerterManager;
import org.metahut.octopus.monitordb.api.IMonitorDBSourceManager;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.MessageFormat;
import java.util.*;

@Component
public class MonitorDBPluginHelpher {

    private static final Map<String, IMonitorDBSourceManager> MONITOR_DB_SOURCE_MANAGER_MAP = new HashMap<>();

    @PostConstruct
    public void init() {
        ServiceLoader.load(IMonitorDBSourceManager.class).forEach(manager -> {

            String type = manager.getType();

            IMonitorDBSourceManager monitorDBSourceManager = MONITOR_DB_SOURCE_MANAGER_MAP.get(type);

            if (Objects.nonNull(monitorDBSourceManager)) {
                throw new IllegalArgumentException(MessageFormat.format("Duplicate monitorDB type exists: {0}", type));
            }

            MONITOR_DB_SOURCE_MANAGER_MAP.put(type, manager);

        });
    }

    private IMonitorDBSourceManager getMonitorDBSourceManager(String type) {
        IMonitorDBSourceManager manager = MONITOR_DB_SOURCE_MANAGER_MAP.get(type);
        if (Objects.isNull(manager)) {
            throw new IllegalArgumentException(MessageFormat.format("monitorDB type does not exists: {0}", type));
        }
        return manager;
    }


}
