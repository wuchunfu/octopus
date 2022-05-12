package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.dto.MetricsConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetricsCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.metrics.api.JSONUtils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MetricsControllerImplTest1 {

    @Autowired
    private MetricsControllerImpl metricsController;

    private MetricsResponseDTO create(MetricsCreateOrUpdateRequestDTO requestDTO) {
        ResultEntity<MetricsResponseDTO> create = metricsController.create(requestDTO);
        Assertions.assertTrue(create.isSuccess());
        MetricsResponseDTO createData = create.getData();
        Assertions.assertNotNull(createData.getId());
        return createData;
    }

    @Test
    public void testCreate() {
        MetricsCreateOrUpdateRequestDTO requestDTO = new MetricsCreateOrUpdateRequestDTO();
        requestDTO.setCode("count");
        requestDTO.setName("count");
        create(requestDTO);
    }

    @Test
    public void testUpdate() {
        MetricsCreateOrUpdateRequestDTO requestDTO = new MetricsCreateOrUpdateRequestDTO();
        requestDTO.setCode("null_value");
        requestDTO.setName("null_value");
        requestDTO.setCategory("single");
        MetricsResponseDTO createData = create(requestDTO);

        MetricsCreateOrUpdateRequestDTO updateRequestDTO = JSONUtils.parseObject(JSONUtils.toJSONString(createData), MetricsCreateOrUpdateRequestDTO.class);
        String updateName = "new null_value metrics";
        updateRequestDTO.setName(updateName);
        updateRequestDTO.setDescription(updateName);
        updateRequestDTO.setCategory(null);
        ResultEntity<MetricsResponseDTO> update = metricsController.update(updateRequestDTO);
        Assertions.assertTrue(update.isSuccess());
        MetricsResponseDTO updateData = update.getData();
        Assertions.assertEquals(updateName, updateData.getName());
        Assertions.assertNotNull(updateData.getDescription());

    }

    @Test
    public void testQueryList() {

        MetricsCreateOrUpdateRequestDTO requestDTO1 = new MetricsCreateOrUpdateRequestDTO();
        requestDTO1.setCode("null_value1");
        requestDTO1.setName("null_value");
        requestDTO1.setCategory("single");
        create(requestDTO1);

        MetricsCreateOrUpdateRequestDTO requestDTO2 = new MetricsCreateOrUpdateRequestDTO();
        requestDTO2.setCode("count1");
        requestDTO2.setName("count");
        requestDTO2.setCategory("single");
        MetricsResponseDTO createData2 = create(requestDTO2);

        MetricsConditionsRequestDTO conditionsRequestDTO = new MetricsConditionsRequestDTO();
        conditionsRequestDTO.setName("count");
        ResultEntity<List<MetricsResponseDTO>> result = metricsController.queryList(conditionsRequestDTO);
        Assertions.assertTrue(result.isSuccess());
        List<MetricsResponseDTO> data = result.getData();
        Assertions.assertEquals(1, data.size());
        Assertions.assertEquals(createData2.getId(), data.get(0).getId());
    }

    @Test
    public void testQueryListPage() {
        MetricsCreateOrUpdateRequestDTO requestDTO1 = new MetricsCreateOrUpdateRequestDTO();
        requestDTO1.setCode("null_value2");
        requestDTO1.setName("null_value");
        requestDTO1.setCategory("single");
        create(requestDTO1);

        MetricsCreateOrUpdateRequestDTO requestDTO2 = new MetricsCreateOrUpdateRequestDTO();
        requestDTO2.setCode("count2");
        requestDTO2.setName("count2");
        requestDTO2.setCategory("single");
        MetricsResponseDTO createData2 = create(requestDTO2);

        MetricsConditionsRequestDTO conditionsRequestDTO = new MetricsConditionsRequestDTO();
        conditionsRequestDTO.setPageNo(1);
        conditionsRequestDTO.setPageSize(10);
        conditionsRequestDTO.setName("count2");
        ResultEntity<PageResponseDTO<MetricsResponseDTO>> pageResult = metricsController.queryListPage(conditionsRequestDTO);
        Assertions.assertTrue(pageResult.isSuccess());
        PageResponseDTO<MetricsResponseDTO> data = pageResult.getData();
        Assertions.assertEquals(1, data.getTotal());
        Assertions.assertEquals(createData2.getId(), data.getData().get(0).getId());
    }

    @Test
    public void deleteById() {
        MetricsCreateOrUpdateRequestDTO requestDTO1 = new MetricsCreateOrUpdateRequestDTO();
        requestDTO1.setCode("null_value3");
        requestDTO1.setName("null_value");
        requestDTO1.setCategory("single");
        MetricsResponseDTO metricsResponseDTO = create(requestDTO1);

        ResultEntity result = metricsController.deleteById(metricsResponseDTO.getId());
        Assertions.assertTrue(result.isSuccess());
    }
}
