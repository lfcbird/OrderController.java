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
    private Order order;
    private PurchaseStatus status;
    private double total;
    @OneToMany
    private List<ItemList> itemList = new ArrayList<>();

    public ShoppingCart(Order order, PurchaseStatus status, double total) {

        this.order = order;
        this.status = status;
        this.total = total;
    }
}
