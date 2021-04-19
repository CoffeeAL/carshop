package com.loiko.alex.model;

import com.loiko.alex.TestConfig;
import com.loiko.alex.carbody.CarBody;
import com.loiko.alex.engine.EngineType;
import com.loiko.alex.repository.ModelRepository;
import com.loiko.alex.util.Helper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@Transactional
public class ModelTest {

    @Autowired
    private Helper helper;

    @Autowired
    private EntityManager manager;

    @Autowired
    private ModelRepository modelRepository;

    @Before
    public void init() {
        helper.cleanDataBase();
        helper.insertingData();
    }

    @Test
    public void checkContext() {
        assertNotNull(modelRepository);
    }

    @Test
    public void checkFindAllModels() {
        modelRepository.findAll().forEach(System.out::println);
    }

    @Test
    public void checkFindById() {
        Optional<Model> modelWithId = modelRepository.findById(1L);
        Assert.assertNotNull(modelWithId.isPresent());
    }

    @Test
    public void checkFindByBodyType() {
        List<Model> hatch = modelRepository.findByCarBody(CarBody.HATCHBACK);
        assertTrue(hatch.size() == 1);
    }

    @Test
    public void checkFindByEngineType() {
        List<Model> petrol = modelRepository.findByEngineType(EngineType.PETROL);
        assertTrue(petrol.size() == 2);
    }
}