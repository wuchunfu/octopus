package org.metahut.octopus.scheduler.dolphinscheduler;

import org.metahut.octopus.scheduler.api.IScheduler;
import org.metahut.octopus.scheduler.api.SchedulerException;
import org.metahut.octopus.scheduler.api.SchedulerProperties;
import org.metahut.octopus.scheduler.api.SchedulerResult;
import org.metahut.octopus.scheduler.api.parameters.HttpTaskParameter;
import org.metahut.octopus.scheduler.api.parameters.ScheduleCronParameter;
import org.metahut.octopus.scheduler.api.parameters.ScheduleParameter;
import org.metahut.octopus.scheduler.api.parameters.TaskParameter;
import org.metahut.octopus.scheduler.dolphinscheduler.entity.ProcessDefinition;
import org.metahut.octopus.scheduler.dolphinscheduler.entity.Schedule;
import org.metahut.octopus.scheduler.dolphinscheduler.enums.ReleaseState;
import org.metahut.octopus.scheduler.dolphinscheduler.parameter.HttpParameter;
import org.metahut.octopus.scheduler.dolphinscheduler.parameter.HttpParametersType;
import org.metahut.octopus.scheduler.dolphinscheduler.parameter.HttpProperty;
import org.metahut.octopus.scheduler.dolphinscheduler.parameter.ProcessDAGLocationParameter;
import org.metahut.octopus.scheduler.dolphinscheduler.parameter.ProcessTaskRelationParameter;
import org.metahut.octopus.scheduler.dolphinscheduler.parameter.TaskDefinitionParameter;

