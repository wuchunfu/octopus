package org.metahut.octopus.jobs.util;

import org.metahut.octopus.jobs.common.MonitorStorageConfig;
import org.metahut.octopus.monitordb.api.IMonitorDBSource;
import org.metahut.octopus.monitordb.api.IMonitorDBSourceManager;
import org.metahut.octopus.monitordb.api.MonitorDBTypeEnum;

import org.apache.flink.shaded.jackson2.org.yaml.snakeyaml.Yaml;

import java.util.ServiceLoader;

public class MonitorDBPluginHelper {

    private static final String monitorDatasourceResourcePath = "monitor-datasource.yaml";

    private static IMonitorDBSourceManager monitorDBSourceManager;

    static {
        MonitorStorageConfig monitorStorageConfig = new Yaml().loadAs(
            MonitorDBPluginHelper.class.getClassLoader().getResourceAsStream(monitorDatasourceResourcePath), MonitorStorageConfig.class);

        ServiceLoader.load(IMonitorDBSourceManager.class).forEach(manager -> {
            MonitorDBTypeEnum type = manager.getType();
            if (monitorStorageConfig.getMonitorStorage().getType() == type) {
                monitorDBSourceManager = manager;
                monitorDBSourceManager.init(monitorStorageConfig.getMonitorStorage());
                return;
            }
        });
    }

    public static IMonitorDBSource getMonitorDBSource() {
        return monitorDBSourceManager.getMonitorDBSource();
    }
}
