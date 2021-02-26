package com.loiko.alex.model;

import com.loiko.alex.user.Admin;
import com.loiko.alex.user.User;
import com.loiko.alex.user.role.AdminRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Ignore;
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
            Serializable id = session.save(new Admin("Ivan123", "Pass123", "vano@gmail.com", 560.3, AdminRole.MAIN_ADMIN));
            assertNotNull(id);
        }
    }

    @Test
    @Ignore
    public void checkGetById() {
        try (Session session = FACTORY.openSession()) {
            Serializable savedId = session.save(new Admin("Ivan456", "Pass456", "vano@gmail.com", 100.0, AdminRole.ADMIN));
            assertNotNull(savedId);
            User saveClient = session.find(User.class, savedId);
            assertNotNull(saveClient);
        }
    }

    @Test
    @Ignore
    public void checkGetAll() {
        try (Session session = FACTORY.openSession()) {
            List<User> list =
                    session.createQuery("select e from Client e", User.class).list();
            System.out.println(list.size());
        }
    }
}