package org.metahut.octopus.jobs.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

@Disabled
public class MonitorConfigTest {

    @Test
    public void getMonitorConfigTest() {
        MonitorConfig monitorConfig = MonitorConfig.getMonitorConfig();

        Assertions.assertNotNull(monitorConfig);

        Assertions.assertTrue(StringUtils.isNotBlank(monitorConfig.getAlertService()));

    }
}
