package org.metahut.octopus.dao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class JpaAuditorConfiguration {

    @Bean
    public AuditorAware<Long> auditorProvider() {
        return new DefaultAuditorAwareImpl();
    }

    public class DefaultAuditorAwareImpl implements AuditorAware<Long> {

        @Override
        public Optional<Long> getCurrentAuditor() {

            return Optional.of(0L);
        }

    }
}

