package org.metahut.octopus.server.scheduler;

import org.metahut.octopus.scheduler.api.IScheduler;
import org.metahut.octopus.scheduler.api.ISchedulerManager;

import javax.annotation.PreDestroy;

public class SchedulerPluginHelper {

    private final ISchedulerManager schedulerManager;

    public SchedulerPluginHelper(ISchedulerManager schedulerManager) {
        this.schedulerManager = schedulerManager;
    }

    public IScheduler getScheduler() {
        return schedulerManager.getScheduler();
    }

    @PreDestroy
    public void close() throws Exception {
        schedulerManager.close();
    }

}
