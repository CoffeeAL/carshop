package com.loiko.alex.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.loiko.alex.service", "com.loiko.alex.converter"})
@Import(DatabaseConfiguration.class)
public class ServiceConfiguration {
}