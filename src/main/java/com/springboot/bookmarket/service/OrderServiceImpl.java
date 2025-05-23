package com.springboot.bookmarket.service;

import com.springboot.bookmarket.domain.Book;
import com.springboot.bookmarket.domain.Order;
import com.springboot.bookmarket.repository.BookRepository;
import com.springboot.bookmarket.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private OrderRepository orderRepository;
    public void confirmOrder(String bookId, long quantity) { // 도서 재고 수 처리 메서드
        Book bookById = bookRepository.getBookById(bookId);
        if(bookById.getUnitsInStock() < quantity) {
            throw new IllegalArgumentException("품절입니다. 사용 가능한 재고수:" +
                    bookById.getUnitsInStock());
        }
    }
    public Long saveOrder(Order order) {    // 주문 목록 저장 메서드
        Long orderId = orderRepository.saveOrder(order);
        return orderId;
    }
}
