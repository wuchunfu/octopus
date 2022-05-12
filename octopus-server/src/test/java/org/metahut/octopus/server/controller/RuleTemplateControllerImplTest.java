package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.dto.MetricsCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.api.dto.RuleTemplateRequestDTO;
import org.metahut.octopus.api.dto.RuleTemplateResponseDTO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RuleTemplateControllerImplTest {

    @Autowired
    private RuleTemplateControllerImpl ruleTemplateController;

    @Autowired
    private MetricsControllerImpl metricsController;

    private RuleTemplateResponseDTO create(RuleTemplateRequestDTO requestDTO) {
        ResultEntity<RuleTemplateResponseDTO> ruleTemplate = ruleTemplateController.createRuleTemplate(requestDTO);
        Assertions.assertTrue(ruleTemplate.isSuccess());
        RuleTemplateResponseDTO createData = ruleTemplate.getData();
        Assertions.assertNotNull(createData.getId());
        return ruleTemplate.getData();
    }

    private MetricsResponseDTO createMetrics(MetricsCreateOrUpdateRequestDTO requestDTO) {
        ResultEntity<MetricsResponseDTO> create = metricsController.create(requestDTO);
        Assertions.assertTrue(create.isSuccess());
        MetricsResponseDTO createData = create.getData();
        Assertions.assertNotNull(createData.getId());
        return createData;
    }

    @Test
    public void testCreate() {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCode("c_count");
        metricsCreateOrUpdateRequestDTO.setName("c_count");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        RuleTemplateRequestDTO request = new RuleTemplateRequestDTO();
        request.setMetricsCode(metrics.getCode());
        RuleTemplateResponseDTO ruleTemplateResponseDTO = create(request);
    }

    @Test
    public void testDeleteById() {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCode("c_count");
        metricsCreateOrUpdateRequestDTO.setName("c_count");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        RuleTemplateRequestDTO request = new RuleTemplateRequestDTO();
        request.setMetricsCode(metrics.getCode());
        request.setName("test1");
        RuleTemplateResponseDTO ruleTemplateResponseDTO = create(request);
        ruleTemplateController.deleteRuleTemplate(ruleTemplateResponseDTO.getId());
    }

    @Test
    public void testQeryListPage() {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCode("c_count");
        metricsCreateOrUpdateRequestDTO.setName("c_count");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        RuleTemplateRequestDTO request = new RuleTemplateRequestDTO();
        request.setMetricsCode(metrics.getCode());
        request.setName("test1");
        RuleTemplateResponseDTO ruleTemplateResponseDTO = create(request);

        RuleTemplateRequestDTO request2 = new RuleTemplateRequestDTO();
        request.setMetricsCode(metrics.getCode());
        request.setName("test2");
        RuleTemplateResponseDTO ruleTemplateResponseDTO2 = create(request2);

        RuleTemplateRequestDTO req = new RuleTemplateRequestDTO();
        req.setPageNo(1);
        req.setPageSize(10);
        req.setMetricsCode(metrics.getCode());
        ResultEntity<PageResponseDTO<RuleTemplateResponseDTO>> result = ruleTemplateController.queryRuleTemplatePage(req);
        Assertions.assertTrue(result.isSuccess());
        PageResponseDTO<RuleTemplateResponseDTO> data = result.getData();
        Assertions.assertEquals(2, data.getTotal());
    }
}

