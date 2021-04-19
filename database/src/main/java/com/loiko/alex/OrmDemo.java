package com.loiko.alex;

import com.loiko.alex.configuration.DatabaseConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrmDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfiguration.class);
//        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        @Cleanup Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        session.save(new Client("Vasya", "Oblomov", "uasya@gmail.com", ClientRole.VIP_CLIENT));
//        session.getTransaction().commit();
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfiguration.class);
//        System.out.println();
    }
}