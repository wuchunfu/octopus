package org.metahut.octopus.jobs.util;

import ru.yandex.clickhouse.ClickHouseConnection;
import ru.yandex.clickhouse.ClickHouseDataSource;
import ru.yandex.clickhouse.settings.ClickHouseProperties;

import java.sql.PreparedStatement;

public class ClickhouseUtils {
    private static Object confLock = new Object();
    private static ClickHouseProperties properties;
    private static ClickHouseDataSource dataSource;
    private static ClickHouseConnection connection;

    static {
        properties = new ClickHouseProperties();
        properties.setUser(Constants.USER_NAME);
        properties.setPassword(Constants.PASSWORD);

        dataSource = new ClickHouseDataSource(Constants.CLICKHOUSE_URL, properties);

    }

    public static ClickHouseConnection getConnection() throws Exception {
        if (connection == null || connection.isClosed()) {
            synchronized (confLock) {
                connection = dataSource.getConnection();
            }
        }
        return connection;
    }

    public static void insert(String sql) throws Exception {
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.execute();
    }

}
