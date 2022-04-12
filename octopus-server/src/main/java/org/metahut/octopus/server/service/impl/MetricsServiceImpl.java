package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.dao.entity.Metrics;
import org.metahut.octopus.dao.repository.MetricsRepository;
import org.metahut.octopus.server.service.MetricsService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetricsServiceImpl implements MetricsService {

    private MetricsRepository metricsRepository;

    public MetricsServiceImpl(MetricsRepository metricsRepository) {
        this.metricsRepository = metricsRepository;
    }

    @Override
    public List<Metrics> findAll() {
        return metricsRepository.findAll();
    }
}
