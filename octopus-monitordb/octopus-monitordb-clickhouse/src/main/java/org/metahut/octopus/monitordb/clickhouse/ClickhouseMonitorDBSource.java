package org.metahut.octopus.monitordb.clickhouse;

import org.metahut.octopus.monitordb.api.IMonitorDBSource;
import org.metahut.octopus.monitordb.api.MetricsResult;
import org.metahut.octopus.monitordb.api.MetricsResultRequest;
import org.metahut.octopus.monitordb.api.MonitorDBException;
import org.metahut.octopus.monitordb.api.MonitorDBProperties;
import org.metahut.octopus.monitordb.api.MonitorLog;
import org.metahut.octopus.monitordb.api.MonitorLogRequest;
import org.metahut.octopus.monitordb.api.PageResponse;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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
        StringBuilder builder = new StringBuilder("select id,source_code,subject_code,subject_category,metrics_code,metrics_unique_key,metrics_value,create_time from monitor_metrics_result");

        List<Object> parameters = new ArrayList<>();

        builder.append(" WHERE 1=1 ");
        List<String> metricsCodes = request.getMetricsCodes();
        if (CollectionUtils.isNotEmpty(request.getMetricsCodes())) {
            int size = metricsCodes.size();
            builder.append(" AND metrics_code").append(" IN (");
            for (int i = 0; i < size; i++) {
                if (i == size - 1) {
                    builder.append("?");
                } else {
                    builder.append("?,");
                }
                parameters.add(metricsCodes.get(i));
            }
            builder.append(") ");
        }

        if (Objects.nonNull(request.getCreateStartTime()) && Objects.nonNull(request.getCreateEndTime())) {
            builder.append(" AND create_time").append(" BETWEEN ? AND ?");
            parameters.add(request.getCreateStartTime());
            parameters.add(request.getCreateEndTime());
        }

        builder.append(" LIMIT ?,?");
        parameters.add((request.getPageNo() - 1) * request.getPageSize());
        parameters.add(request.getPageSize());
        try {
            QueryRunner queryRunner = new QueryRunner(jdbcDataSource.getDatasource());
            logger.info("Clickhouse query sql:{}, parameters:{}", builder, parameters.stream().map(String::valueOf).collect(Collectors.joining(",")));
            List<MetricsResult> list = queryRunner.query(builder.toString(), new BeanListHandler<>(MetricsResult.class), parameters.toArray(new Object[parameters.size()]));

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

        StringBuilder builder = new StringBuilder("select id,rule_instance_code,datasource_code,dataset_code,metrics_code,metrics_config_code,subject_code,subject_category,"
                + "checkType,checkMethod,comparisonMethod,expectedValue,result,error,error_info,error_time,create_time "
                + "from monitor_rule_log");

        List<Object> parameters = new ArrayList<>();

        builder.append(" LIMIT ?,?");
        parameters.add((request.getPageNo() - 1) * request.getPageSize());
        parameters.add(request.getPageSize());
        try {
            QueryRunner queryRunner = new QueryRunner(jdbcDataSource.getDatasource());
            logger.info("Clickhouse query sql:{}, parameters:{}", builder, parameters.stream().map(String::valueOf).collect(Collectors.joining(",")));
            List<MonitorLog> list = queryRunner.query(builder.toString(), new BeanListHandler<>(MonitorLog.class), parameters.toArray(new Object[parameters.size()]));

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
