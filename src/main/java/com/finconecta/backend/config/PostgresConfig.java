package com.finconecta.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@EnableR2dbcRepositories(basePackages = "com.finconecta.backend.model.repository")
public class PostgresConfig {

}
