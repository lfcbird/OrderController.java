//Author Oyunbold

package com.pm490.PM490.controller;

import com.pm490.PM490.dto.OrderCartRequest;
import com.pm490.PM490.dto.OrderCartSearchDto;
import com.pm490.PM490.model.OrderCart;
import com.pm490.PM490.model.PurchaseStatus;
import com.pm490.PM490.repository.OrderCartRepository;
import com.pm490.PM490.service.OrderCartService;
import com.pm490.PM490.service.implementation.OrderCartServiceImp;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/order")
public class OrderController {


    @Autowired
    private OrderCartService orderCartService;
    @Autowired
    private OrderCartRepository orderCartRepository;

    @Autowired
    private OrderCartServiceImp orderCartServiceImp;

    @GetMapping()
    public ResponseEntity<?> getAllProduct() {
        return ResponseEntity.ok().body(orderCartRepository.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<?> newOrder(@RequestBody OrderCartRequest orderCartRequest) {
        System.out.println("Service called..");
        System.out.println("Service called..");
        System.out.println("Service called..");
        System.out.println("Service called..");
        System.out.println("Service called..");
        System.out.println("Service called..");
        System.out.println("Service called..");
        System.out.println("Service called..");

        return ResponseEntity.status(HttpStatus.CREATED).body(orderCartService.save(orderCartRequest));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable long id, @RequestBody OrderCartRequest order) {
        OrderCart orders = orderCartService.update(id, order);
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("id") Long id) {
        OrderCart orders = (OrderCart) orderCartServiceImp.searchOrder(id);
        if (orders == null)
            return ResponseEntity.badRequest().body("The data is no order an id equal " + id);
        orderCartServiceImp.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("order is deleted successfully");
    }


}