import com.fasterxml.jackson.core.type.TypeReference;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DolphinScheduler implements IScheduler {

    private static final MediaType MEDIA_TYPE_JSON = MediaType.get("application/json; charset=utf-8");
    private static final String HEADER_TOKEN_NAME = "token";
    private static final int HTTP_SUCCESS = 0;

    private final OkHttpClient client;
    private final SchedulerProperties.DolphinScheduler properties;

    public DolphinScheduler(OkHttpClient client, SchedulerProperties.DolphinScheduler properties) {
        this.client = client;
        this.properties = properties;
    }

    // TODO  @Deprecated start
    static final HashMap<String, String> formTaskMap = new HashMap<>();
    static final HashMap<String, String> onLineMap = new HashMap<>();
    static HashMap<String, String> schedulerMap = new HashMap<>();
    static HashMap<String, String> putMap = new HashMap<>();
    static HashMap<String, String> putScheduleMap = new HashMap<>();

    static {
        formTaskMap.put("taskDefinitionJson", "[{\"code\":5028755940768,\"name\":\"test_http1\",\"version\":1,\"description\":"
            + "\"\",\"delayTime\":0,\"taskType\":\"HTTP\",\"taskParams\":{\"localParams\":[],\"httpParams\":[],\"url\":\"http:1\""
            + ",\"httpMethod\":\"GET\",\"httpCheckCondition\":\"STATUS_CODE_DEFAULT\",\"condition\":\"\",\"connectTimeout\":60000,"
            + "\"socketTimeout\":60000,\"dependence\":{},\"conditionResult\":{\"successNode\":[],\"failedNode\":[]},\"waitStartTimeout\":{},"
            + "\"switchResult\":{}},\"flag\":\"YES\",\"taskPriority\":\"MEDIUM\",\"workerGroup\":\"default\",\"failRetryTimes\":0,"
            + "\"failRetryInterval\":1,\"timeoutFlag\":\"CLOSE\",\"timeoutNotifyStrategy\":null,\"timeout\":0,\"environmentCode\":-1}]");
        formTaskMap
            .put("locations", "[{\"taskCode\":5028755940768,\"x\":115,\"y\":270.0000305175781}]");
        formTaskMap.put("name", "test_http2");
        formTaskMap.put("taskRelationJson",
            "[{\"name\":\"\",\"preTaskCode\":0,\"preTaskVersion\":0,\"postTaskCode\":5028755940768,\"postTaskVersion\":0,\"conditionType\":0,\"conditionParams\":{}}]");
        formTaskMap.put("tenantCode", "default");
        formTaskMap.put("description", "aa1");
        formTaskMap.put("globalParams", "[]");
        formTaskMap.put("timeout", "0");

        onLineMap.put("name", "aa2");
        onLineMap.put("releaseState", "ONLINE");

        schedulerMap.put("schedule",
            "{\"startTime\":\"2022-03-30 00:00:00\",\"endTime\":\"2122-03-30 00:00:00\",\"crontab\":\"0 0 * * * ? *\",\"timezoneId\":\"Asia/Shanghai\"}");

        putMap.put("name", "test_http3");
        putMap.put("locations",
            "[{\"taskCode\":5028755940768,\"x\":120,\"y\":270},{\"taskCode\":5028755940768,\"x\":120,\"y\":416.0000305175781}]");
        putMap.put("taskDefinitionJson",
            "[{\"code\":5028755940768,\"name\":\"test_http1\",\"version\":1,"
                + "\"description\":\"\",\"delayTime\":0,\"taskType\":\"HTTP\","
                + "\"taskParams\":{\"localParams\":[],\"httpParams\":[],\"url\""
                + ":\"http:1\",\"httpMethod\":\"GET\",\"httpCheckCondition\":"
                + "\"STATUS_CODE_DEFAULT\",\"condition\":\"\",\"connectTimeout\""
                + ":60000,\"socketTimeout\":60000,\"dependence\":{},"
                + "\"conditionResult\":{\"successNode\":[],\"failedNode\":[]},\"waitStartTimeout\":{},\"switchResult\":{}},"
                + "\"flag\":\"YES\",\"taskPriority\":\"MEDIUM\",\"workerGroup\":\"default\",\"failRetryTimes\":0,\"failRetryInterval\":1,"
                + "\"timeoutFlag\":\"CLOSE\",\"timeoutNotifyStrategy\":null,\"timeout\":0,\"environmentCode\":-1}]");
        putMap.put("taskRelationJson", "[{\"name\":\"\",\"preTaskCode\":0,\"preTaskVersion\":0,\"postTaskCode\":5028755940768,\"postTaskVersion\":1,\"conditionType\":0,\"conditionParams\":{}}]");
        putMap.put("tenantCode", "algdataonline");
        putMap.put("description", "aa1");

        putScheduleMap.put("environmentCode", "");
        putScheduleMap.put("failureStrategy", "CONTINUE");
        putScheduleMap.put("processInstancePriority", "MEDIUM");
        putScheduleMap.put("schedule",
            "{\"startTime\":\"2022-03-30 00:00:00\",\"endTime\":\"2122-03-30 00:00:00\",\"crontab\":\"0 0 * * * ? *\",\"timezoneId\":\"Asia/Shanghai\"}");
        putScheduleMap.put("warningType", "NONE");
        putScheduleMap.put("warningGroupId", "1");
        putScheduleMap.put("workerGroup", "default");

    }
    // TODO  @Deprecated end

    @Override
    public List<String> previewSchedule(ScheduleCronParameter scheduleCronParameter) {
        setScheduleCronDefaultValue(scheduleCronParameter);
        String url = MessageFormat.format("/projects/{0}/schedules/preview", properties.getProjectCode());
        FormBody body = new FormBody.Builder()
            .add("schedule", JSONUtils.toJSONString(scheduleCronParameter))
            .build();
        try {
            String resultJson = post(url, body);
            DolphinResult<List<String>> result = JSONUtils.parseObject(resultJson, new TypeReference<DolphinResult<List<String>>>() {
            });
            checkResult(result, "previewSchedule");
            return result.getData();
        } catch (IOException e) {
            throw new SchedulerException("dolphin scheduler call previewSchedule method exception", e);
        }
    }

    /**
     * set schedule cron default value
     *
     * @param scheduleCronParameter schedule cron parameter
     */
    private void setScheduleCronDefaultValue(ScheduleCronParameter scheduleCronParameter) {
        if (Objects.isNull(scheduleCronParameter.getStartTime())) {
            scheduleCronParameter.setStartTime(new Date());
        }
        if (Objects.isNull(scheduleCronParameter.getEndTime())) {
            // + 100 year
            scheduleCronParameter.setEndTime(Date.from(LocalDateTime.now().plusYears(100).atZone(ZoneId.systemDefault()).toInstant()));
        }

    }

    @Override
    public String createSchedule(ScheduleParameter scheduleParameter) {
        setScheduleCronDefaultValue(scheduleParameter.getScheduleCronParameter());
        String url = MessageFormat.format("/projects/{0}/schedules", properties.getProjectCode());
        FormBody body = new FormBody.Builder()
            .add("processDefinitionCode", scheduleParameter.getFlowCode())
            .add("schedule", JSONUtils.toJSONString(scheduleParameter.getScheduleCronParameter()))
            .build();
        try {
            // create schedule instance
            String resultJson = post(url, body);
            DolphinResult<Schedule> result = JSONUtils.parseObject(resultJson, new TypeReference<DolphinResult<Schedule>>() {
            });
            checkResult(result, "createSchedule");
            int scheduleId = result.getData().getId();

            // Update schedule status to online
            updateScheduleToOnline(scheduleId);
            return String.valueOf(scheduleId);
        } catch (IOException e) {
            throw new SchedulerException("dolphin scheduler call createSchedule method exception", e);
        }
    }

    @Override
    public void updateSchedule(ScheduleParameter scheduleParameter) {
        String url = MessageFormat.format("/projects/{0}/schedules/update/{1}", properties.getProjectCode(), scheduleParameter.getFlowCode());
        FormBody body = new FormBody.Builder()
            .add("schedule", JSONUtils.toJSONString(scheduleParameter.getScheduleCronParameter()))
            .build();
        try {
            Integer scheduleId = Integer.valueOf(scheduleParameter.getScheduleCode());
            // Update schedule status to offline
            updateScheduleToOffline(scheduleId);

            // update schedule instance
            String resultJson = post(url, body);
            DolphinResult<Schedule> result = JSONUtils.parseObject(resultJson, new TypeReference<DolphinResult<Schedule>>() {
            });
            checkResult(result, "updateSchedule");

            // Update schedule status to online
            updateScheduleToOnline(scheduleId);
        } catch (IOException e) {
            throw new SchedulerException("dolphin scheduler call updateSchedule method exception", e);
        }
    }

    private void checkResult(DolphinResult result, String method) {
        if (Objects.isNull(result) || HTTP_SUCCESS != result.getCode()) {
            throw new SchedulerException(MessageFormat.format("dolphin scheduler call {0} method exception, {1}", method, Objects.isNull(result) ? "result is empty" : result.getMsg()));
        }
    }

    /**
     * update schedule state to online
     *
     * @param scheduleId schedule id
     * @throws IOException
     */
    private void updateScheduleToOnline(int scheduleId) throws IOException {
        String url = MessageFormat.format("/projects/{0}/schedules/{1}/online", properties.getProjectCode(), scheduleId);
        FormBody body = new FormBody.Builder().build();
        String resultJson = post(url, body);
        DolphinResult result = JSONUtils.parseObject(resultJson, DolphinResult.class);
        checkResult(result, "updateScheduleToOnline");
    }

    /**
     * update schedule state to offline
     *
     * @param scheduleId schedule id
     * @throws IOException
     */
    private void updateScheduleToOffline(int scheduleId) throws IOException {
        String url = MessageFormat.format("/projects/{0}/schedules/{1}/offline", properties.getProjectCode(), scheduleId);
        FormBody body = new FormBody.Builder().build();
        String resultJson = post(url, body);
        DolphinResult result = JSONUtils.parseObject(resultJson, DolphinResult.class);
        checkResult(result, "updateScheduleToOffline");
    }

    private void updateFlowState(long flowCode, String state) throws IOException {
        String url = MessageFormat.format("/projects/{0}/process-definition/{1}/release", properties.getProjectCode(), String.valueOf(flowCode));
        FormBody body = new FormBody.Builder()
            .add("releaseState", state)
            .build();
        String resultJson = post(url, body);
        DolphinResult result = JSONUtils.parseObject(resultJson, DolphinResult.class);
        checkResult(result, "updateFlowState");
    }

    // -----------------------------------------------------------------------------------------------------------------

    private String generateDolphinHttpTaskParameter(String taskParams) {
        HttpTaskParameter httpTaskParameter = JSONUtils.parseObject(taskParams, HttpTaskParameter.class);

        HttpParameter dolphinHttpParameter = new HttpParameter();
        dolphinHttpParameter.setUrl(httpTaskParameter.getUrl());
        dolphinHttpParameter.setHttpMethod(httpTaskParameter.getMethod());

        List<HttpProperty> dolphinHttpProperties = new ArrayList<>();
        // http header
        httpTaskParameter.getHeaders().forEach((key, value) -> {
            HttpProperty httpProperty = new HttpProperty();
            httpProperty.setHttpParametersType(HttpParametersType.HEADERS);
            httpProperty.setProp(key);
            httpProperty.setValue(value);
            dolphinHttpProperties.add(httpProperty);
        });

        // http parameter
        httpTaskParameter.getParams().forEach((key, value) -> {
            HttpProperty httpProperty = new HttpProperty();
            httpProperty.setHttpParametersType(HttpParametersType.PARAMETER);
            httpProperty.setProp(key);
            httpProperty.setValue(value);
            dolphinHttpProperties.add(httpProperty);
        });

        // http body
        Map<String, String> bodyMap = JSONUtils.parseObject(httpTaskParameter.getBody(), new TypeReference<Map<String, String>>() {
        });
        if (Objects.nonNull(bodyMap)) {
            bodyMap.forEach((key, value) -> {
                HttpProperty httpProperty = new HttpProperty();
                httpProperty.setHttpParametersType(HttpParametersType.BODY);
                httpProperty.setProp(key);
                httpProperty.setValue(value);
                dolphinHttpProperties.add(httpProperty);
            });
        }
        dolphinHttpParameter.setHttpParams(dolphinHttpProperties);
        dolphinHttpParameter.setConnectTimeout(httpTaskParameter.getConnectTimeout());
        dolphinHttpParameter.setSocketTimeout(httpTaskParameter.getSocketTimeout());
        return JSONUtils.toJSONString(dolphinHttpParameter);
    }

    @Override
    public String createSingleHttpTask(TaskParameter taskParameter) {

        String dolphinHttpParameterJson = generateDolphinHttpTaskParameter(taskParameter.getTaskParams());

        Long taskCode;
        try {
            taskCode = CodeGenerateUtils.getInstance().genCode();
        } catch (CodeGenerateUtils.CodeGenerateException e) {
            throw new SchedulerException("dolphin scheduler generate unique code exception", e);
        }

        // create task definition
        List<TaskDefinitionParameter> dolphinTaskDefinitionList = new ArrayList<>();
        TaskDefinitionParameter dolphinTaskDefinitionParameter = new TaskDefinitionParameter();
        dolphinTaskDefinitionParameter.setTaskParams(dolphinHttpParameterJson);
        dolphinTaskDefinitionParameter.setCode(taskCode);
        dolphinTaskDefinitionParameter.setTaskType("HTTP");
        dolphinTaskDefinitionParameter.setName(taskParameter.getName());
        dolphinTaskDefinitionParameter.setDescription(taskParameter.getDescription());
        dolphinTaskDefinitionList.add(dolphinTaskDefinitionParameter);

        // create task definition relations
        List<ProcessTaskRelationParameter> taskRelationList = new ArrayList<>();
        ProcessTaskRelationParameter processTaskRelationParameter = new ProcessTaskRelationParameter();
        processTaskRelationParameter.setPostTaskCode(taskCode);
        processTaskRelationParameter.setPostTaskVersion(1);
        taskRelationList.add(processTaskRelationParameter);

        // create flow dag locations
        List<ProcessDAGLocationParameter> locations = new ArrayList<>();
        ProcessDAGLocationParameter locationParameter = new ProcessDAGLocationParameter();
        locationParameter.setTaskCode(taskCode);
        locationParameter.setX(150);
        locationParameter.setY(150);
        locations.add(locationParameter);

        String url = MessageFormat.format("/projects/{0}/process-definition", properties.getProjectCode());
        FormBody body = new FormBody.Builder()
            .add("name", taskParameter.getName())
            .add("description", taskParameter.getDescription())
            .add("tenantCode", properties.getTenantCode())
            .add("taskRelationJson", JSONUtils.toJSONString(taskRelationList))
            .add("taskDefinitionJson", JSONUtils.toJSONString(dolphinTaskDefinitionList))
            .add("locations", JSONUtils.toJSONString(locations))
            .build();

        try {
            // create task instance and flow instance
            String resultJson = post(url, body);
            DolphinResult<ProcessDefinition> result = JSONUtils.parseObject(resultJson, new TypeReference<DolphinResult<ProcessDefinition>>() {
            });
            checkResult(result, "createSingleHttpTask");

            long flowCode = result.getData().getCode();
            // Update flow status to online
            updateFlowState(flowCode, ReleaseState.ONLINE.toString());
            return String.valueOf(flowCode);
        } catch (IOException e) {
            throw new SchedulerException("dolphin scheduler call createSingleHttpTask method exception", e);
        }
    }

    public void updateSingleHttpTask(TaskParameter taskParameter) {

    }

    private void queryFlowByCode(String flowCode) {
        String url = MessageFormat.format("/projects/{0}/process-definition/{1}", properties.getProjectCode(), flowCode);
        try {
            String resultJson = get(url);

        } catch (IOException e) {
            throw new SchedulerException("dolphin scheduler call queryFlowByCode method exception", e);
        }
    }

    @Override
    public void deleteFlowByCode(String flowCode) {
        String url = MessageFormat.format("/projects/{0}/process-definition/{1}", properties.getProjectCode(), flowCode);
        try {
            // Update flow status to online
            updateFlowState(Long.valueOf(flowCode), ReleaseState.OFFLINE.toString());

            // delete flow by code
            String resultJson = delete(url);
            DolphinResult result = JSONUtils.parseObject(resultJson, DolphinResult.class);
            checkResult(result, "deleteFlowByCode");
        } catch (IOException e) {
            throw new SchedulerException("dolphin scheduler call deleteFlowByCode method exception", e);
        }

    }

    // TODO @Deprecated start
    public Object queryTaskDefinitionPageList() {
        String url = "http://dolphinscheduler.dev.zhaopin.com/dolphinscheduler/projects/4996418468000/process-definition?pageNo=1&pageSize=10&&searchVal=";
        DolphinResult result = null;
        try {
            String json = get(url);
            result = JSONUtils.parseObject(json, DolphinResult.class);
            if (Objects.isNull(result) || HTTP_SUCCESS != result.getCode()) {
                return new SchedulerResult(false, "don't get anything of task definitions");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Object queryTaskDefinitionByCode() {
        String url = "http://dolphinscheduler.dev.zhaopin.com/dolphinscheduler/projects/4996418468000/process-definition/5028876785952";
        DolphinResult result = null;
        String cronJson = null;
        DolphinResult cronResult = null;
        try {
            String json = get(url);
            result = JSONUtils.parseObject(json, DolphinResult.class);
            if (Objects.isNull(result) || HTTP_SUCCESS != result.getCode()) {
                return new SchedulerResult(false, "don't get anything of task definition detail");
            }
            //获取定时管理
            schedulerMap
                .put("processDefinitionCode", "5017950541088");
            cronJson = get(
                "http://dolphinscheduler.dev.zhaopin.com/dolphinscheduler/projects/4996418468000/schedules?processDefinitionCode=5028876785952&searchVal=&pageNo=1&pageSize=10");
            cronResult = JSONUtils.parseObject(cronJson, DolphinResult.class);
            result.setData(result.getData().toString() + cronResult.getData().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String queryTaskInstanceDetailLogs() {
        String url = MessageFormat.format("/log/detail?taskInstanceId={0}&skipLineNum={1}&limit={2}", properties.getProjectCode(), "", "");
        try {
            String resultJson = get(url);
            DolphinResult<String> result = JSONUtils.parseObject(resultJson, new TypeReference<DolphinResult<String>>() {
            });
            checkResult(result, "queryTaskInstanceLogs");
            return result.getData();
        } catch (IOException e) {
            throw new SchedulerException("dolphin scheduler call queryTaskInstanceLogs method exception", e);
        }
    }

    public Object queryTaskInstanceLogs() {
        String url = "http://dolphinscheduler.dev.zhaopin.com/dolphinscheduler/projects/4996418468000/task-instances?"
            + "pageSize=10&pageNo=1&searchVal=&processInstanceId=&host=&stateType=&startDate=&endDate=&executorName=&processInstanceName=";
        DolphinResult result = null;
        try {
            String json = get(url);
            result = JSONUtils.parseObject(json, DolphinResult.class);
            if (Objects.isNull(result) || HTTP_SUCCESS != result.getCode()) {
                return new SchedulerResult(false, "don't get anything of task definitions' logs");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Object updateTaskDefinition() {
        String url = "http://dolphinscheduler.dev.zhaopin.com/dolphinscheduler/projects/4996418468000/process-definition/5028876785952";
        DolphinResult result = null;
        String cronJson = null;
        DolphinResult cronResult = null;
        //try {
        // String json = put(url, putMap);
        // result = JSONUtils.parseObject(json, DolphinResult.class);
        if (Objects.isNull(result) || HTTP_SUCCESS != result.getCode()) {
            return new SchedulerResult(false, "delete processdefinition is error");
        }
        schedulerMap
            .put("processDefinitionCode", "5017950541088");
        //cronJson = put(
        //        "http://dolphinscheduler.dev.zhaopin.com/dolphinscheduler/projects/4996418468000/schedules/28",
        //        putScheduleMap);
        cronResult = JSONUtils.parseObject(cronJson, DolphinResult.class);
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
        return cronResult;
    }

    // TODO @Deprecated end

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * get http request
     *
     * @param url url
     * @return json response
     * @throws IOException
     */
    public String get(String url) throws IOException {
        url = properties.getServiceUrl() + url;
        Request request = new Request.Builder()
            .url(url)
            .addHeader(HEADER_TOKEN_NAME, properties.getToken())
            .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    /**
     * Form post http request
     *
     * @param url  url
     * @param body form body
     * @return json response
     * @throws IOException
     */
    public String post(String url, FormBody body) throws IOException {
        url = properties.getServiceUrl() + url;
        Request request = new Request.Builder()
            .url(url)
            .post(body)
            .addHeader(HEADER_TOKEN_NAME, properties.getToken())
            .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public String delete(String url) throws IOException {
        url = properties.getServiceUrl() + url;
        Request request = new Request.Builder()
            .url(url)
            .delete()
            .addHeader(HEADER_TOKEN_NAME, properties.getToken())
            .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public String post(String url, String json) throws IOException {
        url = properties.getServiceUrl() + url;
        RequestBody body = RequestBody.create(json, MEDIA_TYPE_JSON);
        Request request = new Request.Builder()
            .url(url)
            .post(body)
            .addHeader(HEADER_TOKEN_NAME, properties.getToken())
            .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public String put(String url, FormBody body) throws IOException {
        url = properties.getServiceUrl() + url;
        Request request = new Request.Builder()
            .url(url)
            .put(body)
            .addHeader(HEADER_TOKEN_NAME, properties.getToken())
            .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    @Override
    public void close() {

    }

}
