package org.metahut.octopus.dao.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "org.metahut.octopus.dao.repository")
@EntityScan(basePackages = "org.metahut.octopus.dao.entity")
@EnableTransactionManagement
public class DaoConfiguration {
}
