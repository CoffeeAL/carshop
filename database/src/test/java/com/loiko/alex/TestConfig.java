package com.loiko.alex;

import com.loiko.alex.configuration.DatabaseConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.loiko.alex.util")
@Import(DatabaseConfiguration.class)
public class TestConfig {
}