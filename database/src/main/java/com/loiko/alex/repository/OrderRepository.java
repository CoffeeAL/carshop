package com.loiko.alex.repository;

import com.loiko.alex.order.Order;
import com.loiko.alex.paymentform.PaymentForm;
import com.loiko.alex.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByClient(User user);

    List<Order> findByPaymentForm(PaymentForm paymentForm);
}