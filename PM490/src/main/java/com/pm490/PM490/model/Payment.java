package com.pm490.PM490.model;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor

public class Payment {
    @Id
    @GeneratedValue
    private long id;
    private String type;
    private String fullname;
    private long number;
    private LocalDate expireDate;
    private int cvv;
    private int zipcode;

    public Payment(String type, String fullname, long number, LocalDate expireDate, int cvv, int zipcode) {
        this.type = type;
        this.fullname = fullname;
        this.number = number;
        this.expireDate = expireDate;
        this.cvv = cvv;
        this.zipcode = zipcode;
    }
}
