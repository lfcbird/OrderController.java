package com.pm490.PM490.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class ShoppingCart {
    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private OrderCart orderCart;
    @Enumerated(EnumType.STRING)
    private PurchaseStatus status;
    private double total;

    public ShoppingCart(OrderCart orderCart, PurchaseStatus status, double total) {
        this.orderCart = orderCart;
        this.status = status;
        this.total = total;
    }
}
