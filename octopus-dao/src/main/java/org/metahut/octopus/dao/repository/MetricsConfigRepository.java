package org.metahut.octopus.dao.repository;

import org.metahut.octopus.dao.entity.MetricsConfig;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MetricsConfigRepository extends JpaRepository<MetricsConfig, Integer>, JpaSpecificationExecutor<MetricsConfig> {
}
