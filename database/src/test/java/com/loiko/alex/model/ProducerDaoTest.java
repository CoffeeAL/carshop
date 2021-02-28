package com.loiko.alex.model;

import com.loiko.alex.country.Country;
import com.loiko.alex.producer.Producer;
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

public class ProducerDaoTest {

    //TODO прописать универсальную конфигу в ConnectionUtil и сделать всё по аналогии в остальных тестах
    private static final SessionFactory FACTORY = new Configuration().addAnnotatedClass(Producer.class).configure().buildSessionFactory();

    @AfterClass
    public static void closeFactory() {
        FACTORY.close();
    }

    @Test
    public void checkSaveProducer() {
        @Cleanup Session session = FACTORY.openSession();
        Producer producer = Producer.builder()
                .producerName("Toyo")
                .country(Country.JAPAN)
                .build();
        Serializable id = session.save(producer);
        assertNotNull(id);
    }

    @Test
    public void checkGetProducerById() {
        @Cleanup Session session = FACTORY.openSession();
        Producer producer = Producer.builder()
                .producerName("Michelin")
                .country(Country.GERMANY)
                .build();
        Serializable savedId = session.save(producer);
        assertNotNull(savedId);
        Producer saveProducer = session.find(Producer.class, savedId);
        assertNotNull(saveProducer);
    }

    @Test
    public void checkGetAllProducers() {
        @Cleanup Session session = FACTORY.openSession();
        List<Producer> list =
                session.createQuery("select p from Producer p", Producer.class).list();
        assertTrue(list.size() == 1);
    }
}