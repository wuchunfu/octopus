package org.metahut.octopus.monitordb.clickhouse;

import org.metahut.octopus.monitordb.api.IMonitorDBSource;
import org.metahut.octopus.monitordb.api.MetricsResult;
import org.metahut.octopus.monitordb.api.MonitorLog;

import java.util.List;

public class ClickhouseMonitorDBSource implements IMonitorDBSource {

    @Override
    public String customSQLQuery() {
        return null;
    }

    @Override
    public List<MetricsResult> queryMetricsResults() {
        return null;
    }

    @Override
    public List<MonitorLog> queryMonitorLogs() {
        return null;
    }
}
