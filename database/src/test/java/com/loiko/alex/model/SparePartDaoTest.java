package com.loiko.alex.model;

import com.loiko.alex.country.Country;
import com.loiko.alex.producer.Producer;
import com.loiko.alex.sparepart.SparePart;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.Test;

import java.io.Serializable;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SparePartDaoTest {

    private static final SessionFactory FACTORY = new Configuration().addAnnotatedClass(SparePart.class).configure().buildSessionFactory();

    @AfterClass
    public static void closeFactory() {
        FACTORY.close();
    }

    @Test
    public void checkSaveSparePart() {
        @Cleanup Session session = FACTORY.openSession();
        SparePart sparePart = SparePart.builder().sparePartName("Tyre").build();
        Serializable id = session.save(sparePart);
        assertNotNull(id);
    }

    @Test
    public void getSparePartById() {
        @Cleanup Session session = FACTORY.openSession();
        SparePart sparePart = SparePart.builder().sparePartName("Wheel").build();
        Serializable id = session.save(sparePart);
        assertNotNull(session.find(SparePart.class, id));
    }

    @Test
    public void getSparePartByVendorCode() {
        @Cleanup Session session = FACTORY.openSession();
        SparePart sparePart = SparePart.builder().sparePartName("Engine").vendorCode("abc123def").build();
        session.save(sparePart);
        String vendorCode = sparePart.getVendorCode();
        String vendorCodeForAssert = session.find(SparePart.class, vendorCode).getVendorCode();
        assertTrue(vendorCodeForAssert == vendorCode);
    }
}