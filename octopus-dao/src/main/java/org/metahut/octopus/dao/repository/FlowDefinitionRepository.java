package org.metahut.octopus.dao.repository;

import org.metahut.octopus.dao.entity.FlowDefinition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FlowDefinitionRepository extends JpaRepository<FlowDefinition, Integer>, JpaSpecificationExecutor<FlowDefinition> {

}
