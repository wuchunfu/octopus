package org.metahut.octopus.server.service;

import org.metahut.octopus.api.dto.SampleInstanceCreateOrUpdateRequestDTO;
import org.metahut.octopus.dao.entity.SampleInstance;

public interface SampleInstanceService {

    SampleInstance checkSample(SampleInstanceCreateOrUpdateRequestDTO sample);
}
