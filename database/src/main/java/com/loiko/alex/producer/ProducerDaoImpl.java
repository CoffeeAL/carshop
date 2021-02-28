package com.loiko.alex.producer;

import com.loiko.alex.common.BaseDaoImpl;

public class ProducerDaoImpl extends BaseDaoImpl<Producer, Long> implements ProducerDao {

    private static final ProducerDaoImpl INSTANCE = new ProducerDaoImpl();

    public static ProducerDaoImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public Class<Producer> getEntityClass() {
        return Producer.class;
    }
}