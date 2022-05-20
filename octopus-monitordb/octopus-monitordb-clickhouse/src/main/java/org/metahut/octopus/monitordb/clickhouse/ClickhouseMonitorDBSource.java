package org.metahut.octopus.monitordb.clickhouse;

import org.metahut.octopus.monitordb.api.IMonitorDBSource;
import org.metahut.octopus.monitordb.api.MetricsResult;
import org.metahut.octopus.monitordb.api.MetricsResultRequest;
import org.metahut.octopus.monitordb.api.MonitorDBException;
import org.metahut.octopus.monitordb.api.MonitorDBProperties;
import org.metahut.octopus.monitordb.api.MonitorLog;
import org.metahut.octopus.monitordb.api.MonitorLogRequest;
import org.metahut.octopus.monitordb.api.PageResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ClickhouseMonitorDBSource implements IMonitorDBSource {

    private static final Logger logger = LoggerFactory.getLogger(ClickhouseMonitorDBSource.class);
    private final JDBCDataSourceProvider jdbcDataSource;

    public ClickhouseMonitorDBSource(MonitorDBProperties.Clickhouse properties) {
        jdbcDataSource = JDBCDataSourceProvider.getInstance(properties);
    }

    @Override
    public List<Map<String, Object>> customSQLQuery(String sql) {
        try {
            QueryRunner queryRunner = new QueryRunner(jdbcDataSource.getDatasource());
            return queryRunner.query(sql, new MapListHandler());
        } catch (SQLException e) {
            throw new MonitorDBException("MonitorDB custom sql query exception", e);
        }
    }

    @Override
    public PageResponse<MetricsResult> queryMetricsResultListPage(MetricsResultRequest request) {
        String sql = "";
        try {
            Object[] parameter = null;
            QueryRunner queryRunner = new QueryRunner(jdbcDataSource.getDatasource());
            List<MetricsResult> list = queryRunner.query(sql, new BeanListHandler<>(MetricsResult.class), parameter);

            PageResponse<MetricsResult> pageResponse = new PageResponse<>();
            pageResponse.setPageNo(request.getPageNo());
            pageResponse.setPageSize(list.size());
            pageResponse.setData(list);
            return pageResponse;
        } catch (SQLException e) {
            throw new MonitorDBException("MonitorDB query metrics result list page exception", e);
        }
    }

    @Override
    public PageResponse<MonitorLog> queryMonitorLogListPage(MonitorLogRequest request) {

        String sql = "";
        try {
            Object[] parameter = null;
            QueryRunner queryRunner = new QueryRunner(jdbcDataSource.getDatasource());
            List<MonitorLog> list = queryRunner.query(sql, new BeanListHandler<>(MonitorLog.class), parameter);

            PageResponse<MonitorLog> pageResponse = new PageResponse<>();
            pageResponse.setPageNo(request.getPageNo());
            pageResponse.setPageSize(list.size());
            pageResponse.setData(list);
            return pageResponse;
        } catch (SQLException e) {
            throw new MonitorDBException("MonitorDB query monitor log list page exception", e);
        }
    }

    @Override
    public void close() throws Exception {

    }
}
