package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.dto.MetricsConfigCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsConfigResponseDTO;
import org.metahut.octopus.api.dto.MetricsCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.metrics.api.JSONUtils;
import org.metahut.octopus.server.WebApplicationTest;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public class MetricsConfigControllerImplTest extends WebApplicationTest {

    private static final String REST_FUNCTION_URL_PREFIX = "/metricsConfig/";

    private MetricsConfigResponseDTO create(MetricsConfigCreateOrUpdateRequestDTO requestDTO) {
        String url = REST_FUNCTION_URL_PREFIX + "create";

        HttpEntity httpEntity = new HttpEntity(requestDTO);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, httpEntity, String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<MetricsConfigResponseDTO> create = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<MetricsConfigResponseDTO>>() {
        });
        Assertions.assertTrue(create.isSuccess());
        MetricsConfigResponseDTO createData = create.getData();
        Assertions.assertNotNull(createData.getId());
        Assertions.assertNotNull(createData.getMetrics());
        return createData;
    }

    /**
     * create metrics
     *
     * @param requestDTO
     * @return
     */
    private MetricsResponseDTO createMetrics(MetricsCreateOrUpdateRequestDTO requestDTO) {

        String url = "/metrics/create";

        HttpEntity httpEntity = new HttpEntity(requestDTO);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, httpEntity, String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<MetricsResponseDTO> create = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<MetricsResponseDTO>>() {
        });
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

        String url = REST_FUNCTION_URL_PREFIX + "update";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(updateRequestDTO, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, httpEntity, String.class);

        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<MetricsConfigResponseDTO> update = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<MetricsConfigResponseDTO>>() {
        });
        Assertions.assertTrue(update.isSuccess());
        MetricsConfigResponseDTO data = update.getData();
        Assertions.assertEquals(updateStr, data.getSourceCategory());

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

        String url = this.base + REST_FUNCTION_URL_PREFIX + "queryList";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
            .queryParam("code", metrics.getCode());
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(builder.build().encode().toUri(), String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<List<MetricsConfigResponseDTO>> result = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<List<MetricsConfigResponseDTO>>>() {
        });
        Assertions.assertTrue(result.isSuccess());
        List<MetricsConfigResponseDTO> data = result.getData();
        Assertions.assertTrue(data.size() > 0);
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

        String url = this.base + REST_FUNCTION_URL_PREFIX + "queryListPage";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
            .queryParam("metricsCode", metrics.getCode())
            .queryParam("pageNo", 1)
            .queryParam("pageSize", 10);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(builder.build().encode().toUri(), String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<PageResponseDTO<MetricsConfigResponseDTO>> result =
            JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<PageResponseDTO<MetricsConfigResponseDTO>>>() {
            });
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

        String url = REST_FUNCTION_URL_PREFIX + createData.getId();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(headers);
        ResponseEntity<ResultEntity> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, ResultEntity.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        Assertions.assertTrue(responseEntity.getBody().isSuccess());
    }

    @Test
    public void findByCode() {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCode("c_count5");
        metricsCreateOrUpdateRequestDTO.setName("c_count5");

        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);
        MetricsConfigCreateOrUpdateRequestDTO requestDTO1 = new MetricsConfigCreateOrUpdateRequestDTO();
        requestDTO1.setMetricsCode(metrics.getCode());
        requestDTO1.setSourceCategory("Hive5");
        MetricsConfigResponseDTO createData = create(requestDTO1);

        String url = this.base + REST_FUNCTION_URL_PREFIX + createData.getCode();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(builder.build().encode().toUri(), String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());

        ResultEntity<MetricsConfigResponseDTO> result =
            JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<MetricsConfigResponseDTO>>() {
            });
        Assertions.assertTrue(result.isSuccess());
        Assertions.assertEquals(result.getData().getCode(), createData.getCode());
    }
}
