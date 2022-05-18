package org.metahut.octopus.monitordb.clickhouse;

import org.metahut.octopus.monitordb.api.IMonitorDBSource;
import org.metahut.octopus.monitordb.api.MetricsResult;
import org.metahut.octopus.monitordb.api.MonitorDBProperties;
import org.metahut.octopus.monitordb.api.MonitorLog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ClickhouseMonitorDBSource implements IMonitorDBSource {

    private static final Logger logger = LoggerFactory.getLogger(ClickhouseMonitorDBSource.class);
    private final JDBCDataSourceProvider jdbcDataSource;

    public ClickhouseMonitorDBSource(MonitorDBProperties.Clickhouse properties) {
        jdbcDataSource = JDBCDataSourceProvider.getInstance(properties);
    }

    @Override
    public String customSQLQuery() {
        try {
            Connection connection = jdbcDataSource.getConnection();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        } finally {
            jdbcDataSource.close(null, null, null);
        }

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

    @Override
    public void close() throws Exception {

    }
}
