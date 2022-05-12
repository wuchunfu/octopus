package org.metahut.octopus.dao.repository;

import org.metahut.octopus.dao.entity.RuleInstance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RuleInstanceRespository extends JpaRepository<RuleInstance, Integer>, JpaSpecificationExecutor<RuleInstance> {
}
