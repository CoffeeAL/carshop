package com.loiko.alex.repository;

import com.loiko.alex.order.Order;
import com.loiko.alex.paymentform.PaymentForm;
import com.loiko.alex.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Long>, BaseRepository<Order, Long> {

    List<Order> findByUser(User user);

    List<Order> findByPaymentForm(PaymentForm paymentForm);
}