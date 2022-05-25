package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.AlerterSourceResponseDTO;
import org.metahut.octopus.dao.entity.AlerterSource;
import org.metahut.octopus.server.WebApplicationTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

public class AlerterSourceConvertTest extends WebApplicationTest {

    @Autowired
    private ConversionService conversionService;

    @Test
    public void testConvert() {
        String name = "test";
        AlerterSource instance = new AlerterSource();
        instance.setName(name);
        AlerterSourceResponseDTO convert = conversionService.convert(instance, AlerterSourceResponseDTO.class);
        Assertions.assertEquals(name, convert.getName());

    }

}
