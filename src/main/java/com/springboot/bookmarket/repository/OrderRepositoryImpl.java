package com.springboot.bookmarket.repository;

import com.springboot.bookmarket.domain.Order;
import com.springboot.bookmarket.domain.OrderItem;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private Map<Long, Order> listOfOrders;
    private long nextOrderId;
    public OrderRepositoryImpl() {
        listOfOrders = new HashMap<Long, Order>();
        nextOrderId = 2000;
    }
    public Long saveOrder(Order order) {                // 주문 목록 저장
        order.setOrderId(getNextOrderId());
        listOfOrders.put(order.getOrderId(), order);
        return order.getOrderId();
    }
    private synchronized long getNextOrderId() {        // 주문 아이디 생성
        return nextOrderId++;
    }

}
