package com.loiko.alex.repository;

import com.loiko.alex.producer.Producer;

import java.util.List;

public interface CustomProducerRepository {

    List<Producer> findByCriteriaApi(String name);
}