package com.loiko.alex;

import com.loiko.alex.configuration.DatabaseConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrmDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfiguration.class);
    }
}