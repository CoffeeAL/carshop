package com.loiko.alex.util;

import com.loiko.alex.common.BaseEntity;
import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

@UtilityClass
public class ConnectionUtil<T extends BaseEntity> {

    private static final SessionFactory FACTORY;

    static {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());
        FACTORY = configuration.buildSessionFactory(builder.build());
    }

    public static SessionFactory getSessionFactory() {
        return FACTORY;
    }
}