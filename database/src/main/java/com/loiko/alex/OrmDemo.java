package com.loiko.alex;

import com.loiko.alex.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OrmDemo {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            Client ivan = new Client("Ivan", "PasswordIvan", "Ivan", 25, "232-434-23", "ivan@gmail.com");
            session.save(ivan);
        }
    }
}