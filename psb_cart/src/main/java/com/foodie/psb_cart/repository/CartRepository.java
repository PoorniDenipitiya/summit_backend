package com.foodie.psb_cart.repository;

import com.foodie.psb_cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, String> {
   /* List<Cart> findByUserIdAndCartStatus(String userId, String cartStatus);
    Optional<Cart> findByUserIdAndProductIdAndCartStatus(String userId, Long productId, String cartStatus);*/
}