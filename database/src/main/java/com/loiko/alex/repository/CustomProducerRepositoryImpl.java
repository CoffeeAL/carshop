package com.loiko.alex.repository;

import com.loiko.alex.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class CustomProducerRepositoryImpl implements CustomProducerRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Producer> findByCriteriaApi(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        return null;
    }
}