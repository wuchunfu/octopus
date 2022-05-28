package org.metahut.octopus.server.service;

import org.metahut.octopus.api.dto.SchedulerCronRequestDTO;

import java.util.Collection;

public interface SchedulerService {

    Collection<String> previewSchedule(SchedulerCronRequestDTO schedulerCronRequestDTO);
}
