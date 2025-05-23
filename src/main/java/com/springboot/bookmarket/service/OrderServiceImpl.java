package com.springboot.bookmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bookmarket.domain.Book;
import com.springboot.bookmarket.domain.Order;
import com.springboot.bookmarket.repository.BookRepository;
import com.springboot.bookmarket.repository.OrderRepository;
@Service
public class OrderServiceImpl implements OrderService{
	
	
	@Autowired
	private BookRepository bookRepository;
		
	@Autowired
	private OrderRepository orderRepository;
		
	
	public void confirmOrder(String bookId, long quantity) {
	   Book bookById = bookRepository.getBookById(bookId);
	   if(bookById.getUnitsInStock() < quantity){
	       throw new IllegalArgumentException("품절입니다. 사용가능한 재고수 :"+ bookById.getUnitsInStock());
	    }
	    bookById.setUnitsInStock(bookById.getUnitsInStock() - quantity);
	}

	public void saveOrder(Order order) {
		orderRepository.saveOrder(order);
	  // Long orderId = orderRepository.saveOrder(order);	 
	  // return orderId;
	}  

}
