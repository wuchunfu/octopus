package org.metahut.octopus.dao.repository;

import org.metahut.octopus.dao.entity.Metrics;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MetricsRepository extends JpaRepository<Metrics, Integer> {
}
