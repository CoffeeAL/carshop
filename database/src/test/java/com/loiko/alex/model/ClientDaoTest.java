package com.loiko.alex.model;

import com.loiko.alex.user.Client;
import com.loiko.alex.user.User;
import com.loiko.alex.user.role.ClientRole;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.Test;

import java.io.Serializable;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ClientDaoTest {

    public static final SessionFactory FACTORY = new Configuration().addAnnotatedClass(Client.class).configure().buildSessionFactory();

    @AfterClass
    public static void closeFactory() {
        FACTORY.close();
    }

    @Test
    public void checkSaveClient() {
        @Cleanup Session session = FACTORY.openSession();
        User client = new Client("Login", "password", "test@gmail.com",
                ClientRole.ORDINARY_CLIENT);
        assertNotNull(client);
        Serializable id = session.save(client);
        assertNotNull(id);
    }

    @Test
    public void checkGetClientById() {
        @Cleanup Session session = FACTORY.openSession();
        Serializable savedId = session.save(new Client("Login", "password", "test@gmail.com",
                ClientRole.ORDINARY_CLIENT));
        assertNotNull(savedId);
        Client saveUser = session.find(Client.class, savedId);
        assertNotNull(saveUser);
    }

    @Test
    public void checkGetAllClients() {
        @Cleanup Session session = FACTORY.openSession();
        List<User> list =
                session.createQuery("select e from Client e", User.class).list();
        assertTrue(list.size() == 0);
    }
}