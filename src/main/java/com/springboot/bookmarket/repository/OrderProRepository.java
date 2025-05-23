package com.springboot.bookmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.bookmarket.domain.Order;

@Repository
public interface OrderProRepository extends JpaRepository<Order, Long> {
}
