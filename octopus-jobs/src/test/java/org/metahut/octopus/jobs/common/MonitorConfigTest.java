package org.metahut.octopus.jobs.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

public class MonitorConfigTest {

    @Test
    public void getMonitorConfigTest() {
        MonitorConfig monitorConfig = MonitorConfig.getMonitorConfig();

        Assertions.assertNotNull(monitorConfig);

        Assertions.assertTrue(StringUtils.isNotBlank(monitorConfig.getAlertService()));

    }
}
