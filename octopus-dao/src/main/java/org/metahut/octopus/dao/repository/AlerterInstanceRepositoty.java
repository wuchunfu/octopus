package org.metahut.octopus.dao.repository;

import org.metahut.octopus.dao.entity.AlerterInstance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AlerterInstanceRepositoty extends JpaRepository<AlerterInstance, Integer>, JpaSpecificationExecutor<AlerterInstance> {
}
