package com.springDataJpaMapping.Mapping.config;

import com.springDataJpaMapping.Mapping.auth.AuditAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "getAuditAwareImpl")
public class AppConfig {

    @Bean
    AuditAwareImpl getAuditAwareImpl(){
        return new AuditAwareImpl();
    }
}
