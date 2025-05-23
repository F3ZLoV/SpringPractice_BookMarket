package com.springboot.bookmarket.repository;

import com.springboot.bookmarket.domain.Order;

public interface OrderRepository {
	
	 void saveOrder(Order order);	   
	
}
