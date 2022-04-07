package com.pm490.PM490.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor

public class Client extends User{
    private String type;

    public Client(String name, String password, UserStatus status, String phone, String email, Role role, String type) {
        super(name, password, status, phone, email, role);
        this.type = type;
    }
}
