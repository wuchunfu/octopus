package org.metahut.octopus.monitordb.api;

import java.util.List;
import java.util.Map;

public interface IMonitorDBSource extends AutoCloseable {

    List<Map<String, Object>> customSQLQuery(String sql);

    PageResponse<MetricsResult> queryMetricsResultListPage(MetricsResultRequest request);

    PageResponse<MonitorLog> queryMonitorLogListPage(MonitorLogRequest request);

}
