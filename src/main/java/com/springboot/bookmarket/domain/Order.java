package com.springboot.bookmarket.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id @GeneratedValue
    private Long orderId;                   // 주문 아이디

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;              // 고객 객체

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_id")
    private Shipping shipping;              // 배송지 객체

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_order_id")
    private Map<String,OrderItem> orderItems = new HashMap<>(); // 주문 아이템 객체

    private BigDecimal grandTotal;          // 주문 총 금액
}
