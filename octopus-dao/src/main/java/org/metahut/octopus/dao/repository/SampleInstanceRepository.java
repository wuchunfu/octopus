package org.metahut.octopus.dao.repository;

import org.metahut.octopus.dao.entity.SampleInstance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SampleInstanceRepository extends JpaRepository<SampleInstance, Integer>, JpaSpecificationExecutor<SampleInstance> {
}