package com.loiko.alex.util;

import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

@UtilityClass
public class ApplicationSessionFactory {

    private static final SessionFactory SESSION_FACTORY;

    static {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());
        SESSION_FACTORY = configuration.buildSessionFactory(builder.build());
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}