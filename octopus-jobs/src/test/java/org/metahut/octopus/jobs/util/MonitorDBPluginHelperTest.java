package org.metahut.octopus.jobs.util;

import org.metahut.octopus.monitordb.api.IMonitorDBSource;
import org.metahut.octopus.monitordb.api.MetricsResult;
import org.metahut.octopus.monitordb.api.MetricsResultRequest;
import org.metahut.octopus.monitordb.api.MonitorLog;
import org.metahut.octopus.monitordb.api.PageResponse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

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

    public static Stream<MetricsResult> generateMetricsResult() {
        MetricsResult metricsResult = new MetricsResult();
        metricsResult.setId(UUID.randomUUID().toString());
        metricsResult.setReportChannel("");
        metricsResult.setDatasetCode("01");
        metricsResult.setSubjectCode("12312312");
        metricsResult.setSubjectCategory("TABLE");
        metricsResult.setMetricsCode("delay");
        metricsResult.setMetricsUniqueKey("");
        metricsResult.setMetricsValue("123123123");
        metricsResult.setCreateTime(new Date());
        return Stream.of(metricsResult);
    }


    public static Stream<MonitorLog> generateMonitorLog() {
        MonitorLog monitorLog = new MonitorLog();
        monitorLog.setId(UUID.randomUUID().toString());
        monitorLog.setRuleInstanceCode(5779276730530L);
        monitorLog.setDatasetCode("");
        monitorLog.setMetricsCode("");
        monitorLog.setMetricsConfigCode("");
        monitorLog.setSubjectCode("12312312");
        monitorLog.setSubjectCategory("TABLE");
        monitorLog.setMetricsCode("delay");
        monitorLog.setCheckType("Num");
        monitorLog.setCheckMethod("FixedValue");
        monitorLog.setComparisonMethod("GT");
        monitorLog.setComparisonUnit("Num");
        monitorLog.setExpectedValue("[\"20\",\"30\"]");
        monitorLog.setResult("abcsdfasfd");
        monitorLog.setError(1);
        monitorLog.setErrorInfo("error info");
        monitorLog.setErrorTime(new Date());
        monitorLog.setCreateTime(new Date());
        return Stream.of(monitorLog);
    }

    @ParameterizedTest
    @MethodSource("generateMetricsResult")
    public void saveMonitorResultTest(MetricsResult metricsResult) {
        IMonitorDBSource monitorDBSource = MonitorDBPluginHelper.getMonitorDBSource();

        int affectedRecords = monitorDBSource.saveMetricsResult(metricsResult);
        Assertions.assertEquals(1, affectedRecords);
    }

    @ParameterizedTest
    @MethodSource("generateMonitorLog")
    public void saveMonitorResultTest(MonitorLog monitorLog) {
        IMonitorDBSource monitorDBSource = MonitorDBPluginHelper.getMonitorDBSource();

        int affectedRecords = monitorDBSource.saveMonitorLog(monitorLog);
        Assertions.assertEquals(1, affectedRecords);
    }
}
