package com.loiko.alex.service;

import com.loiko.alex.configuration.ServiceConfiguration;
import com.loiko.alex.country.Country;
import com.loiko.alex.producer.Producer;
import com.loiko.alex.repository.ProducerRepository;
import com.loiko.alex.service.ProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import static org.junit.Assert.assertTrue;

/**
 * @author Alexey Loiko
 * @project carshop
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceConfiguration.class)
@Transactional
public class ProducerServiceTest {

    @Autowired
    private ProducerService producerService;

    @Autowired
    private ProducerRepository producerRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void checkFindAllProducers() {
        //TODO don't create objects in test
        Producer toyota = Producer.builder().producerName("Toyota").country(Country.JAPAN).build();
        Producer volkswagen = Producer.builder().producerName("Volkswagen").country(Country.GERMANY).build();
        Producer ferrari = Producer.builder().producerName("Ferrari").country(Country.ITALY).build();
        producerRepository.save(toyota);
        producerRepository.save(volkswagen);
        producerRepository.save(ferrari);
        entityManager.detach(toyota);
        entityManager.detach(volkswagen);
        entityManager.detach(ferrari);
        assertTrue(producerService.findAll().size() == 3);
    }
}