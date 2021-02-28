package com.loiko.alex.order;

import com.loiko.alex.common.BaseDaoImpl;

public class OrderDaoImpl extends BaseDaoImpl<Order, Long> implements OrderDao {

    private static final OrderDaoImpl INSTANCE = new OrderDaoImpl();

    public static OrderDaoImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public Class<Order> getEntityClass() {
        return Order.class;
    }
}