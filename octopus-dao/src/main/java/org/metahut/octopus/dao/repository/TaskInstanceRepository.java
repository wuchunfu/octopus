package org.metahut.octopus.dao.repository;

import org.metahut.octopus.dao.entity.TaskInstance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TaskInstanceRepository extends JpaRepository<TaskInstance, Integer>, JpaSpecificationExecutor<TaskInstance> {

}
