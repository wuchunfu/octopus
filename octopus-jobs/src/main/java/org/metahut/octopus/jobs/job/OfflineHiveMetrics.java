package org.metahut.octopus.jobs.job;

import org.metahut.octopus.jobs.common.DateTimeFieldConfig;
import org.metahut.octopus.jobs.common.MetaDatasetResponseDTO;
import org.metahut.octopus.jobs.common.MetaSchemaSingleResponseDTO;
import org.metahut.octopus.jobs.common.MetricInfo;
import org.metahut.octopus.jobs.common.MetricMessage;
import org.metahut.octopus.jobs.common.MetricResult;
import org.metahut.octopus.jobs.common.MonitorConfig;
import org.metahut.octopus.jobs.common.MonitorFlowDefinitionResponseDTO;
import org.metahut.octopus.jobs.common.RuleInstance;
import org.metahut.octopus.jobs.common.RuleInstanceResponseDTO;
import org.metahut.octopus.jobs.common.SampleInstanceResponseDTO;
import org.metahut.octopus.jobs.enums.WindowUnit;
import org.metahut.octopus.jobs.util.HttpUtils;
import org.metahut.octopus.jobs.util.MonitorDBPluginHelper;
import org.metahut.octopus.monitordb.api.IMonitorDBSource;
import org.metahut.octopus.monitordb.api.MetricsResult;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.connector.pulsar.sink.PulsarSink;
import org.apache.flink.connector.pulsar.sink.writer.serializer.PulsarSerializationSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.table.catalog.hive.HiveCatalog;
import org.apache.flink.table.module.hive.HiveModule;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class OfflineHiveMetrics {
    private static StreamTableEnvironment tableEnvironment;

    private static volatile Map<String, String> metaSchemasMap = new ConcurrentHashMap<>();
    private static volatile Map<MetricInfo, List<RuleInstance>> ruleInstancesMap = new ConcurrentHashMap<>();
    private static volatile String tableName = null;
    private static volatile String database = null;
    private static volatile String fullTableName = null;
    private static volatile Date scheduleTime = null;  //new Date()
    private static volatile String flowCode = null;
    private static final IMonitorDBSource monitorDBSource = MonitorDBPluginHelper.getMonitorDBSource();
    private static final MonitorConfig monitorConfig = MonitorConfig.getMonitorConfig();
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {

        // --scheduleTime "2022-06-15 13:10:20"
        ParameterTool parameterTool = ParameterTool.fromArgs(args);
        Preconditions.checkArgument(parameterTool.has("scheduleTime") && parameterTool.has("flowCode"), "Missed the arguments of scheduleTime or flowCode.");

        String scheduleTimeStr = parameterTool.get("scheduleTime");

        //--flowCode 5856993537312
        flowCode = parameterTool.get("flowCode");

        String flowDefinitionServiceUrl = monitorConfig.getMonitorFlowDefinitionService();

        if (flowDefinitionServiceUrl.endsWith("/")) {
            flowDefinitionServiceUrl = String.format("%s%s", flowDefinitionServiceUrl, flowCode);
        } else {
            flowDefinitionServiceUrl = String.format("%s/%s", flowDefinitionServiceUrl, flowCode);
        }

        String flowResponse = HttpUtils.get(flowDefinitionServiceUrl);
        JSONObject flowResponseJson = JSONObject.parseObject(flowResponse);
        if (flowResponseJson.getInteger("code") != 200) {
            throw new RuntimeException("the interface responses error: \n" + flowResponse);
        }
        String flowResponseData = flowResponseJson.getString("data");
        MonitorFlowDefinitionResponseDTO flowInstance = objectMapper.readValue(flowResponseData, MonitorFlowDefinitionResponseDTO.class);

        EnvironmentSettings settings = EnvironmentSettings.newInstance()
                .inBatchMode()
                .build();
        // tableEnvironment = TableEnvironment.create(settings);

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        //sink
        PulsarSink<String> sink = PulsarSink.builder()
                .setServiceUrl(monitorConfig.getMessageQueue().getPulsar().getServiceUrl())
                .setAdminUrl(monitorConfig.getMessageQueue().getPulsar().getAdminUrl())
                .setTopics(monitorConfig.getMessageQueue().getPulsar().getTopic())
                .setSerializationSchema(PulsarSerializationSchema.flinkSchema(new SimpleStringSchema()))
                //  .setDeliverGuarantee(DeliveryGuarantee.AT_LEAST_ONCE)
                .build();

        executeTask(scheduleTimeStr, flowInstance, env, settings, sink);
    }

    //register udf
    /*private static void registerUdf(String funcName, String classPath) throws Exception {
        Class<?> udfClass = Thread.currentThread().getContextClassLoader().loadClass(classPath);
        UserDefinedFunction udfFunc = udfClass.asSubclass(UserDefinedFunction.class).newInstance();

        tableEnvironment.createTemporarySystemFunction(funcName, udfFunc);
    }*/

    public static String getTimeConditions(String type, String dateTimeField, String beginTime, String endTime) {
        String timeConditionsPre = null;
        if (type.equals("string")) {
            timeConditionsPre = " ${dateTimeField} >= '${beginTime}' and ${dateTimeField}< '${endTime}'";
        } else if (type.equals("int")) {
            timeConditionsPre = " ${dateTimeField} >= ${beginTime} and ${dateTimeField}< ${endTime}";
        }

        String timeConditions = timeConditionsPre.replaceAll("\\$\\{dateTimeField\\}",dateTimeField)
                .replaceAll("\\$\\{beginTime\\}",beginTime)
                .replaceAll("\\$\\{endTime\\}",endTime);

        return timeConditions;
    }

    public static void executeTask(String schduleTimeStr, MonitorFlowDefinitionResponseDTO flowInstance, StreamExecutionEnvironment env, EnvironmentSettings settings, PulsarSink<String> sink)
            throws Exception {
        scheduleTime = Date.from(LocalDateTime.from(dateTimeFormatter.parse(schduleTimeStr)).atZone(
                ZoneId.systemDefault()).toInstant());

        tableEnvironment = StreamTableEnvironment.create(env, settings);
        Configuration configuration = tableEnvironment.getConfig().getConfiguration();
        configuration.setString("table.exec.spill-compression.block-size", "262144 kb");
        configuration.setString("table.optimizer.join-reorder-enabled", "true");
        configuration.setString("table.optimizer.join.broadcast-threshold", "10485760");
        configuration.setString("table.optimizer.agg-phase-strategy", "TWO_PHASE"); // enable two-phase, i.e. local-global aggregation

        // register catalog
        HiveCatalog hiveCatalog = new HiveCatalog("myhive", "default", monitorConfig.getHiveConfig().getHiveConfDir(), monitorConfig.getHiveConfig().getVersion());
        // HiveCatalog hiveCatalog = new HiveCatalog("myhive", "dmm", "/data/online/octopus-jobs/flink/conf", "3.1.0");
        tableEnvironment.registerCatalog("myhive", hiveCatalog);
        tableEnvironment.loadModule("myhive", new HiveModule(monitorConfig.getHiveConfig().getVersion()));

        //register udf
        //registerUdf("insert_metrics_clickhouse", "org.metahut.octopus.jobs.udf.InsertMetricsToClickhouse");

        //get window info
        int windowSize = Integer.valueOf(flowInstance.getWindowSize());
        WindowUnit windowUnit = flowInstance.getWindowUnit();
        Date windowBeginTime = null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(scheduleTime);
        String timeConditions = "";
        String conditions = null;
        switch (windowUnit) {
            case DAY:
                cal.add(Calendar.DAY_OF_MONTH, -windowSize);
                windowBeginTime = cal.getTime();
                String dateTimeField = flowInstance.getDateTimeFields().get(0).getName();
                String dateTimeFormat = flowInstance.getDateTimeFields().get(0).getFormat();
                SimpleDateFormat simpleDayFormat = new SimpleDateFormat(dateTimeFormat);
                String dayBeginTime = simpleDayFormat.format(windowBeginTime);
                String dayEndTime = simpleDayFormat.format(scheduleTime);
                String dayType = flowInstance.getDateTimeFields().get(0).getType();
                timeConditions = getTimeConditions(dayType, dateTimeField, dayBeginTime, dayEndTime);

                conditions = "where " + timeConditions;
                break;
            case HOUR:
                cal.add(Calendar.HOUR_OF_DAY, -windowSize);
                windowBeginTime = cal.getTime();
                String filterCondition = "";
                List<DateTimeFieldConfig> dateTimeFields = flowInstance.getDateTimeFields();
                for (DateTimeFieldConfig timeField : dateTimeFields) {
                    if (timeField.getFormat().equals("HH") || timeField.getFormat().equals("hh")) {
                        String hourtype = timeField.getType();
                        String hourTimeField = timeField.getName();
                        //"hour" is the flink key word
                        if (hourTimeField.equals("hour")) {
                            hourTimeField = "`hour`";
                        }
                        String hourTimeFormat = timeField.getFormat();
                        SimpleDateFormat simplehourFormat = new SimpleDateFormat(hourTimeFormat);
                        String beginTime = simplehourFormat.format(windowBeginTime);
                        String endTime = simplehourFormat.format(scheduleTime);
                        timeConditions = getTimeConditions(hourtype, hourTimeField, beginTime, endTime);
                    } else {
                        String filterFiledType = timeField.getType();
                        String filterFiledFormat = timeField.getFormat();
                        String fiterFiledName = timeField.getName();

                        String filterTime = new SimpleDateFormat(filterFiledFormat).format(scheduleTime);
                        if (filterFiledType.equals("string")) {
                            filterCondition = fiterFiledName + "='" + filterTime + "'";
                        } else if (filterFiledType.equals("int")) {
                            filterCondition = fiterFiledName + "=" + filterTime;
                        }
                    }

                }
                conditions = "where " + filterCondition + " and " + timeConditions;
                break;
            case MINUTE:
                cal.add(Calendar.MINUTE, -windowSize);
                windowBeginTime = cal.getTime();
                break;
            default:
                throw new Exception(
                        "Unsupported windowUnit.");
        }

        //get meta info
        MetaDatasetResponseDTO meta = flowInstance.getMeta();
        tableName = meta.getName();
        database = meta.getDatabase().getName();
        fullTableName = database + "." + tableName;
        String datasourceCode = meta.getDatasource().getCode();
        String datasourceName = meta.getDatasource().getName();
        String datasetCode = meta.getCode();
        String datasetName = meta.getName();
        Collection<MetaSchemaSingleResponseDTO> schemas = meta.getSchemas();
        for (MetaSchemaSingleResponseDTO schema : schemas) {
            metaSchemasMap.put(schema.getCode(), schema.getName());
        }

        //sample data : FLink only support random sample
        //String viewSamplesPre = "select * from myhive.{0} TABLESAMPLE ({1} PERCENT)";
        //select * from default.test_obs_octopus_jobs where dt >= '20220610' and dt < '20220615' and rand() <= 0.1;
        String viewSamplesPre = "select * from myhive.{0} {1} and rand() <= {2}";
        String viewSamples = null;
        //get sampleInstance info
        SampleInstanceResponseDTO sampleInstance = flowInstance.getSampleInstance();
        if (sampleInstance != null && StringUtils.isNotBlank(sampleInstance.getParameter())) {
            String parameter = sampleInstance.getRuntimeParameter();
            JSONObject parameterJson = JSONObject.parseObject(parameter);
            if (parameterJson.containsKey("number") && Objects.nonNull(parameterJson.getInteger("number"))) {
                int number = parameterJson.getInteger("number");
                viewSamples = MessageFormat.format(viewSamplesPre, fullTableName, conditions, (float)number / 100);
            }
        }

        //get ruleInstances info
        List<RuleInstanceResponseDTO> ruleInstancesList = flowInstance.getRuleInstances();
        for (RuleInstanceResponseDTO ruleInstanceResponseDTO : ruleInstancesList) {
            MetricInfo metricInfo = new MetricInfo();
            metricInfo.setId(UUID.randomUUID().toString());
            metricInfo.setReportChannel("");
            metricInfo.setDatasourceCode(datasourceCode);
            metricInfo.setDatasourceName(datasourceName);
            metricInfo.setDatasetCode(datasetCode);
            metricInfo.setDatasetName(datasetName);
            metricInfo.setSubjectCode(ruleInstanceResponseDTO.getSubjectCode());
            metricInfo.setSubjectCategory(ruleInstanceResponseDTO.getSubjectCategory().toString());
            metricInfo.setMetricsCode(ruleInstanceResponseDTO.getMetrics().getCode());
            metricInfo.setMetricsName(ruleInstanceResponseDTO.getMetrics().getName());
            metricInfo.setMetricsConfigCode(ruleInstanceResponseDTO.getMetricsConfig().getCode());
            metricInfo.setMetricsUniqueKey(ruleInstanceResponseDTO.getMetricsUniqueKey());
            metricInfo.setExecutorScript(ruleInstanceResponseDTO.getMetricsConfig().getExecutorScript() + " " + conditions);
            metricInfo.setWindowBeginTime(windowBeginTime);
            metricInfo.setWindowSize(windowSize);
            metricInfo.setWindowUnit(windowUnit.toString());
            metricInfo.setScheduleTime(scheduleTime);
            SampleInstanceResponseDTO metricSampleInstance = ruleInstanceResponseDTO.getSampleInstance();
            if (Objects.nonNull(metricSampleInstance) && StringUtils.isNotBlank(metricSampleInstance.getParameter())) {
                metricInfo.setSampleFlag(true);
            } else {
                metricInfo.setSampleFlag(false);
            }
            RuleInstance ruleInstance = new RuleInstance();
            ruleInstance.setRuleInstanceCode(ruleInstanceResponseDTO.getCode());
            ruleInstance.setCheckType(ruleInstanceResponseDTO.getCheckType());
            ruleInstance.setCheckMethod(ruleInstanceResponseDTO.getCheckMethod());
            ruleInstance.setComparisonUnit(ruleInstanceResponseDTO.getComparisonUnit());
            ruleInstance.setComparisonMethod(ruleInstanceResponseDTO.getComparisonMethod());
            ruleInstance.setExpectedValue(ruleInstanceResponseDTO.getExpectedValue());

            List<RuleInstance> ruleInstanceList = ruleInstancesMap.get(metricInfo);
            if (ruleInstanceList == null) {
                ArrayList<RuleInstance> ruleInstances = new ArrayList<>();
                ruleInstances.add(ruleInstance);
                ruleInstancesMap.put(metricInfo, ruleInstances);
            } else {
                ruleInstanceList.add(ruleInstance);
                ruleInstancesMap.put(metricInfo, ruleInstanceList);
            }

        }

        //sample data
        if (viewSamples != null) {
            tableEnvironment.createTemporaryView("view_samples", tableEnvironment.sqlQuery(viewSamples));
        }

        // get metric info list and compute
        for (Map.Entry<MetricInfo, List<RuleInstance>> entry : ruleInstancesMap.entrySet()) {
            List<RuleInstance> ruleInstanceList = entry.getValue();
            MetricInfo metricInfo = entry.getKey();
            String subjectCategory = metricInfo.getSubjectCategory().toString();
            String subjectCode = metricInfo.getSubjectCode();
            String metricSqlPre = metricInfo.getExecutorScript();
            String metricSql = null;
            if (subjectCategory.equals("TABLE")) {
                if (metricInfo.getSampleFlag().equals(Boolean.TRUE)) {
                    metricSql = metricSqlPre.replaceAll("\\$\\{table\\}","view_samples");
                } else {
                    metricSql = metricSqlPre.replaceAll("\\$\\{table\\}","myhive." + fullTableName);
                }
            } else {
                if (metricInfo.getSampleFlag().equals(Boolean.TRUE)) {
                    String metricSqlPreTwo = metricSqlPre.replaceAll("\\$\\{table\\}","view_samples");
                    metricSql = metricSqlPreTwo.replaceAll("\\$\\{field\\}",metaSchemasMap.get(subjectCode));
                } else {
                    String metricSqlPreTwo = metricSqlPre.replaceAll("\\$\\{table\\}","myhive." + fullTableName);
                    metricSql = metricSqlPreTwo.replaceAll("\\$\\{field\\}",metaSchemasMap.get(subjectCode));
                }
            }

            Table table = tableEnvironment.sqlQuery(metricSql);
            DataStream<MetricResult> metricResultDataStream = tableEnvironment.toDataStream(table, MetricResult.class);
            SingleOutputStreamOperator<String> metricStringDataStream = metricResultDataStream
                    //insert into clickhouse
                    .map(data -> {
                        MetricsResult metricsResult = new MetricsResult();
                        metricsResult.setId(metricInfo.getId());
                        metricsResult.setWindowBeginTime(metricInfo.getWindowBeginTime());
                        metricsResult.setWindowSize(metricInfo.getWindowSize());
                        metricsResult.setWindowUnit(metricInfo.getWindowUnit());
                        metricsResult.setScheduleTime(scheduleTime);
                        metricsResult.setReportChannel(metricInfo.getReportChannel());
                        metricsResult.setDatasetCode(metricInfo.getDatasetCode());
                        metricsResult.setSubjectCode(metricInfo.getSubjectCode());
                        metricsResult.setSubjectCategory(metricInfo.getSubjectCategory().toString());
                        metricsResult.setMetricsCode(metricInfo.getMetricsCode());
                        metricsResult.setMetricsUniqueKey(metricInfo.getMetricsUniqueKey());
                        if (data.getMetricsValue() == null && metricInfo.getMetricsCode().equals("null_rate")) {
                            metricsResult.setMetricsValue("1");
                        } else {
                            metricsResult.setMetricsValue(data.getMetricsValue());
                        }
                        metricsResult.setCreateTime(new Date());
                        monitorDBSource.saveMetricsResult(metricsResult);
                        return data;
                    })
                    //send to pulsar
                    .map(data -> {
                        MetricMessage metricMessage = new MetricMessage();
                        metricMessage.setId(metricInfo.getId());
                        metricMessage.setReportChannel(metricInfo.getReportChannel());
                        metricMessage.setDatasourceCode(metricInfo.getDatasourceCode());
                        metricMessage.setDatasourceName(metricInfo.getDatasourceName());
                        metricMessage.setDatasetCode(metricInfo.getDatasetCode());
                        metricMessage.setDatasetName(metricInfo.getDatasetName());
                        metricMessage.setSubjectCode(metricInfo.getSubjectCode());
                        metricMessage.setSubjectCategory(metricInfo.getSubjectCategory().toString());
                        metricMessage.setMetricsCode(metricInfo.getMetricsCode());
                        metricMessage.setMetricsName(metricInfo.getMetricsName());
                        metricMessage.setMetricsConfigCode(metricInfo.getMetricsConfigCode());
                        metricMessage.setMetricsUniqueKey(metricInfo.getMetricsUniqueKey());
                        if (data.getMetricsValue() == null && metricInfo.getMetricsCode().equals("null_rate")) {
                            metricMessage.setMetricsValue("1");
                        } else {
                            metricMessage.setMetricsValue(data.getMetricsValue());
                        }
                        metricMessage.setWindowBeginTime(metricInfo.getWindowBeginTime());
                        metricMessage.setWindowSize(metricInfo.getWindowSize());
                        metricMessage.setWindowUnit(metricInfo.getWindowUnit());
                        metricMessage.setScheduleTime(metricInfo.getScheduleTime());
                        metricMessage.setSendDate(new Date());
                        metricMessage.setRuleInstances(ruleInstanceList);

                        return objectMapper.writeValueAsString(metricMessage);
                    });
            metricStringDataStream.sinkTo(sink);
        }

        env.execute("OfflineHiveMetrics");

        //Thread.sleep(1000000000);

    }
}
