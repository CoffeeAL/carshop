package com.loiko.alex.model;

import com.loiko.alex.client.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class ClientDaoTest {

    public static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            int result = session.createQuery("delete from Client").executeUpdate();
            System.out.println(result);
            session.getTransaction().commit();
        }
    }

    @AfterClass
    public static void closeFactory() {
        FACTORY.close();
    }

    @Test
    public void checkSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            Serializable id = session.save(Client.of("Ivan123", "Pass123", "vano@gmail.com"));
            assertNotNull(id);
        }
    }

    @Test
    public void checkGetById() {
        try (Session session = FACTORY.openSession()) {
            Serializable savedId = session.save(Client.of("Ivan456", "Pass456","vano@gmail.com"));
            assertNotNull(savedId);
            Client saveClient = session.find(Client.class, savedId);
            assertNotNull(saveClient);
        }
    }

    @Test
    public void checkGetAll() {
        try (Session session = FACTORY.openSession()) {
            List<Client> list =
                    session.createQuery("select e from Client e", Client.class).list();
            System.out.println(list.size());
        }
    }
}