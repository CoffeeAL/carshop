package com.loiko.alex.order;

import com.loiko.alex.common.BaseDaoImpl;
import com.loiko.alex.paymentform.PaymentForm;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

public class OrderDaoImpl extends BaseDaoImpl<Order, Long> implements OrderDao {

    private static final OrderDaoImpl INSTANCE = new OrderDaoImpl();

    public static OrderDaoImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public Class<Order> getEntityClass() {
        return Order.class;
    }

    @Override
    public List<Order> findByClient(Session session, Long clientId) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Order> criteria = criteriaBuilder.createQuery(Order.class);
        Root<Order> root = criteria.from(Order.class);
        criteria.select(root)
                .where(criteriaBuilder.equal(root.get(Order_.client), clientId));
        return session.createQuery(criteria).list();
    }

    @Override
    public List<Order> findByDate(Session session, LocalDate date) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Order> criteria = criteriaBuilder.createQuery(Order.class);
        Root<Order> root = criteria.from(Order.class);
        criteria.select(root)
                .where(criteriaBuilder.equal(root.get(Order_.date), date));
        return session.createQuery(criteria).list();
    }

    @Override
    public List<Order> findByPaymentForm(Session session, PaymentForm form) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Order> criteria = criteriaBuilder.createQuery(Order.class);
        Root<Order> root = criteria.from(Order.class);
        criteria.select(root)
                .where(criteriaBuilder.equal(root.get(Order_.paymentForm), form));
        return session.createQuery(criteria).list();
    }
}