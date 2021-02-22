package com.loiko.alex;

import com.loiko.alex.client.Client;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OrmDemo {

    public static void main(String[] args) {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(Client.of("Ivan", "PasswordIvan", "ivan@gmail.com"));
        session.getTransaction().commit();
    }
}