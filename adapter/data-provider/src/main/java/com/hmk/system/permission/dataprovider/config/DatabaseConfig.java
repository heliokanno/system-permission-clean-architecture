package com.hmk.system.permission.dataprovider.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.hmk.system.permission.dataprovider.repository")
@EntityScan("com.hmk.system.permission.dataprovider.entity")
@Configuration
class DatabaseConfig {
}
