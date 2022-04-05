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
    private Product product;
    private Vendor vendor;
    private int quantity;
    private double subTotal;

    public ItemList(Product product, Vendor vendor, int quantity, double subTotal) {
        this.product = product;
        this.vendor = vendor;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }
}
