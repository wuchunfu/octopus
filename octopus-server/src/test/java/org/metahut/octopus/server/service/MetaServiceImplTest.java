package org.metahut.octopus.server.service;

import org.metahut.octopus.api.dto.MetaDatasetRequestDTO;
import org.metahut.octopus.api.dto.MetaDatasetResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.meta.api.IMeta;
import org.metahut.octopus.meta.api.MetaDatasetEntity;
import org.metahut.octopus.server.WebMvcApplicationTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

public class MetaServiceImplTest extends WebMvcApplicationTest {

    @Autowired
    private MetaService metaService;

    @MockBean
    private IMeta iMeta;

    @Test
    public void queryDatasetByCodeTest() {
        MetaDatasetEntity datasetEntity = new MetaDatasetEntity();
        datasetEntity.setCode("35");
        datasetEntity.setName("dwd_xxx");

        //Hive 35  Pulsar 767092
        BDDMockito.given(iMeta.queryDatasetByCode("35")).willReturn(datasetEntity);

        MetaDatasetResponseDTO responseDTO = metaService.queryDatasetByCode("35");
        Assertions.assertNotNull(responseDTO);
        Assertions.assertTrue("35".equals(responseDTO.getCode()));
    }

    @Test
    @Disabled
    public void queryDatasetListPageTest() {
        MetaDatasetRequestDTO requestDTO = new MetaDatasetRequestDTO();
        requestDTO.setPageNo(1);
        requestDTO.setPageSize(100);
        requestDTO.setName("stage_crm_tc_employee");
        requestDTO.setDataSourceType("Hive");
        PageResponseDTO<MetaDatasetResponseDTO> responseDTO = metaService.queryDatasetListPage(requestDTO);
        Assertions.assertNotNull(responseDTO.getData());
    }

}
