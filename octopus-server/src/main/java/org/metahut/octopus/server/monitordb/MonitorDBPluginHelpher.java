package org.metahut.octopus.server.monitordb;

import org.metahut.octopus.monitordb.api.IMonitorDBSource;
import org.metahut.octopus.monitordb.api.IMonitorDBSourceManager;
import org.metahut.octopus.monitordb.api.MonitorDBProperties;
import org.metahut.octopus.monitordb.api.MonitorDBTypeEnum;
import org.metahut.octopus.server.utils.YamlFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

import java.util.ServiceLoader;

@Configuration
public class MonitorDBPluginHelpher {

    private IMonitorDBSourceManager monitorDBSourceManager;

    @PostConstruct
    public void init() {
        MonitorDBProperties monitorDBProperties = YamlFactory.parseObject("octopus.monitordb", "application.yaml", new MonitorDBProperties());
        ServiceLoader.load(IMonitorDBSourceManager.class).forEach(manager -> {
            MonitorDBTypeEnum type = manager.getType();
            if (monitorDBProperties.getType() == type) {
                monitorDBSourceManager = manager;
                monitorDBSourceManager.init(monitorDBProperties);
                return;
            }
        });
    }

    @Bean
    public IMonitorDBSource getMonitorDBSource() {
        return monitorDBSourceManager.getMonitorDBSource();
    }

}
