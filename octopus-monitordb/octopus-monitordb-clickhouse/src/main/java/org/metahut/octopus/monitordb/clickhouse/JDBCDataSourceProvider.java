package org.metahut.octopus.monitordb.clickhouse;

import org.metahut.octopus.monitordb.api.MonitorDBProperties;

import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public Connection getConnection() throws SQLException {
        return datasource.getConnection();
    }

    private HikariDataSource initDataSource(MonitorDBProperties.Clickhouse properties) {
        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setJdbcUrl(properties.getJdbcUrl());
        dataSource.setUsername(properties.getUser());
        dataSource.setPassword(properties.getPassword());

        dataSource.setMinimumIdle(properties.getMinimumIdle());
        dataSource.setMaximumPoolSize(properties.getMaximumPoolSize());
        dataSource.setConnectionTestQuery(properties.getValidationQuery());

        return dataSource;
    }

    public void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        if (Objects.nonNull(resultSet)) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                logger.error(e.getMessage(), e);
            }
        }
        if (Objects.nonNull(preparedStatement)) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                logger.error(e.getMessage(), e);
            }
        }
        if (Objects.nonNull(connection)) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

}
