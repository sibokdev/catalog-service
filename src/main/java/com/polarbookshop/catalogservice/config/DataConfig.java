package com.polarbookshop.catalogservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

@Configuration // Indicates a class as a source of Spring configuration
@EnableJdbcAuditing // Enables auditing for persistent entities
public class DataConfig {
}
