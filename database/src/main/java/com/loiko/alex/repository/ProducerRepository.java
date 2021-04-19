package com.loiko.alex.repository;

import com.loiko.alex.country.Country;
import com.loiko.alex.producer.Producer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ProducerRepository extends CrudRepository<Producer, Long>, CustomProducerRepository {

    //TODO use Optional
    Producer findByProducerName(String producerName);

    List<Producer> findByCountry(Country country);

    //TODO use Optional
    Producer findByProducerNameAndCountry(String name, Country country);
}