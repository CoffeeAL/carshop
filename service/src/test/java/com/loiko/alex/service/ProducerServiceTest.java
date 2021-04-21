package com.loiko.alex.service;

import com.loiko.alex.configuration.TestConfig;
import com.loiko.alex.helper.Helper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertTrue;

/**
 * @author Alexey Loiko
 * @project carshop
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@Transactional
public class ProducerServiceTest {

    @Autowired
    private ProducerService producerService;

    @Autowired
    Helper helper;

    @Before
    public void init() {
        helper.cleanDataBase();
        helper.insertingData();
    }

    @Test
    public void checkFindAllProducers() {
        assertTrue(producerService.findAll().size() == 3);
    }
}