package com.pm490.PM490.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor

public class Customer extends User{


    @OneToMany
    private List<Order> orderList = new ArrayList<>();

    public Customer(String name, String password, UserStatus status, String phone, String email, Role role, Address address, Payment payment) {
        super(name, password, status, phone, email, role, address, payment);
    }
}
