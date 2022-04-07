package com.pm490.PM490.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor

public class OrderCart {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Customer customer;
    @OneToOne
    private ShoppingCart cart;
    private LocalDate dateOrdered;
    private LocalDate dateShipped;
    @Enumerated(EnumType.STRING)
    private PurchaseStatus status;

    public OrderCart(Customer customer, ShoppingCart cart, LocalDate dateOrdered, LocalDate dateShipped, PurchaseStatus status) {
        this.customer = customer;
        this.cart = cart;
        this.dateOrdered = dateOrdered;
        this.dateShipped = dateShipped;
        this.status = status;
    }
}
