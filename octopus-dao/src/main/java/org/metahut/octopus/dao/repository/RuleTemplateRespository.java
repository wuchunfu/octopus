package org.metahut.octopus.dao.repository;

import org.metahut.octopus.dao.entity.RuleTemplate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RuleTemplateRespository extends JpaRepository<RuleTemplate, Integer>, JpaSpecificationExecutor<RuleTemplate> {
}
