package com.springboot.bookmarket.service;

import com.springboot.bookmarket.domain.Order;
import com.springboot.bookmarket.repository.OrderProRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class OrderProService {
    @Autowired
    private OrderProRepository orderProRepository;

    public void save(Order order) {
        orderProRepository.save(order);
    }

    public Page<Order> listAll(int pageNum, String sortField, String sortDir) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(
                pageNum - 1, pageSize,
                sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending());
        return orderProRepository.findAll(pageable);
    }

    public Order get(Long id) {
        return orderProRepository.findById(id).get();
    }

    public void delete(Long id) {
        orderProRepository.deleteById(id);
    }

    public void deleteAll() {
        orderProRepository.deleteAll();
    }
}
