package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.MonitorFlowInstanceController;
import org.metahut.octopus.api.dto.MetaDatasetResponseDTO;
import org.metahut.octopus.api.dto.MetaDatasourceResponseDTO;
import org.metahut.octopus.api.dto.MonitorFlowDefinitionResponseDTO;
import org.metahut.octopus.api.dto.MonitorFlowInstanceConditionsRequestDTO;
import org.metahut.octopus.api.dto.MonitorFlowInstanceResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.server.service.MonitorFlowInstanceService;

import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;

@RestController
public class MonitorFlowInstanceControllerImpl implements MonitorFlowInstanceController {

    private final MonitorFlowInstanceService monitorFlowInstanceService;

    public MonitorFlowInstanceControllerImpl(MonitorFlowInstanceService monitorFlowInstanceService) {
        this.monitorFlowInstanceService = monitorFlowInstanceService;
    }

    @Override
    public ResultEntity<PageResponseDTO<MonitorFlowInstanceResponseDTO>> queryListPage(MonitorFlowInstanceConditionsRequestDTO requestDTO) {

        MonitorFlowDefinitionResponseDTO flowDefinition = new MonitorFlowDefinitionResponseDTO();
        // 监控任务编码
        flowDefinition.setId(1);
        flowDefinition.setCrontab("* 1 1 * * ?");
        flowDefinition.setCode(1L);

        MetaDatasetResponseDTO meta = new MetaDatasetResponseDTO();
        // 数据集
        meta.setName("dwd_table_xxxxx");
        MetaDatasourceResponseDTO datasource = new MetaDatasourceResponseDTO();
        // 数据源
        datasource.setName("HIVE-IDC");
        meta.setDatasource(datasource);
        flowDefinition.setMeta(meta);

        MonitorFlowInstanceResponseDTO flowInstance = new MonitorFlowInstanceResponseDTO();
        flowInstance.setTaskStartTime(new Date());
        flowInstance.setTaskEndTime(new Date());
        //序号
        flowInstance.setSchedulerInstanceCode("1");
        //任务状态
        flowInstance.setExecutionStatus("成功");
        flowInstance.setFlowDefinition(flowDefinition);

        return ResultEntity.success(PageResponseDTO.of(1, 10, 1L, Arrays.asList(flowInstance)));

        //return ResultEntity.success(monitorFlowInstanceService.queryListPage(requestDTO));
    }

}
