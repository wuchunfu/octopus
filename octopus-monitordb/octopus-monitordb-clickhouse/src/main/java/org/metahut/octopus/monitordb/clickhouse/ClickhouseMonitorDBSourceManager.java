package org.metahut.octopus.monitordb.clickhouse;

import org.metahut.octopus.monitordb.api.IMonitorDBSource;
import org.metahut.octopus.monitordb.api.IMonitorDBSourceManager;
import org.metahut.octopus.monitordb.api.MonitorDBProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

public class ClickhouseMonitorDBSourceManager implements IMonitorDBSourceManager {

    @Override
    public String getType() {
        return "clickhouse";
    }

    @Override
    public IMonitorDBSource getMonitorDBSource() {
        return null;
    }

}
