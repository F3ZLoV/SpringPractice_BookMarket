package com.springboot.bookmarket.service;

import com.springboot.bookmarket.domain.Order;

public interface  OrderService {
	
	 void confirmOrder(String  bookId, long quantity);
	 void saveOrder(Order order);

}
