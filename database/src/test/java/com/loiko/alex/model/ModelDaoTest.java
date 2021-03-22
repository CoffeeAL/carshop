package com.loiko.alex.model;

import com.loiko.alex.brand.Brand;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ModelDaoTest {

    private static final SessionFactory FACTORY = new Configuration().addAnnotatedClass(Model.class).configure().buildSessionFactory();

    @AfterClass
    public static void closeFactory() {
        FACTORY.close();
    }

    @Test
    public void checkSaveModel() {
        @Cleanup Session session = FACTORY.openSession();
        CarModel carModel = CarModel.builder().brand(Brand.FORD).model("Mustang").build();
        Model model = Model.builder().carModel(carModel).build();
        Serializable id = session.save(model);
        assertNotNull(id);
    }

    @Test
    public void getModelById() {
        @Cleanup Session session = FACTORY.openSession();
        Model model = Model.builder().build();
        session.save(model);
        assertNotNull(model.getId());
    }

    @Test
    public void doNotGetModelById() {
        @Cleanup Session session = FACTORY.openSession();
        Model model = Model.builder().build();
        assertNull(model.getId());
    }
}