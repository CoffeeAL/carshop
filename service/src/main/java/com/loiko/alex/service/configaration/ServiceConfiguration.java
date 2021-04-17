package com.loiko.alex.service.configaration;

import com.loiko.alex.configuration.DatabaseConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.loiko.alex")
@Import(DatabaseConfiguration.class)
public class ServiceConfiguration {
}