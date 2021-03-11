package com.loiko.alex.order;

import com.loiko.alex.common.BaseDao;
import com.loiko.alex.paymentform.PaymentForm;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;

public interface OrderDao extends BaseDao<Order, Long> {

    List<Order> findByClient(Session session, Long clientId);

    List<Order> findByDate(Session session, LocalDate date);

    List<Order> findByPaymentForm(Session session, PaymentForm form);
}