package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.AlerterInstanceResponseDTO;
import org.metahut.octopus.dao.entity.AlerterInstance;
import org.metahut.octopus.server.WebApplicationTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

public class AlerterInstanceConvertTest extends WebApplicationTest {

    @Autowired
    private ConversionService conversionService;

    @Test
    public void testConvert() {
        String name = "test";
        AlerterInstance instance = new AlerterInstance();
        instance.setName(name);
        AlerterInstanceResponseDTO convert = conversionService.convert(instance, AlerterInstanceResponseDTO.class);
        Assertions.assertEquals(name, convert.getName());

    }

}
