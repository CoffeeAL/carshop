package com.loiko.alex.order;

import com.loiko.alex.common.BaseDao;
import com.loiko.alex.paymentform.PaymentForm;

import java.time.LocalDate;
import java.util.List;

public interface OrderDao extends BaseDao<Orders, Long> {

    List<Orders> findByClient(Long clientId);

    List<Orders> findByDate(LocalDate date);

    List<Orders> findByPaymentForm(PaymentForm form);
}