package com.loiko.alex.model;

import com.loiko.alex.TestConfig;
import com.loiko.alex.country.Country;
import com.loiko.alex.producer.Producer;
import com.loiko.alex.repository.ProducerRepository;
import com.loiko.alex.repository.SparePartRepository;
import com.loiko.alex.sparepart.SparePart;
import com.loiko.alex.util.Helper;
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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@Transactional
public class ProducerTest {

    @Autowired
    private Helper helper;

    @Autowired
    private EntityManager manager;

    @Autowired
    private ProducerRepository producerRepository;

    @Autowired
    private SparePartRepository sparePartRepository;

    @Before
    public void init() {
        helper.cleanDataBase();
        helper.insertingData();
    }

    @Test
    public void checkContext() {
        assertNotNull(producerRepository);
    }

    @Test
    public void checkFindAllProducers() {
        producerRepository.findAll().forEach(System.out::println);
    }

    @Test
    public void checkFindByProducerName() {
        Optional<Producer> toyota = producerRepository.findByProducerName("Toyota");
        assertNotNull(toyota.isPresent());
    }

    @Test
    public void checkFindByProducerNameNativeQuery() {
        Optional<Producer> amcProducer = producerRepository.findByProducerNameNative("AMC");
        assertNotNull(amcProducer.isPresent());
    }

    @Test
    public void checkFindByCountry() {
        List<Producer> producers = producerRepository.findByCountry(Country.JAPAN);
        assertTrue(producers.size() == 1);
    }

    @Test
    public void checkFindByProducerNameAndCountry() {
        Optional<Producer> producer = producerRepository.findByProducerNameAndCountry("Ramsey", Country.FRANCE);
        assertTrue(producer.isPresent());
    }

    @Test
    public void checkSaveAndGetProducer() {
        Producer producer = Producer.builder()
                .producerName("Toyo")
                .country(Country.JAPAN)
                .build();
        Producer savedProducer = producerRepository.save(producer);
        assertNotNull(savedProducer);
        Long producerId = savedProducer.getId();
        manager.detach(producer);
        Optional<Producer> possibleProducer = producerRepository.findById(producerId);
        assertTrue(possibleProducer.isPresent());
    }

    @Test
    public void checkGetProducers() {
        Producer producer = Producer
                .builder()
                .producerName("Aya")
                .country(Country.JAPAN)
                .build();
        producerRepository.save(producer);

        SparePart sparePart = SparePart
                .builder()
                .producer(producer)
                .sparePartName("Engine")
                .build();
        sparePartRepository.save(sparePart);

        manager.refresh(producer);
        assertTrue(producer.getSpareParts().size() == 1);
    }

//    @Test
//    public void checkJavaQuery() {
//        Optional<Producer> amcProducer = producerRepository.customMethod("AMC", "DGVX213");
//        Assert.assertNotNull(amcProducer.isPresent());
//    }
}