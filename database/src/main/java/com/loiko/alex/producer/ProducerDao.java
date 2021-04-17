package com.loiko.alex.producer;

import com.loiko.alex.common.BaseDao;
import com.loiko.alex.country.Country;
import com.loiko.alex.producer.Producer;

import java.util.List;

public interface ProducerDao extends BaseDao<Producer, Long> {

    List<Producer> findProducersByCountry(Country country);
}