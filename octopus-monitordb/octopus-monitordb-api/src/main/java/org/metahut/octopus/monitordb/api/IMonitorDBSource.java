package org.metahut.octopus.monitordb.api;

import java.util.List;

public interface IMonitorDBSource extends AutoCloseable {

    String customSQLQuery();

    List<MetricsResult> queryMetricsResults();

    List<MonitorLog> queryMonitorLogs();

    // 为规则SQL提供子类
}
