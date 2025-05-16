package com.springboot.bookmarket.service;

import com.springboot.bookmarket.domain.Cart;
import com.springboot.bookmarket.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    public Cart create(Cart cart) {
        return cartRepository.create(cart);
    }
    public Cart read(String cartId) {
        return cartRepository.read(cartId);
    }
    public void update(String cartId, Cart cart) {
        cartRepository.update(cartId, cart);
    }
}
