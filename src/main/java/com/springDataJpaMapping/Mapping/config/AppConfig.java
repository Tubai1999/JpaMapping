package com.springDataJpaMapping.Mapping.config;

import com.springDataJpaMapping.Mapping.auth.AuditAwareImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "getAuditAwareImpl")
public class AppConfig {

    @Bean
    ModelMapper getModelMapper(){
        return new ModelMapper();
    }

    @Bean
    AuditAwareImpl getAuditAwareImpl(){
        return new AuditAwareImpl();
    }

    @Bean
    BCryptPasswordEncoder getEncode(){
        return new BCryptPasswordEncoder();
    }
}
