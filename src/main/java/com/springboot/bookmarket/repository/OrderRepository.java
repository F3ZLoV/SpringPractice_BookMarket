package com.springboot.bookmarket.repository;

import com.springboot.bookmarket.domain.Order;

public interface OrderRepository {
    Long saveOrder(Order order);
}
