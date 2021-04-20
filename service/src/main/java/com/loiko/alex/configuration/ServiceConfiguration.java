package com.loiko.alex.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.loiko.alex.service")
@Import(DatabaseConfiguration.class)
public class ServiceConfiguration {
}