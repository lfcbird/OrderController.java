//Author Oyunbold
package com.pm490.PM490.dto;

import com.pm490.PM490.model.Customer;
import com.pm490.PM490.model.PurchaseStatus;
import com.pm490.PM490.model.ShoppingCart;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderCartRequest {


    private LocalDate dateOrdered;
    private LocalDate dateShipped;
    private PurchaseStatus status;
    private Long idCustomer;
    private Long idCart;
}
