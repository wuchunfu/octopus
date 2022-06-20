package org.metahut.octopus.jobs.job;

import org.metahut.octopus.common.enums.CheckMethodEnum;
import org.metahut.octopus.common.utils.JSONUtils;
import org.metahut.octopus.jobs.common.MetricMessage;
import org.metahut.octopus.jobs.common.MetricRule;
import org.metahut.octopus.jobs.util.HttpUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.flink.api.common.RuntimeExecutionMode;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MonitorRuleTaskTest {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Test
    public void buildSQLToQueryAverageValueTest() {
        String expectedSql = "select avg(toDecimal64(metrics_value,4)) as avg,count(1) as items "
            + "from monitor_metrics_result_all "
            + "where dataset_code = '35' and metrics_code = 'count' and window_begin_time>='2022-06-08 12:00:00' and window_begin_time<'2022-06-15 12:00:00' and toHour(window_begin_time) = '12' "
            + "and metrics_value is not null and metrics_value !='null' and metrics_value !='' "
            + "group by toHour(window_begin_time)";

        String beginTime = "2022-06-15 12:00:00";
        Integer days = 7;
        String datasetCode = "35";
        String metricsCode = "count";

        Date windowBeginTime = Date.from(LocalDateTime.from(dateTimeFormatter.parse(beginTime)).atZone(
            ZoneId.systemDefault()).toInstant());

        Integer windowSize = 1;
        String windowUnit = "hour";

        String sql = MonitorRuleTask.buildSQLToQueryAverageValue(
            days,
            datasetCode,
            metricsCode,
            windowBeginTime,
            windowSize,
            windowUnit
        );

        Assertions.assertEquals(expectedSql, sql);
    }

    @Test
    @Disabled
    public void queryAverageValueTest() {
        String beginTime = "2022-05-26 13:00:00";
        int days = 7;
        String datasetCode = "35";
        String metricsCode = "count";
        Integer windowSize = 1;
        String windowUnit = "hour";

        Date windowBeginTime = Date.from(LocalDateTime.from(dateTimeFormatter.parse(beginTime)).atZone(
            ZoneId.systemDefault()).toInstant());

        List<Map<String, Object>> metricsResults = MonitorRuleTask.queryAverageValue(days,
            datasetCode,
            metricsCode,
            windowBeginTime,
            windowSize,
            windowUnit);

        Assertions.assertNotNull(metricsResults);
    }

    public static Stream<List<String>> metricMessageProvider() {
        List<MetricMessage> metricMessages = JSONUtils.parseObject(MonitorRuleTaskTest.class.getClass().getResourceAsStream("/json/metrics.json"),
            new TypeReference<List<MetricMessage>>() {
            });

        return Stream.of(metricMessages.stream().map(metricMessage -> JSONUtils.toJSONString(metricMessage)).collect(
            Collectors.toList()));
    }

    @ParameterizedTest
    @MethodSource("metricMessageProvider")
    public void executeTaskTest(List<String> metricMessages) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setRuntimeMode(RuntimeExecutionMode.STREAMING);
        DataStream<String> dataStream = env.fromCollection(metricMessages).name("input-source");

        MonitorRuleTask.executeTask(env, dataStream);
    }

    @Test
    @Disabled
    public void batchSendWithDetailsTest() {
        String url = "http://localhost:8989/alertSender/batchSendWithDetails";
        MetricRule metricRule = new MetricRule();
        metricRule.setRuleInstanceCode(5779276730530L);
        metricRule.setWindowBeginTime(new Date());
        metricRule.setWindowSize(1);
        metricRule.setWindowUnit("DAY");
        metricRule.setScheduleTime(new Date());
        metricRule.setDatasourceName("IDC-DW");
        metricRule.setDatasourceCode("01");
        metricRule.setDatasetCode("01");
        metricRule.setDatasetName("clickstream");
        metricRule.setMetricsCode("delay");
        metricRule.setMetricsName("延迟时间指标");
        metricRule.setCheckType("Number");
        metricRule.setCheckMethod(CheckMethodEnum.FIXED_VALUE.toString());
        metricRule.setComparisonMethod("GT");
        metricRule.setComparisonUnit("Num");
        metricRule.setActualValue("25");
        metricRule.setExpectedValue("[\"20\"]");
        metricRule.setMetricsValue("25");
        metricRule.setMessage("error info");
        metricRule.setCheckStatus(1);
        metricRule.setCheckTime(new Date());
        String requestBody = JSONUtils.toJSONString(metricRule);

        HttpUtils.post(url, requestBody);
    }
}
