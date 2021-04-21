package com.loiko.alex.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Alexey Loiko
 * @project carshop
 */

@Configuration
@ComponentScan(basePackages = "com.loiko.alex.helper")
@Import(ServiceConfiguration.class)
public class TestConfig {
}
