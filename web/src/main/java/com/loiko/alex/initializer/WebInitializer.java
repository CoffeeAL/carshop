package com.loiko.alex.initializer;

import com.loiko.alex.configuration.DatabaseConfiguration;
import com.loiko.alex.configuration.SecurityConfiguration;
import com.loiko.alex.configuration.ServiceConfiguration;
import com.loiko.alex.configuration.WebConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.annotation.Nullable;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    private static final String SERVLET_MAPPING = "/";

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ServiceConfiguration.class, SecurityConfiguration.class, DatabaseConfiguration.class};
    }

    @Nullable
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfiguration.class};
    }

    protected String[] getServletMappings() {
        return new String[]{SERVLET_MAPPING};
    }
}