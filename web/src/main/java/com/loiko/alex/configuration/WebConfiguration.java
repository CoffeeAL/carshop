package com.loiko.alex.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = "com.loiko.alex.controller")
@EnableWebMvc
@Import({ThymeleafConfiguration.class, InternationalizationConfiguration.class})
public class WebConfiguration implements WebMvcConfigurer {
}