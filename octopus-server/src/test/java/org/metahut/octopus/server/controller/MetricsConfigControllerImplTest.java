package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.dto.MetricsConfigConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetricsConfigCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsConfigResponseDTO;
import org.metahut.octopus.api.dto.MetricsCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.metrics.api.JSONUtils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MetricsConfigControllerImplTest {

    @Autowired
    private MetricsConfigControllerImpl metricsConfigController;

    @Autowired
    private MetricsControllerImpl metricsController;

    private MetricsConfigResponseDTO create(MetricsConfigCreateOrUpdateRequestDTO requestDTO) {
        ResultEntity<MetricsConfigResponseDTO> create = metricsConfigController.create(requestDTO);
        Assertions.assertTrue(create.isSuccess());
        MetricsConfigResponseDTO createData = create.getData();
        Assertions.assertNotNull(createData.getId());
        Assertions.assertNotNull(createData.getMetrics());
        return createData;
    }

    /**
     * create metrics
     * @param requestDTO
     * @return
     */
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

        MetricsConfigCreateOrUpdateRequestDTO requestDTO = new MetricsConfigCreateOrUpdateRequestDTO();
        requestDTO.setMetricsCode(metrics.getCode());
        requestDTO.setSourceCategory("Hive");
        create(requestDTO);
    }

    @Test
    public void testUpdate() {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCode("c_count1");
        metricsCreateOrUpdateRequestDTO.setName("c_count1");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        MetricsConfigCreateOrUpdateRequestDTO requestDTO = new MetricsConfigCreateOrUpdateRequestDTO();
        requestDTO.setMetricsCode(metrics.getCode());
        requestDTO.setSourceCategory("Hive1");
        MetricsConfigResponseDTO createData = create(requestDTO);

        MetricsConfigCreateOrUpdateRequestDTO updateRequestDTO = JSONUtils.parseObject(JSONUtils.toJSONString(createData), MetricsConfigCreateOrUpdateRequestDTO.class);
        String updateStr = "HBase1";
        updateRequestDTO.setMetricsCode(createData.getMetrics().getCode());
        updateRequestDTO.setSourceCategory(updateStr);
        updateRequestDTO.setDescription(updateStr);
        ResultEntity<MetricsConfigResponseDTO> update = metricsConfigController.update(updateRequestDTO);
        Assertions.assertTrue(update.isSuccess());
        MetricsConfigResponseDTO updateData = update.getData();
        Assertions.assertEquals(updateStr, updateData.getSourceCategory());
        Assertions.assertNotNull(updateData.getDescription());
    }

    @Test
    public void testQueryList() {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCode("c_count2");
        metricsCreateOrUpdateRequestDTO.setName("c_count2");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        MetricsConfigCreateOrUpdateRequestDTO requestDTO1 = new MetricsConfigCreateOrUpdateRequestDTO();
        requestDTO1.setMetricsCode(metrics.getCode());
        requestDTO1.setSourceCategory("Hive2");
        create(requestDTO1);

        MetricsConfigCreateOrUpdateRequestDTO requestDTO2 = new MetricsConfigCreateOrUpdateRequestDTO();
        requestDTO2.setMetricsCode(metrics.getCode());
        requestDTO2.setSourceCategory("HBase2");
        create(requestDTO2);

        MetricsConfigConditionsRequestDTO conditionsRequestDTO = new MetricsConfigConditionsRequestDTO();
        conditionsRequestDTO.setMetricsCode(metrics.getCode());
        ResultEntity<List<MetricsConfigResponseDTO>> result = metricsConfigController.queryList(conditionsRequestDTO);
        Assertions.assertTrue(result.isSuccess());
        List<MetricsConfigResponseDTO> data = result.getData();
        Assertions.assertEquals(2, data.size());
    }

    @Test
    public void testQueryListPage() {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCode("c_count3");
        metricsCreateOrUpdateRequestDTO.setName("c_count3");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        MetricsConfigCreateOrUpdateRequestDTO requestDTO1 = new MetricsConfigCreateOrUpdateRequestDTO();
        requestDTO1.setMetricsCode(metrics.getCode());
        requestDTO1.setSourceCategory("Hive3");
        create(requestDTO1);

        MetricsConfigCreateOrUpdateRequestDTO requestDTO2 = new MetricsConfigCreateOrUpdateRequestDTO();
        requestDTO2.setMetricsCode(metrics.getCode());
        requestDTO2.setSourceCategory("HBase3");
        create(requestDTO2);

        MetricsConfigConditionsRequestDTO conditionsRequestDTO = new MetricsConfigConditionsRequestDTO();
        conditionsRequestDTO.setPageNo(1);
        conditionsRequestDTO.setPageSize(10);
        conditionsRequestDTO.setMetricsCode(metrics.getCode());
        ResultEntity<PageResponseDTO<MetricsConfigResponseDTO>> result = metricsConfigController.queryListPage(conditionsRequestDTO);
        Assertions.assertTrue(result.isSuccess());
        PageResponseDTO<MetricsConfigResponseDTO> data = result.getData();
        Assertions.assertEquals(2, data.getTotal());
    }

    @Test
    public void testDeleteById() {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCode("c_count4");
        metricsCreateOrUpdateRequestDTO.setName("c_count4");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        MetricsConfigCreateOrUpdateRequestDTO requestDTO1 = new MetricsConfigCreateOrUpdateRequestDTO();
        requestDTO1.setMetricsCode(metrics.getCode());
        requestDTO1.setSourceCategory("Hive4");
        MetricsConfigResponseDTO createData = create(requestDTO1);
        ResultEntity result = metricsConfigController.deleteById(createData.getId());
        Assertions.assertTrue(result.isSuccess());
    }
}
