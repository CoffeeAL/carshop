package com.loiko.alex.connection;

import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@UtilityClass
public class ConnectionUtil {

    private static final SessionFactory SESSION_FACTORY = new Configuration()
            .configure()
            .buildSessionFactory();

    public SessionFactory getInstance() {
        return SESSION_FACTORY;
    }
}