package com.loiko.alex.order;

import com.loiko.alex.common.BaseDaoImpl;
import com.loiko.alex.paymentform.PaymentForm;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderDaoImpl {

//    private static final QOrder ORDER = QOrder.order;
//    private final Session SESSION = sessionFactory.getCurrentSession();
//    private static final OrderDaoImpl INSTANCE = new OrderDaoImpl();
//
//    public static OrderDaoImpl getInstance() {
//        return INSTANCE;
//    }
//
//    @Override
//    public Class<Order> getEntityClass() {
//        return Order.class;
//    }
//
//    @Override
//    public List<Order> findAll() {
//        return new JPAQuery<Order>(SESSION)
//                .select(ORDER)
//                .from(ORDER)
//                .fetch();
//    }
//
//    @Override
//    public List<Order> findByClient(Long clientId) {
//        return new JPAQuery<Order>(SESSION)
//                .select(ORDER)
//                .from(ORDER)
//                .where(ORDER.client.id.eq(clientId))
//                .fetch();
//    }
//
//    @Override
//    public List<Order> findByDate(LocalDate date) {
//        return new JPAQuery<Order>(SESSION)
//                .select(ORDER)
//                .from(ORDER)
//                .where(ORDER.date.eq(date))
//                .fetch();
//    }
//
//    @Override
//    public List<Order> findByPaymentForm(PaymentForm form) {
//        return new JPAQuery<Order>(SESSION)
//                .select(ORDER)
//                .from(ORDER)
//                .where(ORDER.paymentForm.eq(form))
//                .fetch();
//    }
}