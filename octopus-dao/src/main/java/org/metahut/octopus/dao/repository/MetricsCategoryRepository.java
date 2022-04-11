package org.metahut.octopus.dao.repository;

import org.metahut.octopus.dao.entity.MetricsCategory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MetricsCategoryRepository extends JpaRepository<Integer, MetricsCategory> {
}
