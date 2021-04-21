package com.loiko.alex.service;

import com.loiko.alex.producer.Producer;
import com.loiko.alex.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey Loiko
 * @project carshop
 */
@Service
@Transactional(readOnly = true)
public class ProducerService {

    private ProducerRepository producerRepository;

    @Autowired
    public ProducerService(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    public List<Producer> findAll() {
        List<Producer> producers = new ArrayList<>();
        producerRepository.findAll().forEach(producers::add);
        return producers;
    }
}