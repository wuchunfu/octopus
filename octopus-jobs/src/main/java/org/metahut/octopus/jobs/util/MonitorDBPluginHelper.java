package org.metahut.octopus.jobs.util;

import org.metahut.octopus.jobs.common.MonitorConfig;
import org.metahut.octopus.monitordb.api.IMonitorDBSource;
import org.metahut.octopus.monitordb.api.IMonitorDBSourceManager;
import org.metahut.octopus.monitordb.api.MonitorDBTypeEnum;

import java.util.ServiceLoader;

public class MonitorDBPluginHelper {

    private static IMonitorDBSourceManager monitorDBSourceManager;

    static {
        MonitorConfig monitorConfig = MonitorConfig.getMonitorConfig();

        ServiceLoader.load(IMonitorDBSourceManager.class).forEach(manager -> {
            MonitorDBTypeEnum type = manager.getType();
            if (monitorConfig.getMonitorStorage().getType() == type) {
                monitorDBSourceManager = manager;
                monitorDBSourceManager.init(monitorConfig.getMonitorStorage());
                return;
            }
        });
    }

    public static IMonitorDBSource getMonitorDBSource() {
        return monitorDBSourceManager.getMonitorDBSource();
    }
}
