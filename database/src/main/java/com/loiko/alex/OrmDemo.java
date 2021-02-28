package com.loiko.alex;

import com.loiko.alex.user.Client;
import com.loiko.alex.user.role.ClientRole;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OrmDemo {

    public static void main(String[] args) {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(new Client("Vasya", "Oblomov", "uasya@gmail.com", ClientRole.VIP_CLIENT));
        session.getTransaction().commit();
    }
}