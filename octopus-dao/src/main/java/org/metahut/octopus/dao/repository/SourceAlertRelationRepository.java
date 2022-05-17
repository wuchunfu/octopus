package org.metahut.octopus.dao.repository;

import org.metahut.octopus.dao.entity.SourceAlertRelation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SourceAlertRelationRepository  extends JpaRepository<SourceAlertRelation, Integer>, JpaSpecificationExecutor<SourceAlertRelation> {
}
