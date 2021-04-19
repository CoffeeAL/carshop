package com.loiko.alex.repository;

import com.loiko.alex.order.Orders;
import com.loiko.alex.paymentform.PaymentForm;
import com.loiko.alex.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Orders, Long> {

    List<Orders> findByClient(User user);

    List<Orders> findByPaymentForm(PaymentForm paymentForm);
}