package com.pm490.PM490.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Embeddable
public class Vendor extends User{

    //private List<Product> productList = new ArrayList<>();

    public Vendor(String name, String password, UserStatus status, String phone, String email, Role role, Address address) {
        super(name, password, status, phone, email, role, address);
    }
}
