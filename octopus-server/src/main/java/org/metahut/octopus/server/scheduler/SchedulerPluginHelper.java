package org.metahut.octopus.server.scheduler;

import org.metahut.octopus.scheduler.api.IScheduler;
import org.metahut.octopus.scheduler.api.ISchedulerManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;

@Configuration
public class SchedulerPluginHelper {

    private final ISchedulerManager schedulerManager;

    public SchedulerPluginHelper(ISchedulerManager schedulerManager) {
        this.schedulerManager = schedulerManager;
    }

    @Bean
    public IScheduler getScheduler() {
        return schedulerManager.getScheduler();
    }

    @PreDestroy
    public void close() throws Exception {
        schedulerManager.close();
    }

}
