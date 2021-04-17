package com.loiko.alex.model;

import com.loiko.alex.TestConfig;
import com.loiko.alex.configuration.DatabaseConfiguration;
import com.loiko.alex.repository.SparePartRepository;
import com.loiko.alex.sparepart.SparePart;
import com.loiko.alex.sparepart.SparePartDaoImpl;
import com.loiko.alex.util.ApplicationSessionFactory;
import com.loiko.alex.util.Helper;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@Transactional
public class SparePartTest {

    @Autowired
    private Helper helper;

    @Autowired
    private EntityManager manager;

    @Autowired
    private SparePartRepository sparePartRepository;

    @Before
    public void init() {
        helper.cleanDataBase();
        helper.insertingData();
    }

    @Test
    public void checkFindAllSpareParts() {
        sparePartRepository.findAll().forEach(System.out::println);
    }



    @Test
    public void checkFindByVendor() {
        Optional<SparePart> vendor = sparePartRepository.findByVendorCode("DHCBJ267");
        Assert.assertTrue(vendor.isPresent());
    }

    @Test
    public void checkContext() {
        assertNotNull(sparePartRepository);
    }
}