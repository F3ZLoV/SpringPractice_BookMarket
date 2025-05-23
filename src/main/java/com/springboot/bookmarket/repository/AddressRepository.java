package com.springboot.bookmarket.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.springboot.bookmarket.domain.Address;
import com.springboot.bookmarket.domain.Customer;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
