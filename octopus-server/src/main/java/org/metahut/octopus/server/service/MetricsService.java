package org.metahut.octopus.server.service;

import org.metahut.octopus.dao.entity.Metrics;

import java.util.List;

public interface MetricsService {

    List<Metrics> findAll();
}
