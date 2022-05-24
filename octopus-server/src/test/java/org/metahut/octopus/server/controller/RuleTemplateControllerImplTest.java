package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.dto.MetricsCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.api.dto.RuleTemplateCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.RuleTemplateResponseDTO;
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

public class RuleTemplateControllerImplTest extends WebApplicationTest {

    private static final String REST_FUNCTION_URL_PREFIX = "/ruleTemplate/";

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

    private RuleTemplateResponseDTO create(RuleTemplateCreateOrUpdateRequestDTO requestDTO) {
        String url = REST_FUNCTION_URL_PREFIX;

        HttpEntity httpEntity = new HttpEntity(requestDTO);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, httpEntity, String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<RuleTemplateResponseDTO> create = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<RuleTemplateResponseDTO>>() {
        });
        Assertions.assertTrue(create.isSuccess());
        RuleTemplateResponseDTO createData = create.getData();
        Assertions.assertNotNull(createData.getId());
        Assertions.assertNotNull(createData.getMetrics());
        return createData;
    }

    @Test
    public void testCreate() {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCode("r_t_count");
        metricsCreateOrUpdateRequestDTO.setName("r_t_count");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        RuleTemplateCreateOrUpdateRequestDTO request = new RuleTemplateCreateOrUpdateRequestDTO();
        request.setMetricsCode(metrics.getCode());
        create(request);
    }

    @Test
    public void testDeleteById() {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCode("r_t_count1");
        metricsCreateOrUpdateRequestDTO.setName("r_t_count1");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        RuleTemplateCreateOrUpdateRequestDTO request = new RuleTemplateCreateOrUpdateRequestDTO();
        request.setMetricsCode(metrics.getCode());
        RuleTemplateResponseDTO createData = create(request);

        String url = REST_FUNCTION_URL_PREFIX + createData.getId();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(headers);
        ResponseEntity<ResultEntity> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, ResultEntity.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        Assertions.assertTrue(responseEntity.getBody().isSuccess());

    }

    @Test
    public void testQueryListPage() {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCode("r_t_count2");
        metricsCreateOrUpdateRequestDTO.setName("r_t_count2");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        RuleTemplateCreateOrUpdateRequestDTO requestDTO1 = new RuleTemplateCreateOrUpdateRequestDTO();
        requestDTO1.setMetricsCode(metrics.getCode());
        requestDTO1.setName("test2-1");
        create(requestDTO1);

        RuleTemplateCreateOrUpdateRequestDTO requestDTO2 = new RuleTemplateCreateOrUpdateRequestDTO();
        requestDTO2.setMetricsCode(metrics.getCode());
        requestDTO2.setName("test2-2");
        create(requestDTO2);

        String url = this.base + REST_FUNCTION_URL_PREFIX + "queryListPage";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
            .queryParam("metricsCode", metrics.getCode())
            .queryParam("pageNo", 1)
            .queryParam("pageSize", 10);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(builder.build().encode().toUri(), String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<PageResponseDTO<RuleTemplateResponseDTO>> result = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<PageResponseDTO<RuleTemplateResponseDTO>>>() {
        });
        Assertions.assertTrue(result.isSuccess());
        PageResponseDTO<RuleTemplateResponseDTO> data = result.getData();
        Assertions.assertEquals(2, data.getTotal());

    }
}

