package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.server.monitordb.MonitorDBPluginHelpher;
import org.metahut.octopus.server.service.MonitorDBService;

import org.springframework.stereotype.Service;

@Service
public class MonitorDBServiceImpl implements MonitorDBService {

    private final MonitorDBPluginHelpher monitorDBPluginHelpher;

    public MonitorDBServiceImpl(MonitorDBPluginHelpher monitorDBPluginHelpher) {
        this.monitorDBPluginHelpher = monitorDBPluginHelpher;
    }

    private void customSQLQuery() {
        monitorDBPluginHelpher.getMonitorDBSource().customSQLQuery();
    }

}
