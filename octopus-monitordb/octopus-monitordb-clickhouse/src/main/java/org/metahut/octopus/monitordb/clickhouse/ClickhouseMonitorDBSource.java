package org.metahut.octopus.monitordb.clickhouse;

import org.metahut.octopus.monitordb.api.IMonitorDBSource;
import org.metahut.octopus.monitordb.api.MonitorDBProperties;
import org.metahut.octopus.monitordb.api.entity.MetricsResult;
import org.metahut.octopus.monitordb.api.entity.MetricsResultRequest;
import org.metahut.octopus.monitordb.api.entity.MonitorLog;
import org.metahut.octopus.monitordb.api.entity.MonitorLogRequest;

import com.google.common.base.CaseFormat;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ClickhouseMonitorDBSource implements IMonitorDBSource {

    private static final Logger logger = LoggerFactory.getLogger(ClickhouseMonitorDBSource.class);
    private final JDBCDataSourceProvider jdbcDataSource;

    public ClickhouseMonitorDBSource(MonitorDBProperties.Clickhouse properties) {
        jdbcDataSource = JDBCDataSourceProvider.getInstance(properties);
    }

    @Override
    public List<Map<String, Object>> customSQLQuery(String sql) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = jdbcDataSource.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            return resultSetToList(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        } finally {
            jdbcDataSource.close(connection, statement, resultSet);
        }
        return null;
    }

    private List<Map<String, Object>> resultSetToList(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        List<Map<String, Object>> resultList = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> map = new HashMap<>();
            for (int i = 1; i <= columnCount; i++) {
                recordMappingToMap(metaData.getColumnClassName(i), metaData.getColumnName(i), resultSet, map);
            }
            resultList.add(map);
        }
        return resultList;
    }

    private void recordMappingToMap(String fieldClassName, String fieldName, ResultSet rs, Map fieldValue)
        throws SQLException {
        if (fieldClassName.equals("java.lang.String")) {
            String s = rs.getString(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else if (fieldClassName.equals("java.lang.Integer")) {
            int s = rs.getInt(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else if (fieldClassName.equals("java.lang.Long")) {
            long s = rs.getLong(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else if (fieldClassName.equals("java.lang.Boolean")) {
            boolean s = rs.getBoolean(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else if (fieldClassName.equals("java.lang.Short")) {
            short s = rs.getShort(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else if (fieldClassName.equals("java.lang.Float")) {
            float s = rs.getFloat(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else if (fieldClassName.equals("java.lang.Double")) {
            double s = rs.getDouble(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else if (fieldClassName.equals("java.sql.Timestamp")) {
            java.sql.Timestamp s = rs.getTimestamp(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else if (fieldClassName.equals("java.sql.Date") || fieldClassName.equals("java.util.Date")) {
            java.util.Date s = rs.getDate(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else if (fieldClassName.equals("java.sql.Time")) {
            java.sql.Time s = rs.getTime(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else if (fieldClassName.equals("java.lang.Byte")) {
            byte s = rs.getByte(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, new Byte(s));
            }
        } else if (fieldClassName.equals("[B") || fieldClassName.equals("byte[]")) {
            // byte[]出现在SQL Server中
            byte[] s = rs.getBytes(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else if (fieldClassName.equals("java.math.BigDecimal")) {
            BigDecimal s = rs.getBigDecimal(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else if (fieldClassName.equals("java.lang.Object") || fieldClassName.equals("oracle.sql.STRUCT")) {
            Object s = rs.getObject(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else if (fieldClassName.equals("java.sql.Array") || fieldClassName.equals("oracle.sql.ARRAY")) {
            java.sql.Array s = rs.getArray(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else if (fieldClassName.equals("java.sql.Clob")) {
            java.sql.Clob s = rs.getClob(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else if (fieldClassName.equals("java.sql.Blob")) {
            java.sql.Blob s = rs.getBlob(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else {
            Object s = rs.getObject(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        }
    }

    private <T> List<T> listToBeans(List<Map<String, Object>> list, Class<T> beanClass) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        try {
            List<T> beanList = new ArrayList<>();
            for (Map<String, Object> map : list) {
                T object = (T) beanClass.newInstance();
                Map<String, Field> fieldMap = Arrays.stream(beanClass.getDeclaredFields()).collect(Collectors.toMap(Field::getName, Function.identity()));
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    String fieldName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, entry.getKey());
                    Field field = fieldMap.get(fieldName);
                    if (field == null) {
                        continue;
                    }
                    Method setField = beanClass.getMethod("set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1),
                        entry.getValue().getClass());
                    setField.invoke(object, entry.getValue());
                }
                beanList.add(object);
            }
            return beanList;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<MetricsResult> queryMetricsResults(MetricsResultRequest request) {
        StringBuilder sql = new StringBuilder("select * ");
        sql.append("from tb_octopus_metrics_result ");
        if (request != null) {
            sql.append("where 1=1 ");
            //TODO
        }
        List<Map<String, Object>> maps = customSQLQuery(sql.toString());
        return listToBeans(maps, MetricsResult.class);
    }

    @Override
    public List<MonitorLog> queryMonitorLogs(MonitorLogRequest request) {
        StringBuilder sql = new StringBuilder("select * ");
        sql.append("from tb_octopus_monitor_log ");
        if (request != null) {
            sql.append("where 1=1 ");
            if (CollectionUtils.isNotEmpty(request.getIds())) {
                sql.append("and id in (" + request.getIds().stream().map(String::valueOf).collect(Collectors.joining(",")) + ") ");
            }
            //TODO
        }
        List<Map<String, Object>> maps = customSQLQuery(sql.toString());
        return listToBeans(maps, MonitorLog.class);
    }

    @Override
    public void close() throws Exception {

    }
}
