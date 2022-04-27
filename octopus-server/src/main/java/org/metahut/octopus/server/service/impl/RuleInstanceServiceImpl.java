package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.dao.repository.RuleInstanceRepository;
import org.metahut.octopus.metrics.api.AbstractMetricsParameter;
import org.metahut.octopus.metrics.api.JSONUtils;
import org.metahut.octopus.server.service.RuleInstanceService;

import org.springframework.stereotype.Service;

@Service
public class RuleInstanceServiceImpl implements RuleInstanceService {

    private final RuleInstanceRepository ruleInstanceRepository;

    public RuleInstanceServiceImpl(RuleInstanceRepository ruleInstanceRepository) {
        this.ruleInstanceRepository = ruleInstanceRepository;
    }

    public void create() {

        // generate metrics instance unique key
        // use metrics_code, metrics_params, subject_category, subject_code, filter
        String metricsParams = "";
        AbstractMetricsParameter abstractMetricsParameter = JSONUtils.parseObject(metricsParams, AbstractMetricsParameter.class);
        abstractMetricsParameter.setMetricsCode("");
        abstractMetricsParameter.setSubjectCategory("");
        abstractMetricsParameter.setSubjectCode("");
        abstractMetricsParameter.setFilter("");
        String metricsUniqueKey = abstractMetricsParameter.generateUniqueKey();

    }
}
