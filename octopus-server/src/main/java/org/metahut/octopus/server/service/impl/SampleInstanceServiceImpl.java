package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.SampleInstanceCreateOrUpdateRequestDTO;
import org.metahut.octopus.dao.entity.SampleInstance;
import org.metahut.octopus.dao.repository.SampleInstanceRepository;
import org.metahut.octopus.server.service.SampleInstanceService;
import org.metahut.octopus.server.utils.Assert;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.metahut.octopus.common.enums.StatusEnum.SAMPLE_INSTANCE_NOT_EXIST;

@Service
public class SampleInstanceServiceImpl implements SampleInstanceService {

    private final SampleInstanceRepository sampleInstanceRepository;

    public SampleInstanceServiceImpl(SampleInstanceRepository sampleInstanceRepository) {
        this.sampleInstanceRepository = sampleInstanceRepository;
    }

    @Override
    public SampleInstance checkSample(SampleInstanceCreateOrUpdateRequestDTO sample) {
        SampleInstance sampleInstance = new SampleInstance();
        sampleInstance.setCode(sample.getCode());
        Optional<SampleInstance> optional = sampleInstanceRepository.findOne(Example.of(sampleInstance));
        Assert.notPresent(optional, SAMPLE_INSTANCE_NOT_EXIST, sample.getCode());
        SampleInstance sampleDB = optional.get();
        if (sampleDB.getParameter().equals(sample.getParameter())) {
            return sampleDB;
        }
        sampleDB.setParameter(sample.getParameter());
        return sampleDB;
    }
}
