package com.foodie.psb_cart.service;

import com.foodie.psb_cart.dto.CartDTO;
import java.util.List;

public interface CartService {
    CartDTO createCart(CartDTO cartDTO);
    List<CartDTO> getAllCart();
    CartDTO getCartById(String id);
    CartDTO updateCart(String id, CartDTO cartDTO);
    void deleteCart(String id);
}