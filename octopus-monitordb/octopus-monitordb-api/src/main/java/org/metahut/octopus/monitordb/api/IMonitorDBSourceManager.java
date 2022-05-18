package org.metahut.octopus.monitordb.api;

public interface IMonitorDBSourceManager extends AutoCloseable {

    MonitorDBTypeEnum getType();

    void init(MonitorDBProperties monitorDBProperties);

    IMonitorDBSource getMonitorDBSource();
}
