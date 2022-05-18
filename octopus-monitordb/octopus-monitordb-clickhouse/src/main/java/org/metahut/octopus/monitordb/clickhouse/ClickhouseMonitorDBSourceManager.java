package org.metahut.octopus.monitordb.clickhouse;

import org.metahut.octopus.monitordb.api.IMonitorDBSourceManager;
import org.metahut.octopus.monitordb.api.MonitorDBProperties;
import org.metahut.octopus.monitordb.api.MonitorDBTypeEnum;

import java.util.Objects;

public class ClickhouseMonitorDBSourceManager implements IMonitorDBSourceManager {

    private ClickhouseMonitorDBSource clickhouseMonitorDBSource;

    public ClickhouseMonitorDBSourceManager() {

    }

    public ClickhouseMonitorDBSourceManager(MonitorDBProperties monitorDBProperties) {
        init(monitorDBProperties);
    }

    @Override
    public MonitorDBTypeEnum getType() {
        return MonitorDBTypeEnum.clickhouse;
    }

    @Override
    public void init(MonitorDBProperties monitorDBProperties) {
        clickhouseMonitorDBSource = new ClickhouseMonitorDBSource(monitorDBProperties.getClickhouse());
    }

    @Override
    public ClickhouseMonitorDBSource getMonitorDBSource() {
        return clickhouseMonitorDBSource;
    }

    @Override
    public void close() throws Exception {
        if (Objects.nonNull(clickhouseMonitorDBSource)) {
            clickhouseMonitorDBSource.close();
        }
    }
}
