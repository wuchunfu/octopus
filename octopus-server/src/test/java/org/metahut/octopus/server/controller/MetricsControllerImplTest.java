package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.dto.MetricsCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.common.enums.StatusEnum;
import org.metahut.octopus.metrics.api.JSONUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public class MetricsControllerImplTest extends WebApplicationTest {

    private static final String REST_FUNCTION_URL_PREFIX = "/metrics/";

    private MetricsResponseDTO create(MetricsCreateOrUpdateRequestDTO requestDTO) {
        String url = REST_FUNCTION_URL_PREFIX + "create";

        HttpEntity httpEntity = new HttpEntity(requestDTO);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, httpEntity, String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<MetricsResponseDTO> data = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<MetricsResponseDTO>>() {});
        Assertions.assertTrue(data.isSuccess());
        MetricsResponseDTO responseDTO = data.getData();
        Assertions.assertNotNull(responseDTO.getId());
        return responseDTO;
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

        String url = REST_FUNCTION_URL_PREFIX + "update";
        restTemplate.put(url, updateRequestDTO);

        url = REST_FUNCTION_URL_PREFIX + updateRequestDTO.getCode();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<MetricsResponseDTO> update = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<MetricsResponseDTO>>() {});
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
        requestDTO2.setName("count1");
        requestDTO2.setCategory("single");
        MetricsResponseDTO createData2 = create(requestDTO2);

        String url = this.base + REST_FUNCTION_URL_PREFIX + "queryList";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("code", "count1")
                .queryParam("name", "count1");
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(builder.build().encode().toUri(), String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<List<MetricsResponseDTO>> result = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<List<MetricsResponseDTO>>>() {});
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

        String url = this.base + REST_FUNCTION_URL_PREFIX + "queryListPage";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("code", "count2")
                .queryParam("pageNo", 1)
                .queryParam("pageSize", 10);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(builder.build().encode().toUri(), String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<PageResponseDTO<MetricsResponseDTO>> pageResult = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<PageResponseDTO<MetricsResponseDTO>>>() {});
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

        String url = REST_FUNCTION_URL_PREFIX + metricsResponseDTO.getId();
        restTemplate.delete(url);

        url = REST_FUNCTION_URL_PREFIX + metricsResponseDTO.getCode();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<MetricsResponseDTO> result = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<MetricsResponseDTO>>() {});
        Assertions.assertEquals(StatusEnum.METRICS_NOT_EXIST.getCode(), result.getCode());
    }

}
