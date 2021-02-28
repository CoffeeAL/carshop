package com.loiko.alex.common;

import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseDaoImpl<T extends BaseEntity<U>, U extends Serializable> implements BaseDao<T, U> {

    public abstract Class<T> getEntityClass();

    @Override
    public U save(Session session, T model) {
        return (U) session.save(model);
    }

    @Override
    public List<T> findAll(Session session) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = criteriaBuilder.createQuery(getEntityClass());
        Root<T> root = criteria.from(getEntityClass());
        criteria.select(root);
        return session.createQuery(criteria).list();
    }

    @Override
    public Optional<T> findById(Session session, U id) {
        return Optional.of(session.find(getEntityClass(), id));
    }

    @Override
    public void update(Session session, T model) {
        session.update(model);
    }

    @Override
    public void delete(Session session, T model) {
        session.delete(model);
    }
}