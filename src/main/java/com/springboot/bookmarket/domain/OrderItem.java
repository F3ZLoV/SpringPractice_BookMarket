package com.springboot.bookmarket.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    private Long id;                // 아이디
    private String bookId;          // 주문 도서 아이디
    private int quantity;           // 주문 도서 수량
    private BigDecimal totalPrice;  // 주문 도서 총 가격
}
