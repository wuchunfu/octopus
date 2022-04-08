package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.dao.repository.MetricsCategoryRepository;
import org.metahut.octopus.server.service.MetricsCategoryService;
import org.springframework.stereotype.Service;

@Service
public class MetricsCategoryServiceImpl implements MetricsCategoryService {

    private MetricsCategoryRepository metricsCategoryRepository;

    public MetricsCategoryServiceImpl(MetricsCategoryRepository metricsCategoryRepository) {
        this.metricsCategoryRepository = metricsCategoryRepository;
    }


}
