package com.foodie.psb_cart.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
/*import lombok.Data;
import java.time.LocalDateTime;*/

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private String name;


    // Constructors
    public Cart() {
    }

    public Cart(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}

  /*
    @Column(name = "cart_status")
    private String cartStatus = "ACTIVE";

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
*/