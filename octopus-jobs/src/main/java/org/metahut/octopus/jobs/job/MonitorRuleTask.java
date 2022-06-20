package org.metahut.octopus.jobs.job;

import org.metahut.octopus.common.enums.CheckMethodEnum;
import org.metahut.octopus.jobs.common.JSONUtils;
import org.metahut.octopus.jobs.common.MetricMessage;
import org.metahut.octopus.jobs.common.MetricRule;
import org.metahut.octopus.jobs.common.MonitorConfig;
import org.metahut.octopus.jobs.util.HttpUtils;
import org.metahut.octopus.jobs.util.MonitorDBPluginHelper;
import org.metahut.octopus.monitordb.api.IMonitorDBSource;
import org.metahut.octopus.monitordb.api.MonitorLog;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.flink.api.common.RuntimeExecutionMode;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.connector.pulsar.source.PulsarSource;
import org.apache.flink.connector.pulsar.source.enumerator.cursor.StartCursor;
import org.apache.flink.connector.pulsar.source.reader.deserializer.PulsarDeserializationSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;
import org.apache.pulsar.client.api.SubscriptionType;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

public class MonitorRuleTask {

    private static final String monitorMetricsResultTable = "monitor_metrics_result_all";
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final MonitorConfig monitorConfig = MonitorConfig.getMonitorConfig();

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setRuntimeMode(RuntimeExecutionMode.STREAMING);

        PulsarSource<String> pulsarSource = PulsarSource.builder()
            .setServiceUrl(monitorConfig.getMessageQueue().getPulsar().getServiceUrl())
            .setAdminUrl(monitorConfig.getMessageQueue().getPulsar().getAdminUrl())
            .setStartCursor(StartCursor.earliest())
            .setTopics(monitorConfig.getMessageQueue().getPulsar().getTopic())
            .setDeserializationSchema(PulsarDeserializationSchema.flinkSchema(new SimpleStringSchema()))
            .setSubscriptionName(monitorConfig.getMessageQueue().getPulsar().getSubscriptionName())
            .setSubscriptionType(SubscriptionType.Key_Shared)
            .build();

