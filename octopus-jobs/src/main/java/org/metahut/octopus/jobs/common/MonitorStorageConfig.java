package org.metahut.octopus.jobs.common;

import org.metahut.octopus.monitordb.api.MonitorDBProperties;

public class MonitorStorageConfig {

    private MonitorDBProperties monitorStorage;

    public MonitorDBProperties getMonitorStorage() {
        return monitorStorage;
    }

    public void setMonitorStorage(MonitorDBProperties monitorStorage) {
        this.monitorStorage = monitorStorage;
    }
}
