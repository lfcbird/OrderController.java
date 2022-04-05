package com.pm490.PM490.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Embeddable
public class Category {
    private String name;
    public Category(String name) {
        this.name = name;
    }
}
