package com.foodie.psb_cart.dto;

import java.math.BigDecimal;

public class CartDTO {
    private String id;
    private String name;
    private int quantity;

    // Constructors
    public CartDTO() {}

    public CartDTO(String name, int quantity) {
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