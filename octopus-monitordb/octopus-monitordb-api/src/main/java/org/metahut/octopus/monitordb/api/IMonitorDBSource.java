package org.metahut.octopus.monitordb.api;

import org.metahut.octopus.monitordb.api.entity.MetricsResult;
import org.metahut.octopus.monitordb.api.entity.MetricsResultRequest;
import org.metahut.octopus.monitordb.api.entity.MonitorLog;
import org.metahut.octopus.monitordb.api.entity.MonitorLogRequest;

import java.util.List;
import java.util.Map;

public interface IMonitorDBSource extends AutoCloseable {

    List<Map<String, Object>> customSQLQuery(String sql);

    List<MetricsResult> queryMetricsResults(MetricsResultRequest request);

    List<MonitorLog> queryMonitorLogs(MonitorLogRequest request);

    // 为规则SQL提供子类
}
