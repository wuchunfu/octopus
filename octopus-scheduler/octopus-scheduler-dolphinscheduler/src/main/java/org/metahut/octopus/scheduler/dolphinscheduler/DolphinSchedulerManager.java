package org.metahut.octopus.scheduler.dolphinscheduler;

import org.metahut.octopus.scheduler.api.SchedulerManager;
import org.metahut.octopus.scheduler.api.SchedulerProperties;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "octopus.scheduler", name = "type", havingValue = "DOLPHINSCHEDULER")
public class DolphinSchedulerManager implements SchedulerManager {

    private SchedulerProperties.DolphinScheduler dolphinSchedulerProperties;

    private final DolphinScheduler dolphinScheduler;

    public DolphinSchedulerManager(SchedulerProperties.DolphinScheduler dolphinSchedulerProperties) {
        this.dolphinSchedulerProperties = dolphinSchedulerProperties;

        dolphinScheduler = null;
    }

    @Override
    public DolphinScheduler getScheduler() {
        return dolphinScheduler;
    }

}
