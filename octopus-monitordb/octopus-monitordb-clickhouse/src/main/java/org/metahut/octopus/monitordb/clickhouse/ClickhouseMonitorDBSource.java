package org.metahut.octopus.monitordb.clickhouse;

import org.metahut.octopus.monitordb.api.IMonitorDBSource;
import org.metahut.octopus.monitordb.api.MetricsResult;
import org.metahut.octopus.monitordb.api.MetricsResultRequest;
import org.metahut.octopus.monitordb.api.MonitorDBException;
import org.metahut.octopus.monitordb.api.MonitorDBProperties;
import org.metahut.octopus.monitordb.api.MonitorLog;
import org.metahut.octopus.monitordb.api.MonitorLogRequest;
import org.metahut.octopus.monitordb.api.PageResponse;

import com.clickhouse.client.internal.google.common.base.Preconditions;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ClickhouseMonitorDBSource implements IMonitorDBSource {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClickhouseMonitorDBSource.class);
    private final JDBCDatasourceProvider jdbcDatasource;

    public ClickhouseMonitorDBSource(MonitorDBProperties.Clickhouse properties) {
        jdbcDatasource = JDBCDatasourceProvider.getInstance(properties);
    }

    @Override
    public List<Map<String, Object>> customSQLQuery(String sql) {
        try {
            QueryRunner queryRunner = new QueryRunner(jdbcDatasource.getDatasource());
            BeanProcessor processor = new GenerousBeanProcessor();
            RowProcessor rowProcessor = new BasicRowProcessor(processor);
            return queryRunner.query(sql, new MapListHandler(rowProcessor));
        } catch (SQLException e) {
            throw new MonitorDBException("MonitorDB custom sql query exception", e);
        }
    }

    @Override
    public <T> List<T> customSQLQuery(String sql, Class<T> classT) {
        try {
            QueryRunner queryRunner = new QueryRunner(jdbcDatasource.getDatasource());
            BeanProcessor processor = new GenerousBeanProcessor();
            RowProcessor rowProcessor = new BasicRowProcessor(processor);
            return queryRunner.query(sql, new BeanListHandler<>(classT, rowProcessor));
        } catch (SQLException e) {
            throw new MonitorDBException("MonitorDB custom sql query exception", e);
        }
    }

    @Override
    public PageResponse<MetricsResult> queryMetricsResultListPage(MetricsResultRequest request) {
        StringBuilder builder = new StringBuilder("select id,dataset_code,subject_code,subject_category,metrics_code,metrics_unique_key,metrics_value,create_time from monitor_metrics_result_all");

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
            QueryRunner queryRunner = new QueryRunner(jdbcDatasource.getDatasource());
            BeanProcessor processor = new GenerousBeanProcessor();
            RowProcessor rowProcessor = new BasicRowProcessor(processor);

            LOGGER.info("Clickhouse query sql:{}, parameters:{}", builder, parameters.stream().map(String::valueOf).collect(Collectors.joining(",")));
            List<MetricsResult> list = queryRunner.query(builder.toString(), new BeanListHandler<>(MetricsResult.class, rowProcessor), parameters.toArray(new Object[parameters.size()]));

            PageResponse<MetricsResult> pageResponse = new PageResponse<>();
            pageResponse.setPageNo(request.getPageNo());
            pageResponse.setPageSize(request.getPageSize());
            pageResponse.setData(list);
            return pageResponse;
        } catch (SQLException e) {
            throw new MonitorDBException("MonitorDB query metrics result list page exception", e);
        }
    }

    @Override
    public PageResponse<MonitorLog> queryMonitorLogListPage(MonitorLogRequest request) {

        StringBuilder builder = new StringBuilder("select id,rule_instance_code,datasource_code,dataset_code,metrics_code,metrics_config_code,subject_code,subject_category,"
            + "check_type,check_method,comparison_method,comparison_unit,expected_value,result,error,error_info,error_time,create_time "
            + "from monitor_rule_log_all");

        List<Object> parameters = new ArrayList<>();

        builder.append(" WHERE 1=1 ");
        if (StringUtils.isNotBlank(request.getDatasourceCode())) {
            builder.append(" AND datasource_code = ?");
            parameters.add(request.getDatasourceCode());
        }

        if (StringUtils.isNotBlank(request.getDatasetCode())) {
            builder.append(" AND dataset_code = ?");
            parameters.add(request.getDatasetCode());
        }

        if (StringUtils.isNotBlank(request.getSubjectCategory())) {
            builder.append(" AND subject_category = ?");
            parameters.add(request.getSubjectCategory());
        }

        if (StringUtils.isNotBlank(request.getMetricsCode())) {
            builder.append(" AND metrics_code = ?");
            parameters.add(request.getMetricsCode());
        }

        if (Objects.nonNull(request.getMetricsConfigCode())) {
            builder.append(" AND metrics_config_code = ?");
            parameters.add(request.getMetricsConfigCode());
        }

        if (StringUtils.isNotBlank(request.getCheckType())) {
            builder.append(" AND check_type = ?");
            parameters.add(request.getCheckType());
        }

        if (Objects.nonNull(request.getError())) {
            builder.append(" AND error = ?");
            parameters.add(request.getError());
        }

        if (Objects.nonNull(request.getErrorStartTime()) && Objects.nonNull(request.getErrorEndTime())) {
            builder.append(" AND error_time").append(" BETWEEN ? AND ?");
            parameters.add(request.getErrorStartTime());
            parameters.add(request.getErrorEndTime());
        }

        builder.append(" LIMIT ?,?");
        parameters.add((request.getPageNo() - 1) * request.getPageSize());
        parameters.add(request.getPageSize());
        try {
            QueryRunner queryRunner = new QueryRunner(jdbcDatasource.getDatasource());
            BeanProcessor processor = new GenerousBeanProcessor();
            RowProcessor rowProcessor = new BasicRowProcessor(processor);

            LOGGER.info("Clickhouse query sql:{}, parameters:{}", builder, parameters.stream().map(String::valueOf).collect(Collectors.joining(",")));
            List<MonitorLog> list = queryRunner.query(builder.toString(), new BeanListHandler<>(MonitorLog.class, rowProcessor), parameters.toArray(new Object[parameters.size()]));

            PageResponse<MonitorLog> pageResponse = new PageResponse<>();
            pageResponse.setPageNo(request.getPageNo());
            pageResponse.setPageSize(request.getPageSize());
            pageResponse.setData(list);
            return pageResponse;
        } catch (SQLException e) {
            throw new MonitorDBException("MonitorDB query monitor log list page exception", e);
        }
    }

    private static String convertCamelCaseToSnakeCase(String camelCase) {
        char[] chars = camelCase.toCharArray();
        boolean flag = false;
        StringBuilder snakeCase = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 65 && chars[i] <= 90) {
                if (i > 1 && !flag) {
                    snakeCase.append("_");
                }
                flag = true;
            } else {
                flag = false;
            }
            snakeCase.append(Character.toLowerCase(chars[i]));
        }
        return snakeCase.toString();
    }

    private static String convertToInsertSql(Object model, String database, String table) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS");
        Preconditions.checkArgument(Objects.nonNull(model) && StringUtils.isNotBlank(table), "The arguments of model and table can not be null.");
        StringBuilder columnsBuilder = new StringBuilder();
        StringBuilder valuesBuilder = new StringBuilder();
        StringBuilder wholeBuilder = new StringBuilder();
        try {
            Field[] fields = model.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                field.setAccessible(true);
                if (Objects.nonNull(field.get(model))) {
                    String fieldName = convertCamelCaseToSnakeCase(field.getName());
                    String typeName = field.getGenericType().getTypeName();
                    columnsBuilder.append(fieldName);
                    if (typeName.equalsIgnoreCase("java.lang.String") || typeName.equalsIgnoreCase("java.util.Date")) {
                        valuesBuilder.append("'");
                        if (typeName.equalsIgnoreCase("java.util.Date")) {
                            valuesBuilder.append(dateTimeFormatter.format(((Date) field.get(model)).toInstant().atZone(ZoneId.systemDefault())));
                        } else {
                            valuesBuilder.append(field.get(model).toString());
                        }
                        valuesBuilder.append("'");
                    } else {
                        valuesBuilder.append(field.get(model).toString());
                    }
                    if (columnsBuilder.length() > 0 && i < fields.length - 1) {
                        columnsBuilder.append(",");
                        valuesBuilder.append(",");
                    }
                }
            }

            if (columnsBuilder.charAt(columnsBuilder.length() - 1) == ',') {
                columnsBuilder = columnsBuilder.deleteCharAt(columnsBuilder.length() - 1);
            }

            if (valuesBuilder.charAt(valuesBuilder.length() - 1) == ',') {
                valuesBuilder = valuesBuilder.deleteCharAt(valuesBuilder.length() - 1);
            }

            wholeBuilder.append("insert into ");
            if (StringUtils.isNotBlank(database)) {
                wholeBuilder.append(database).append(".");
            }
            wholeBuilder.append(table).append("(");
            wholeBuilder.append(columnsBuilder);

            wholeBuilder.append(") values(");
            wholeBuilder.append(valuesBuilder);
            wholeBuilder.append(")");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return wholeBuilder.toString();
    }

    @Override
    public int saveMetricsResult(MetricsResult metricsResult) {
        String sql = convertToInsertSql(metricsResult, "quality", "monitor_metrics_result_all");
        try {
            QueryRunner queryRunner = new QueryRunner(jdbcDatasource.getDatasource());
            return queryRunner.update(sql);
        } catch (SQLException e) {
            LOGGER.error("The clickhouse execution sql:{}", sql);
            throw new MonitorDBException("Failed to save the metrics result into the monitor database.", e);
        }
    }

    @Override
    public int saveMonitorLog(MonitorLog monitorLog) {
        String sql = convertToInsertSql(monitorLog, "quality", "monitor_rule_log_all");
        try {
            QueryRunner queryRunner = new QueryRunner(jdbcDatasource.getDatasource());
            return queryRunner.update(sql);
        } catch (SQLException e) {
            LOGGER.error("The clickhouse execution sql:{}", sql);
            throw new MonitorDBException("Failed to save the monitor rule log into the monitor database.", e);
        }
    }

    @Override
    public void close() throws Exception {

    }
}
