package org.metahut.octopus.scheduler.dolphinscheduler;

import org.metahut.octopus.scheduler.api.ExecutionStatus;
import org.metahut.octopus.scheduler.api.IScheduler;
import org.metahut.octopus.scheduler.api.PageResponse;
import org.metahut.octopus.scheduler.api.SchedulerException;
import org.metahut.octopus.scheduler.api.SchedulerProperties;
import org.metahut.octopus.scheduler.api.entity.FlowDefinition;
import org.metahut.octopus.scheduler.api.entity.FlowInstance;
import org.metahut.octopus.scheduler.api.entity.TaskInstance;
import org.metahut.octopus.scheduler.api.parameters.FlowInstanceRequestParameter;
import org.metahut.octopus.scheduler.api.parameters.HttpTaskParameter;
import org.metahut.octopus.scheduler.api.parameters.ScheduleCronParameter;
import org.metahut.octopus.scheduler.api.parameters.ScheduleParameter;
import org.metahut.octopus.scheduler.api.parameters.TaskInstanceLogRequestParameter;
import org.metahut.octopus.scheduler.api.parameters.TaskInstanceRequestParameter;
import org.metahut.octopus.scheduler.api.parameters.TaskParameter;
import org.metahut.octopus.scheduler.dolphinscheduler.entity.ComplexProcessDefinition;
import org.metahut.octopus.scheduler.dolphinscheduler.entity.DolphinTaskInstance;
import org.metahut.octopus.scheduler.dolphinscheduler.entity.ProcessDefinition;
import org.metahut.octopus.scheduler.dolphinscheduler.entity.ProcessInstance;
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
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DolphinScheduler implements IScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(DolphinScheduler.class);
    private static final MediaType MEDIA_TYPE_JSON = MediaType.get("application/json; charset=utf-8");
    private static final String HEADER_TOKEN_NAME = "token";
    private static final int HTTP_SUCCESS = 0;

    private final OkHttpClient client;
    private final SchedulerProperties.DolphinScheduler properties;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public DolphinScheduler(OkHttpClient client, SchedulerProperties.DolphinScheduler properties) {
        this.client = client;
        this.properties = properties;
    }

    @Override
    public List<String> previewSchedule(ScheduleCronParameter scheduleCronParameter) {
        setScheduleCronDefaultValue(scheduleCronParameter);
        String url = MessageFormat.format("/projects/{0}/schedules/preview", properties.getProjectCode());
        FormBody body = new FormBody.Builder()
                .add("schedule", JSONUtils.toJSONString(scheduleCronParameter))
                .build();
        try {
            String resultJson = post(url, body);
            DolphinResult<List<String>> result = JSONUtils.parseObject(resultJson, new TypeReference<DolphinResult<List<String>>>() {});
            checkResult(result, "previewSchedule");
            return result.getData();
        } catch (IOException e) {
            throw new SchedulerException("dolphin scheduler call previewSchedule method exception", e);
        }
    }

    /**
     * set schedule cron default value
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
            DolphinResult<Schedule> result = JSONUtils.parseObject(resultJson, new TypeReference<DolphinResult<Schedule>>() {});
            checkResult(result, "createSchedule");
            int scheduleId = result.getData().getId();

            // Update schedule status to online
            updateScheduleToOnline(scheduleId);
            return String.valueOf(scheduleId);
        } catch (IOException e) {
            throw new SchedulerException("dolphin scheduler call createSchedule method exception", e);
        }
    }

    private Schedule queryScheduleByFlowCode(String flowCode) {
        String url = MessageFormat.format("/projects/{0}/schedules?processDefinitionCode={1}&pageNo={2}&pageSize={3}",
                properties.getProjectCode(), flowCode, "1", "10");
        try {
            // create schedule instance
            String resultJson = get(url);
            DolphinResult<DolphinPageInfo<Schedule>> result = JSONUtils.parseObject(resultJson, new TypeReference<DolphinResult<DolphinPageInfo<Schedule>>>() {});
            checkResult(result, "queryScheduleByFlowCode");
            return result.getData().getTotalList().get(0);
        } catch (IOException e) {
            throw new SchedulerException("dolphin scheduler call queryScheduleByFlowCode method exception", e);
        }
    }

    @Override
    public void updateSchedule(ScheduleParameter scheduleParameter) {
        setScheduleCronDefaultValue(scheduleParameter.getScheduleCronParameter());
        try {
            // query schedule code by flow code
            Schedule schedule = queryScheduleByFlowCode(scheduleParameter.getFlowCode());

            Integer scheduleId = schedule.getId();
            // Update schedule status to offline
            updateScheduleToOffline(scheduleId);

            String url = MessageFormat.format("/projects/{0}/schedules/{1}", properties.getProjectCode(), String.valueOf(scheduleId));
            FormBody body = new FormBody.Builder()
                    .add("schedule", JSONUtils.toJSONString(scheduleParameter.getScheduleCronParameter()))
                    .add("warningGroupId", "1")
                    .build();

            // update schedule instance
            String resultJson = put(url, body);
            DolphinResult<Schedule> result = JSONUtils.parseObject(resultJson, new TypeReference<DolphinResult<Schedule>>() {});
            checkResult(result, "updateSchedule");

            // Update schedule status to online
            updateScheduleToOnline(scheduleId);
        } catch (IOException e) {
            throw new SchedulerException("dolphin scheduler call updateSchedule method exception", e);
        }
    }

    private void checkResult(DolphinResult result, String method) {
        if (Objects.isNull(result) || HTTP_SUCCESS != result.getCode()) {
            throw new SchedulerException(MessageFormat.format("dolphin scheduler call {0} method exception, message:{1}", method, Objects.isNull(result) ? "result is empty" : result.getCode() + ":" + result.getMsg()));
        }
    }

    private void printResult(DolphinResult result, String method) {
        if (Objects.isNull(result) || HTTP_SUCCESS != result.getCode()) {
            LOGGER.error("dolphin scheduler call {} method exception, message:{}", method, Objects.isNull(result) ? "result is empty" : result.getCode() + ":" + result.getMsg());
        }
    }

    /**
     * update schedule state to online
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
     * @param scheduleId schedule id
     * @throws IOException
     */
    private void updateScheduleToOffline(int scheduleId) throws IOException {
        String url = MessageFormat.format("/projects/{0}/schedules/{1}/offline", properties.getProjectCode(), scheduleId);
        FormBody body = new FormBody.Builder().build();
        String resultJson = post(url, body);
        DolphinResult result = JSONUtils.parseObject(resultJson, DolphinResult.class);
        printResult(result, "updateScheduleToOffline");
    }

    private DolphinResult updateFlowState(long flowCode, String state) throws IOException {
        String url = MessageFormat.format("/projects/{0}/process-definition/{1}/release", properties.getProjectCode(), String.valueOf(flowCode));
        FormBody body = new FormBody.Builder()
                .add("releaseState", state)
                .build();
        String resultJson = post(url, body);
        return JSONUtils.parseObject(resultJson, DolphinResult.class);
    }

    private void updateFlowStateToOffline(long flowCode) throws IOException {
        DolphinResult result = updateFlowState(flowCode, ReleaseState.OFFLINE.name());
        printResult(result, "updateFlowStateToOffline");
    }

    private void updateFlowStateToOnline(long flowCode) throws IOException {
        DolphinResult result = updateFlowState(flowCode, ReleaseState.ONLINE.name());
        checkResult(result, "updateFlowStateToOnline");
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
        Map<String, String> bodyMap = JSONUtils.parseObject(httpTaskParameter.getBody(), new TypeReference<Map<String, String>>() {});
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
        taskParameter.setTaskParams(dolphinHttpParameterJson);
        return createSingleTask(createSingleTaskDefinitionParameter(taskParameter));
    }

    @Override
    public String createSingleTask(TaskParameter taskParameter) {
        return createSingleTask(createSingleTaskDefinitionParameter(taskParameter));
    }

    private TaskDefinitionParameter createSingleTaskDefinitionParameter(TaskParameter taskParameter) {
        TaskDefinitionParameter dolphinTaskDefinitionParameter = new TaskDefinitionParameter();
        dolphinTaskDefinitionParameter.setTaskParams(taskParameter.getTaskParams());
        dolphinTaskDefinitionParameter.setTaskType(taskParameter.getTaskType());
        dolphinTaskDefinitionParameter.setName(taskParameter.getName());
        dolphinTaskDefinitionParameter.setDescription(taskParameter.getDescription());
        return dolphinTaskDefinitionParameter;
    }

    private String createSingleTask(TaskDefinitionParameter taskDefinitionParameter) {

        Long taskCode;
        try {
            taskCode = CodeGenerateUtils.getInstance().genCode();
        } catch (CodeGenerateUtils.CodeGenerateException e) {
            throw new SchedulerException("dolphin scheduler generate unique code exception", e);
        }

        // create task definition
        List<TaskDefinitionParameter> dolphinTaskDefinitionList = new ArrayList<>();
        taskDefinitionParameter.setCode(taskCode);
        dolphinTaskDefinitionList.add(taskDefinitionParameter);

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
                .add("name", taskDefinitionParameter.getName())
                .add("description", taskDefinitionParameter.getDescription())
                .add("tenantCode", properties.getTenantCode())
                .add("taskRelationJson", JSONUtils.toJSONString(taskRelationList))
                .add("taskDefinitionJson", JSONUtils.toJSONString(dolphinTaskDefinitionList))
                .add("locations", JSONUtils.toJSONString(locations))
                .build();

        try {
            // create task instance and flow instance
            String resultJson = post(url, body);
            DolphinResult<ProcessDefinition> result = JSONUtils.parseObject(resultJson, new TypeReference<DolphinResult<ProcessDefinition>>() {});
            checkResult(result, "createSingleTask");

            long flowCode = result.getData().getCode();
            // Update flow status to online
            updateFlowStateToOnline(flowCode);
            return String.valueOf(flowCode);
        } catch (IOException e) {
            throw new SchedulerException("dolphin scheduler call createSingleTask method exception", e);
        }
    }

    @Override
    public void deleteFlowByCode(String flowCode) {
        String url = MessageFormat.format("/projects/{0}/process-definition/{1}", properties.getProjectCode(), flowCode);
        try {
            // Update flow status to online
            updateFlowStateToOffline(Long.valueOf(flowCode));

            // delete flow by code
            String resultJson = delete(url);
            DolphinResult result = JSONUtils.parseObject(resultJson, DolphinResult.class);
            checkResult(result, "deleteFlowByCode");
        } catch (IOException e) {
            throw new SchedulerException("dolphin scheduler call deleteFlowByCode method exception", e);
        }
    }

    @Override
    public FlowDefinition queryFlowByCode(String flowCode) {
        String url = MessageFormat.format("/projects/{0}/process-definition/{1}", properties.getProjectCode(), flowCode);
        try {
            String resultJson = get(url);

            DolphinResult<ComplexProcessDefinition> result = JSONUtils.parseObject(resultJson, new TypeReference<DolphinResult<ComplexProcessDefinition>>() {});
            checkResult(result, "queryFlowByCode");

            ComplexProcessDefinition complexProcessDefinition = result.getData();
            FlowDefinition flowDefinition = new FlowDefinition();
            BeanUtils.copyProperties(complexProcessDefinition.getProcessDefinition(), flowDefinition);

            return flowDefinition;
        } catch (IOException e) {
            throw new SchedulerException("dolphin scheduler call queryFlowByCode method exception", e);
        }
    }

    @Override
    public PageResponse<FlowInstance> queryFlowInstanceListPage(FlowInstanceRequestParameter parameter) {
        String executionStatusCode = Objects.isNull(parameter.getExecutionStatus()) ? StringUtils.EMPTY
                : ExecutionStatus.FAIL == parameter.getExecutionStatus() ? "FAILURE" : parameter.getExecutionStatus().name();

        String url = MessageFormat.format("/projects/{0}/process-instances?searchVal={1}&pageSize={2}&pageNo={3}&stateType=",
                properties.getProjectCode(),
                StringUtils.isNotBlank(parameter.getName()) ? parameter.getName() : "",
                parameter.getPageSize().toString(),
                parameter.getPageNo().toString(),
                executionStatusCode
        );

        try {
            String resultJson = get(url);
            DolphinResult<DolphinPageInfo<ProcessInstance>> result = JSONUtils.parseObject(resultJson, new TypeReference<DolphinResult<DolphinPageInfo<ProcessInstance>>>() {});
            checkResult(result, "queryFlowInstanceListPage");

            DolphinPageInfo<ProcessInstance> pageInfo = result.getData();

            PageResponse<FlowInstance> pageResponse = new PageResponse<>();

            pageResponse.setPageNo(pageInfo.getCurrentPage());
            pageResponse.setPageSize(pageInfo.getPageSize());
            pageResponse.setTotal(Integer.toUnsignedLong(pageInfo.getTotal()));
            List<FlowInstance> flowInstanceList = new ArrayList<>();
            pageResponse.setData(flowInstanceList);

            pageInfo.getTotalList().forEach(processInstance -> {
                FlowInstance flowInstance = new FlowInstance();
                BeanUtils.copyProperties(processInstance, flowInstance);
                flowInstance.setFlowCode(processInstance.getProcessDefinitionCode());
                flowInstanceList.add(flowInstance);
            });
            return pageResponse;
        } catch (IOException e) {
            throw new SchedulerException("dolphin scheduler call queryFlowInstanceListPage method exception", e);
        }
    }

    @Override
    public PageResponse<TaskInstance> queryTaskInstanceListPage(TaskInstanceRequestParameter parameter) {

        String executionStatusCode = Objects.isNull(parameter.getExecutionStatus()) ? StringUtils.EMPTY
                : ExecutionStatus.FAIL == parameter.getExecutionStatus() ? "FAILURE" : parameter.getExecutionStatus().name();

        String url = MessageFormat.format("/projects/{0}/task-instances?searchVal={1}&pageSize={2}&pageNo={3}&stateType={4}&startDate={5}&endDate={6}&processInstanceName={7}",
                properties.getProjectCode(),
                StringUtils.isNotBlank(parameter.getName()) ? parameter.getName() : "",
                parameter.getPageSize().toString(),
                parameter.getPageNo().toString(),
                executionStatusCode,
                Objects.nonNull(parameter.getBeginTime()) ? formatter.format(parameter.getBeginTime().toInstant().atZone(ZoneId.systemDefault())) : "",
                Objects.nonNull(parameter.getEndTime()) ? formatter.format(parameter.getEndTime().toInstant().atZone(ZoneId.systemDefault())) : "",
                StringUtils.isNotBlank(parameter.getFlowInstanceName()) ? parameter.getFlowInstanceName() : ""
        );

        try {
            String resultJson = get(url);
            DolphinResult<DolphinPageInfo<DolphinTaskInstance>> result = JSONUtils.parseObject(resultJson, new TypeReference<DolphinResult<DolphinPageInfo<DolphinTaskInstance>>>() {});
            checkResult(result, "queryTaskInstanceListPage");

            DolphinPageInfo<DolphinTaskInstance> pageInfo = result.getData();

            PageResponse<TaskInstance> pageResponse = new PageResponse<>();

            pageResponse.setPageNo(pageInfo.getCurrentPage());
            pageResponse.setPageSize(pageInfo.getPageSize());
            pageResponse.setTotal(Integer.toUnsignedLong(pageInfo.getTotal()));
            List<TaskInstance> list = new ArrayList<>();
            pageResponse.setData(list);

            pageInfo.getTotalList().forEach(instance -> {
                TaskInstance taskInstance = new TaskInstance();
                BeanUtils.copyProperties(instance, taskInstance);
                taskInstance.setFlowInstanceId(instance.getProcessInstanceId());
                list.add(taskInstance);
            });
            return pageResponse;
        } catch (IOException e) {
            throw new SchedulerException("dolphin scheduler call queryTaskInstanceListPage method exception", e);
        }
    }

    @Override
    public String queryFlowInstanceLog(TaskInstanceLogRequestParameter requestParameter) {
        String url = String.format("/log/detail?taskInstanceId=%s&skipLineNum=%s&limit=%s",
                requestParameter.getTaskInstanceId(),
                requestParameter.getOffset(),
                requestParameter.getLimit()
        );

        try {
            String resultJson = get(url);
            DolphinResult<String> result = JSONUtils.parseObject(resultJson, new TypeReference<DolphinResult<String>>() {});
            checkResult(result, "queryFlowInstanceLog");

            return result.getData();
        } catch (IOException e) {
            throw new SchedulerException("dolphin scheduler call queryFlowInstanceLog method exception", e);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * get http request
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
     * @param url url
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
