package com.pm490.PM490.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor

public class Admin extends User {
    public Admin(String name, String password, UserStatus status, String phone, String email, Role role, Address address) {
        super(name, password, status, phone, email, role, address);
    }
}
