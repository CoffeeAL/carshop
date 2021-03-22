package com.loiko.alex.common;

import com.querydsl.jpa.impl.JPAQuery;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseDaoImpl<T extends BaseEntity<U>, U extends Serializable> implements BaseDao<T, U> {

    @Autowired
    protected SessionFactory sessionFactory;

    public abstract Class<T> getEntityClass();

    @Override
    public U save(T model) {
        return (U) sessionFactory.getCurrentSession().save(model);
    }

    @Override
    public List<T> findAll() {
        //TODO сделать не через критерию
        CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<T> criteria = criteriaBuilder.createQuery(getEntityClass());
        Root<T> root = criteria.from(getEntityClass());
        criteria.select(root);
        return sessionFactory.getCurrentSession().createQuery(criteria).list();
    }

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