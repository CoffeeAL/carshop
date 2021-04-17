package com.loiko.alex.common;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Getter
public abstract class BaseDaoImpl<T extends BaseEntityImpl<U>, U extends Serializable> implements BaseDao<T, U> {

    @Autowired
    protected SessionFactory sessionFactory;

    public abstract Class<T> getEntityClass();

    @Override
    public U save(T model) {
        return (U) sessionFactory.getCurrentSession().save(model);
    }

    public abstract List<T> findAll();

    @Override
    public Optional<T> findById(U id) {
        return Optional.of(sessionFactory.getCurrentSession().find(getEntityClass(), id));
    }

    @Override
    public void update(T model) {
        sessionFactory.getCurrentSession().update(model);
    }

    @Override
    public void delete(T model) {
        sessionFactory.getCurrentSession().delete(model);
    }
}