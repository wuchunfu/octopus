package org.metahut.octopus.server.service;

import org.metahut.octopus.dao.entity.SampleInstance;

public interface SampleInstanceService {

    SampleInstance findOneByCode(Long sampleCode);
}