        DataStream<String> dataStream = env.fromSource(pulsarSource, WatermarkStrategy.noWatermarks(), "quality-metrics-source", TypeInformation.of(String.class));
        executeTask(env, dataStream);
    }

    public static void executeTask(StreamExecutionEnvironment env, DataStream<String> sourceDataStream)
        throws Exception {
        sourceDataStream.flatMap(new EvaluateMonitorRuleFlatMapFunction(), TypeInformation.of(new TypeHint<Tuple2<MetricRule, Integer>>() {}));
        sourceDataStream.print().name("print-sink");

        env.execute(monitorConfig.getMonitorRuleTask().getJobName());
    }

    public static final class EvaluateMonitorRuleMapFunction implements MapFunction<String, String> {

        @Override
        public String map(String s) throws Exception {
            MetricMessage metricMessage = JSONUtils.parseObject(s, MetricMessage.class);
            if (Objects.nonNull(metricMessage)) {
                evaluateMonitorRule(metricMessage);
            }
            return "";
        }
    }

    public static final class EvaluateMonitorRuleFlatMapFunction implements
        FlatMapFunction<String, Tuple2<MetricRule, Integer>> {

        @Override
        public void flatMap(String value, Collector<Tuple2<MetricRule, Integer>> out) throws Exception {
            MetricMessage metricMessage = JSONUtils.parseObject(value, MetricMessage.class);
            if (Objects.nonNull(metricMessage)) {
                evaluateMonitorRule(metricMessage).stream().forEach(monitorLog -> {
                    out.collect(Tuple2.of(monitorLog, 1));
                });
            }
        }
    }

    public static List<MetricRule> evaluateMonitorRule(MetricMessage metricMessage) {
        return metricMessage.getRuleInstances().stream()
            .map(ruleInstance -> {
                MetricRule metricRule = new MetricRule();
                metricRule.setWindowBeginTime(metricMessage.getWindowBeginTime());
                metricRule.setWindowSize(metricMessage.getWindowSize());
                metricRule.setWindowUnit(metricMessage.getWindowUnit());
                metricRule.setScheduleTime(metricMessage.getScheduleTime());
                metricRule.setMetricsCode(metricMessage.getMetricsCode());
                metricRule.setMetricsName(metricMessage.getMetricsName());
                metricRule.setDatasetCode(metricMessage.getDatasetCode());
                metricRule.setDatasetName(metricMessage.getDatasetName());
                metricRule.setDatasourceCode(metricMessage.getDatasourceCode());
                metricRule.setDatasourceName(metricMessage.getDatasourceName());
                metricRule.setSubjectCategory(metricMessage.getSubjectCategory());
                metricRule.setSubjectCode(metricMessage.getSubjectCode());
                metricRule.setMetricsValue(metricMessage.getMetricsValue());
                metricRule.setRuleInstanceCode(ruleInstance.getRuleInstanceCode());
                metricRule.setComparisonUnit(ruleInstance.getComparisonUnit());
                metricRule.setComparisonMethod(ruleInstance.getComparisonMethod());
                metricRule.setCheckType(ruleInstance.getCheckType());
                metricRule.setCheckMethod(ruleInstance.getCheckMethod());
                metricRule.setCheckStatus(0);
                metricRule.setCheckTime(new Date());
                metricRule.setExpectedValue(JSONUtils.toJSONString(ruleInstance.getExpectedValue()));
                return metricRule;
            })
            .map(metricRule -> {
                // To save the monitor log into the backend storage.
                try {
                    MonitorLog monitorLog = executeMonitorRule(metricRule);
                    IMonitorDBSource monitorDBSource = MonitorDBPluginHelper.getMonitorDBSource();
                    int affectedRecords = monitorDBSource.saveMonitorLog(monitorLog);
                    metricRule.setActualValue(monitorLog.getResult());
                    metricRule.setCheckStatus(monitorLog.getError());
                    metricRule.setMessage(monitorLog.getErrorInfo());
                    if (metricRule.getCheckStatus() != 0) {
                        callAlertService(metricRule);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return metricRule;
            })
            .filter(metricRule -> metricRule.getCheckStatus() != 0)
            .collect(Collectors.toList());
    }

    public static MonitorLog executeMonitorRule(MetricRule metricRule)
        throws InvocationTargetException, IllegalAccessException {
        List<String> expectedValues = JSONUtils.parseObject(metricRule.getExpectedValue(), ArrayList.class);
        MonitorLog monitorLog = new MonitorLog();

        BeanUtils.copyProperties(monitorLog, metricRule);
        monitorLog.setId(UUID.randomUUID().toString());
        monitorLog.setCreateTime(new Date());

        if (CollectionUtils.isEmpty(expectedValues)) {
            monitorLog.setError(1);
            monitorLog.setErrorInfo("No any expected values.");
            monitorLog.setErrorTime(new Date());
            return monitorLog;
        }

        if (StringUtils.isBlank(monitorLog.getComparisonMethod())) {
            monitorLog.setError(1);
            monitorLog.setErrorInfo("The value of comparison method is invalid.");
            monitorLog.setErrorTime(new Date());
            return monitorLog;
        }

        String comparisonMethod = monitorLog.getComparisonMethod().toLowerCase();

        if (monitorLog.getCheckType().equalsIgnoreCase("Number")
            && CheckMethodEnum.FIXED_VALUE.toString().equals(monitorLog.getCheckMethod())) {
            Double actualValue = NumberUtils.toDouble(monitorLog.getMetricsValue());

            return compare(monitorLog, comparisonMethod, actualValue, expectedValues);

        } else if (monitorLog.getCheckType().equalsIgnoreCase("Fluctuation")) {
            Double partialActualValue = NumberUtils.toDouble(monitorLog.getMetricsValue());
            int days = 7;
            if (CheckMethodEnum.SEVEN_DAY_AVERAGE.toString().equals(monitorLog.getCheckMethod())) {
                days = 7;
            } else if (CheckMethodEnum.FOURTEEN_DAY_AVERAGE.toString().equals(monitorLog.getCheckMethod())) {
                days = 14;
            } else if (CheckMethodEnum.TWENTY_ONE_DAY_AVERAGE.toString().equals(monitorLog.getCheckMethod())) {
                days = 21;
            } else if (CheckMethodEnum.THIRTY_DAY_AVERAGE.toString().equals(monitorLog.getCheckMethod())) {
                days = 30;
            }
            List<Map<String, Object>> metricsResults = queryAverageValue(days,
                monitorLog.getDatasetCode(),
                monitorLog.getMetricsCode(),
                monitorLog.getWindowBeginTime(),
                monitorLog.getWindowSize(),
                monitorLog.getWindowUnit());

            if (metricsResults.isEmpty()) {
                monitorLog.setError(1);
                monitorLog.setErrorInfo(String.format("Not found any historical metrics before %d days.", days));
                monitorLog.setErrorTime(new Date());
                return monitorLog;
            } else {
                Double averageValue = ((BigDecimal)metricsResults.get(0).get("avg")).doubleValue();
                Double items = ((BigInteger)metricsResults.get(0).get("items")).doubleValue();
                // TODO: adjust the error to checkStatus, errorInfo to MessageInfo, errorTime to checkTime
                // if (items < days) {
                //     monitorLog.setError(1);
                //     monitorLog.setErrorInfo(String.format("Just found %d records, missed %d records.", items, days - items));
                //     monitorLog.setErrorTime(new Date());
                // }

                if (Objects.isNull(averageValue) || Double.isNaN(averageValue) || averageValue.equals(0.0D)) {
                    monitorLog.setError(1);
                    monitorLog.setErrorInfo(String.format("The historical average value is invalid", days));
                    monitorLog.setErrorTime(new Date());
                    return monitorLog;
                } else {
                    Double changeRate = partialActualValue / averageValue - 1;
                    return compare(monitorLog, comparisonMethod, changeRate, expectedValues);
                }
            }
        }
        return monitorLog;
    }

    public static List<Map<String, Object>> queryAverageValue(int days, String  datasetCode, String metricsCode, Date windowBeginTime, Integer windowSize, String windowUnit) {
        String sql = "";
        sql = buildSQLToQueryAverageValue(days,
            datasetCode,
            metricsCode,
            windowBeginTime,
            windowSize,
            windowUnit);
        IMonitorDBSource monitorDBSource = MonitorDBPluginHelper.getMonitorDBSource();
        return monitorDBSource.customSQLQuery(sql);
    }

    public static MonitorLog compare(MonitorLog monitorLog, String comparisonMethod, Double actualValue, List<String> expectedValues) {
        Double expectedValue = NumberUtils.toDouble(expectedValues.get(0));
        monitorLog.setResult(actualValue.toString());
        if (comparisonMethod.equals("gt") && actualValue > expectedValue) {
            monitorLog.setError(1);
            monitorLog.setErrorInfo(String.format("The actual value %s is greater than the expected value %s.", actualValue, expectedValue));
            monitorLog.setErrorTime(new Date());
        }

        if (comparisonMethod.equals("gte") && actualValue <= expectedValue) {
            monitorLog.setError(1);
            monitorLog.setErrorInfo(String.format("The actual value %s is greater than or equal to the expected value %s.", actualValue, expectedValue));
            monitorLog.setErrorTime(new Date());
        }

        if (comparisonMethod.equals("lt") && actualValue < expectedValue) {
            monitorLog.setError(1);
            monitorLog.setErrorInfo(String.format("The actual value %s is less than the expected value %s.", actualValue, expectedValue));
            monitorLog.setErrorTime(new Date());
        }

        if (comparisonMethod.equals("lte") && actualValue < expectedValue) {
            monitorLog.setError(1);
            monitorLog.setErrorInfo(String.format("The actual value %s is less than or equal to the expected value %s.", actualValue, expectedValue));
            monitorLog.setErrorTime(new Date());
        }

        if (comparisonMethod.equals("eq") && actualValue.equals(expectedValue)) {
            monitorLog.setError(1);
            monitorLog.setErrorInfo(String.format("The actual value %s is equal to the expected value %s.", actualValue, expectedValue));
            monitorLog.setErrorTime(new Date());
        }

        if (comparisonMethod.equals("ne") && !actualValue.equals(expectedValue)) {
            monitorLog.setError(1);
            monitorLog.setErrorInfo(String.format("The actual value %s is not equal to the expected value %s.", actualValue, expectedValue));
            monitorLog.setErrorTime(new Date());
        }
        return monitorLog;
    }

    public static String buildSQLToQueryAverageValue(Integer days, String  datasetCode, String metricsCode, Date windowBeginTime, Integer windowSize, String windowUnit) {
        LocalDateTime endDateTime = LocalDateTime.ofInstant(windowBeginTime.toInstant(), ZoneId.systemDefault());
        LocalDateTime beginDateTime = endDateTime.minusDays(days);

        String dateFunctionName = "toHour";
        int dateTimePart = 0;
        if (windowUnit.equalsIgnoreCase("day")) {
            dateFunctionName = "toDate";
            dateTimePart = endDateTime.getDayOfMonth();
        } else if (windowUnit.equalsIgnoreCase("hour")) {
            dateFunctionName = "toHour";
            dateTimePart = endDateTime.getHour();
        } else if (windowUnit.equalsIgnoreCase("minute")) {
            dateFunctionName = "toMinute";
            dateTimePart = endDateTime.getMinute();
        }

        String sql = String.format("select avg(toDecimal64(metrics_value,4)) as avg,count(1) as items "
                + "from %s "
                + "where dataset_code = '%s' and metrics_code = '%s' and window_begin_time>='%s' and window_begin_time<'%s' and %s(window_begin_time) = '%d' "
                + "and metrics_value is not null and metrics_value !='null' and metrics_value !='' "
                + "group by %s(window_begin_time)",

            monitorMetricsResultTable,
            datasetCode,
            metricsCode,
            dateTimeFormatter.format(beginDateTime),
            dateTimeFormatter.format(endDateTime),
            dateFunctionName,
            dateTimePart,
            dateFunctionName,
            dateTimeFormatter.format(endDateTime)
        );
        return sql;
    }

    public static String callAlertService(MetricRule metricRule) {
        String requestBody = JSONUtils.toJSONString(metricRule);
        return HttpUtils.post(monitorConfig.getAlertService(), requestBody);
    }

}
