package com.loiko.alex.model;

import com.loiko.alex.user.Admin;
import com.loiko.alex.user.User;
import com.loiko.alex.user.role.AdminRole;
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

public class AdminDaoTest {

    private static final SessionFactory FACTORY = new Configuration().addAnnotatedClass(Admin.class).configure().buildSessionFactory();

    @AfterClass
    public static void closeFactory() {
        FACTORY.close();
    }

    @Test
    public void checkSaveAdmin() {
        @Cleanup Session session = FACTORY.openSession();
        //TODO Попробовать создать админов и клиентов через билдер
        User admin = new Admin("Ivan123", "Pass123",
                "vano@gmail.com", 560.3, AdminRole.MAIN_ADMIN);
        Serializable id = session.save(admin);
        assertNotNull(id);
    }

    @Test
    public void checkGetAdminById() {
        @Cleanup Session session = FACTORY.openSession();
        Serializable savedId = session.save(new Admin("Ivan456", "Pass456",
                "vano@gmail.com", 100.0, AdminRole.ADMIN));
        assertNotNull(savedId);
        Admin saveAdmin = session.find(Admin.class, savedId);
        assertNotNull(saveAdmin);
    }

    @Test
    public void checkGetAllAdmins() {
        @Cleanup Session session = FACTORY.openSession();
        List<Admin> list =
                session.createQuery("select a from Admin a", Admin.class).list();
        assertTrue(list.size() == 0);
    }
}