package com.pm490.PM490.model;

import lombok.*;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Embeddable
public class Product {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String color;
    @ManyToOne
    private Vendor vendor;
    @Enumerated(EnumType.STRING)
    private ProductStatus status;
    private int quantity;
    @ManyToOne
    private Category category;
    private int price;

    public Product(String name, String color, Vendor vendor, int quantity, Category category, int price) {
        this.name = name;
        this.color = color;
        this.vendor = vendor;
        this.quantity = quantity;
        this.category = category;
        this.price = price;
    }
}
