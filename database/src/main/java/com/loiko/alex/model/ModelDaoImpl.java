package com.loiko.alex.model;

import com.loiko.alex.common.BaseDaoImpl;

public class ModelDaoImpl extends BaseDaoImpl<Model, Long> implements ModelDao {

    private static final ModelDaoImpl INSTANCE = new ModelDaoImpl();

    public static ModelDaoImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public Class<Model> getEntityClass() {
        return Model.class;
    }
}