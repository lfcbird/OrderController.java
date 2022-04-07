package com.pm490.PM490.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class ItemList {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private ShoppingCart cart;
    @ManyToOne
    private Product product;
    private int quantity;
    private double subTotal;

    public ItemList(ShoppingCart cart, Product product, int quantity, double subTotal) {
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }
}
