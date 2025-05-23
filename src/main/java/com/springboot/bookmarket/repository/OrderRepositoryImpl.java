package com.springboot.bookmarket.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.bookmarket.domain.Order;
import com.springboot.bookmarket.service.OrderProService;

@Repository
public class OrderRepositoryImpl implements OrderRepository{
	private Map<Long, Order> listOfOrders;
	//private long nextOrderId;
	//@Autowired
	//private OrderProService orderProService;	

	public OrderRepositoryImpl() {
		listOfOrders = new HashMap<Long, Order>();
	   // nextOrderId = 2000;  
	    
	}

	public void saveOrder(Order order) {
	    //order.setOrderId(getNextOrderId());
		
	    listOfOrders.put(order.getOrderId(), order);
	   // return order.getOrderId();		
	}

	/*private synchronized long getNextOrderId() {
	      return nextOrderId++;
	}	
	*/
}
