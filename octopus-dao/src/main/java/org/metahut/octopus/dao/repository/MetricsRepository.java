package org.metahut.octopus.dao.repository;

import org.metahut.octopus.dao.entity.Metrics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MetricsRepository extends JpaRepository<Metrics, Integer>, JpaSpecificationExecutor<Metrics> {
}
