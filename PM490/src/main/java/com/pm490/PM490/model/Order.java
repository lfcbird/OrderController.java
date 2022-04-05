package com.pm490.PM490.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
//test commit
@Entity
@Data
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Customer customer;
    private LocalDate dateOrdered;
    private LocalDate dateShipped;
    @Enumerated(EnumType.STRING)
    private PurchaseStatus status;
    private ShoppingCart cart;
    private List<ItemList> itemList = new ArrayList<>();

    public Order(Customer customer, LocalDate dateOrdered, LocalDate dateShipped, PurchaseStatus status, ShoppingCart cart, List<ItemList> itemList) {
        this.customer = customer;
        this.dateOrdered = dateOrdered;
        this.dateShipped = dateShipped;
        this.status = status;
        this.cart = cart;
        this.itemList = itemList;
    }
}
