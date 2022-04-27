package org.metahut.octopus.dao.repository;

import org.metahut.octopus.dao.entity.RuleInstance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleInstanceRepository extends JpaRepository<RuleInstance, Integer> {
}
