package org.metahut.octopus.monitordb.clickhouse;

import org.metahut.octopus.monitordb.api.MonitorDBProperties;

import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

import java.util.Objects;

public class JDBCDataSourceProvider {

    private static final Logger logger = LoggerFactory.getLogger(JDBCDataSourceProvider.class);

    private static volatile JDBCDataSourceProvider singleton = null;

    private static DataSource datasource;
    private JDBCDataSourceProvider(MonitorDBProperties.Clickhouse properties) {
        datasource = initDataSource(properties);
    }

    public static JDBCDataSourceProvider getInstance(MonitorDBProperties.Clickhouse properties) {
        if (singleton == null) {
            synchronized (JDBCDataSourceProvider.class) {
                if (singleton == null) {
                    singleton = new JDBCDataSourceProvider(properties);
                }
            }
        }
        return singleton;
    }

    public DataSource getDatasource() {
        return datasource;
    }

    private HikariDataSource initDataSource(MonitorDBProperties.Clickhouse properties) {
        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setJdbcUrl(properties.getJdbcUrl());
        dataSource.setUsername(properties.getUser());
        dataSource.setPassword(properties.getPassword());

        dataSource.setMinimumIdle(Objects.nonNull(properties.getMinimumIdle()) ? properties.getMinimumIdle() : 5);
        dataSource.setMaximumPoolSize(Objects.nonNull(properties.getMaximumPoolSize()) ? properties.getMaximumPoolSize() : 50);
        dataSource.setConnectionTestQuery(properties.getValidationQuery());

        return dataSource;
    }

}
