package com.loiko.alex.common;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseDao<T extends BaseEntity<U>, U extends Serializable> {

    U save(Session session, T model);

    List<T> findAll(Session session);

    Optional<T> findById(Session session, U id);

    void update(Session session, T model);

    void delete(Session session, T model);
}