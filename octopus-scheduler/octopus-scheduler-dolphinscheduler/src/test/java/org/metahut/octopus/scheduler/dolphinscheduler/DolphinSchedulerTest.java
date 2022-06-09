package org.metahut.octopus.scheduler.dolphinscheduler;

import org.metahut.octopus.scheduler.api.ExecutionStatus;
import org.metahut.octopus.scheduler.api.SchedulerProperties;
import org.metahut.octopus.scheduler.api.SchedulerTypeEnum;
import org.metahut.octopus.scheduler.api.entity.FlowDefinition;
import org.metahut.octopus.scheduler.api.parameters.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Disabled
public class DolphinSchedulerTest {

    private DolphinScheduler scheduler;

    private static final String SERVICE_URL = "http://dolphinscheduler.xxx.com/dolphinscheduler";

    private static final String TOKEN = "c6258d4a509df0f1b89f77fb552d8ddf";
    private static final String PROJECT_CODE = "4996418468000";

    public static final String TASK_NAME = "hive-collector-task";

    @BeforeEach
    public void before() {
        SchedulerProperties schedulerProperties = new SchedulerProperties();
        schedulerProperties.setType(SchedulerTypeEnum.dolphinscheduler);

        SchedulerProperties.DolphinScheduler dolphinSchedulerConfig = new SchedulerProperties.DolphinScheduler();
        dolphinSchedulerConfig.setServiceUrl(SERVICE_URL);
        dolphinSchedulerConfig.setToken(TOKEN);
        dolphinSchedulerConfig.setProjectCode(PROJECT_CODE);
        schedulerProperties.setDolphinscheduler(dolphinSchedulerConfig);

        scheduler = new DolphinSchedulerManager(schedulerProperties).getScheduler();

    }

    @Test
    public void testQueryProjectCreatedAndAuthorizedByUser() throws IOException {
        String url = "/projects/created-and-authed";
        String json = scheduler.get(url);
        DolphinResult result = JSONUtils.parseObject(json, DolphinResult.class);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(0, result.getCode());
    }

    @Test
    public void testPreviewSchedule() {
        ScheduleCronParameter parameter = new ScheduleCronParameter();
        parameter.setCrontab("0 30 * * * ?");
        parameter.setStartTime(new Date());
        parameter.setEndTime(Date.from(LocalDateTime.now().plusDays(2).atZone(ZoneId.systemDefault()).toInstant()));
        List<String> strings = scheduler.previewSchedule(parameter);
        Assertions.assertNotNull(strings);
    }

    @Test
    public void testUpdateSchedule() {
        String flowCode = "5802334298016";
        String cron = "0 30 4 * * ?";
        ScheduleParameter scheduleParameter = new ScheduleParameter();
        scheduleParameter.setFlowCode(flowCode);
        ScheduleCronParameter scheduleCronParameter = new ScheduleCronParameter();
        scheduleCronParameter.setCrontab(cron);
        scheduleParameter.setScheduleCronParameter(scheduleCronParameter);
        scheduler.updateSchedule(scheduleParameter);
    }

    @Test
    public void testCreateSingleHttpTask() {
        TaskParameter taskParameter = new TaskParameter();

        taskParameter.setName(TASK_NAME);
        taskParameter.setDescription("http test");
        taskParameter.setTaskType("HTTP");
        HttpTaskParameter httpTaskParameter = new HttpTaskParameter();

        httpTaskParameter.setUrl(SERVICE_URL);
        httpTaskParameter.setMethod("POST");
        // http body
        Map<String, String> bodyMap = new HashMap<>();
        bodyMap.put("type", "Hive");
        bodyMap.put("datasourceId", "1");
        httpTaskParameter.setBody(JSONUtils.toJSONString(bodyMap));

        taskParameter.setTaskParams(JSONUtils.toJSONString(httpTaskParameter));

        String flowCode = scheduler.createSingleHttpTask(taskParameter);

        Assertions.assertNotNull(flowCode);
    }

    @Test
    public void testQueryFlowByCode() {
        FlowDefinition flowDefinition = scheduler.queryFlowByCode("5657947648672");
        Assertions.assertEquals(flowDefinition.getName(), TASK_NAME);
    }

    @Test
    public void testQueryFlowInstanceListPage() {
        FlowInstanceRequestParameter pageRequest = new FlowInstanceRequestParameter();
        pageRequest.setPageNo(1);
        pageRequest.setPageSize(10);
        pageRequest.setExecutionStatus(ExecutionStatus.FAIL);

        Assertions.assertDoesNotThrow(() -> scheduler.queryFlowInstanceListPage(pageRequest));
    }

    @Test
    public void testQueryTaskInstanceListPage() {
        TaskInstanceRequestParameter requestParameter = new TaskInstanceRequestParameter();
        requestParameter.setPageNo(1);
        requestParameter.setPageSize(10);

        Assertions.assertDoesNotThrow(() -> scheduler.queryTaskInstanceListPage(requestParameter));
    }

    @Test
    public void testQueryTaskInstanceLog() {
        TaskInstanceLogRequestParameter requestParameter = new TaskInstanceLogRequestParameter();
        requestParameter.setOffset(0);
        requestParameter.setLimit(1000);
        requestParameter.setTaskInstanceId(265848);

        Assertions.assertDoesNotThrow(() -> scheduler.queryFlowInstanceLog(requestParameter));
    }

}
