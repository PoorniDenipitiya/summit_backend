
package com.foodie.psb_cart.serviceimpl;

import com.foodie.psb_cart.dto.CartDTO;
import com.foodie.psb_cart.model.Cart;
import com.foodie.psb_cart.repository.CartRepository;
import com.foodie.psb_cart.service.CartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public CartDTO createCart(CartDTO cartDTO) {
        // Convert DTO to Entity
        Cart cart = new Cart();
        BeanUtils.copyProperties(cartDTO, cart);

        // Generate a UUID for the product ID
        cart.setId(UUID.randomUUID().toString());

        // Save the product
        Cart savedCart = cartRepository.save(cart);

        // Convert saved entity back to DTO
        CartDTO savedCartDTO = new CartDTO();
        BeanUtils.copyProperties(savedCart, savedCartDTO);

        return savedCartDTO;
    }

    @Override
    public List<CartDTO> getAllCart() {
        return cartRepository.findAll().stream()
                .map(cart -> {
                    CartDTO cartDTO = new CartDTO();
                    BeanUtils.copyProperties(cart, cartDTO);
                    return cartDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CartDTO getCartById(String id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        CartDTO cartDTO = new CartDTO();
        BeanUtils.copyProperties(cart, cartDTO);
        return cartDTO;
    }

    @Override
    public CartDTO updateCart(String id, CartDTO cartDTO) {
        Cart existingCart = cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        // Update the existing product
        BeanUtils.copyProperties(cartDTO, existingCart, "id");
        Cart updatedCart = cartRepository.save(existingCart);

        // Convert updated entity back to DTO
        CartDTO updatedCartDTO = new CartDTO();
        BeanUtils.copyProperties(updatedCart, updatedCartDTO);

        return updatedCartDTO;
    }

    @Override
    public void deleteCart(String id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        cartRepository.delete(cart);
    }


}