package org.metahut.octopus.jobs.util;

import org.metahut.octopus.monitordb.api.IMonitorDBSource;
import org.metahut.octopus.monitordb.api.MetricsResult;
import org.metahut.octopus.monitordb.api.MetricsResultRequest;
import org.metahut.octopus.monitordb.api.PageResponse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MonitorDBPluginHelperTest {

    @Test
    public void getMonitorDBSourceTest() {

        IMonitorDBSource monitorDBSource = MonitorDBPluginHelper.getMonitorDBSource();

        MetricsResultRequest request = new MetricsResultRequest();
        request.setPageNo(1);
        request.setPageSize(10);
        PageResponse<MetricsResult> pageResponse = monitorDBSource.queryMetricsResultListPage(request);

        Assertions.assertNotNull(pageResponse);

    }

    @Test
    public void nativeConnectionTest() throws Exception {
        PreparedStatement preparedStatement = ClickhouseUtils.getConnection().prepareStatement("select * from monitor_metrics_result");

        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();

        Assertions.assertNotNull(resultSet);

    }
}
