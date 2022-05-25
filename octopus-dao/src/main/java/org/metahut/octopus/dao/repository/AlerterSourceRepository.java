package org.metahut.octopus.dao.repository;

import org.metahut.octopus.dao.entity.AlerterSource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AlerterSourceRepository extends JpaRepository<AlerterSource, Integer>, JpaSpecificationExecutor<AlerterSource> {
}
