//Author Oyunbold

package com.pm490.PM490.service.implementation;

import com.pm490.PM490.dto.OrderCartSearchDto;
import com.pm490.PM490.dto.OrderCartRequest;
import com.pm490.PM490.model.Customer;
import com.pm490.PM490.model.OrderCart;
import com.pm490.PM490.model.PurchaseStatus;
import com.pm490.PM490.model.ShoppingCart;
import com.pm490.PM490.repository.CustomerRepository;
import com.pm490.PM490.repository.OrderCartRepository;
import com.pm490.PM490.repository.ShoppingCartRepository;
import com.pm490.PM490.service.OrderCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
    public class OrderCartServiceImp implements OrderCartService {

    @Autowired
    public OrderCartRepository orderCartRepository;

    @Autowired
    public CustomerRepository customerRepository;

    @Autowired
    public ShoppingCartRepository shoppingCartRepository;


    @Override
    public List<OrderCart> showAll() {
        return orderCartRepository.findAll();
    }

    @Override
    public List<OrderCart> searchOrder(Long searchOrder) {
        return orderCartRepository.findAllById(new ArrayList<>(){{add(searchOrder);}});
    }

    @Override
    public List<OrderCart> searchOrderAdvanced(OrderCartSearchDto orderSearchDto) {
        return orderCartRepository.searchOrderAdvanced(orderSearchDto.getDateOrdered(), orderSearchDto.getDateShipped(), orderSearchDto.getIdCustomer(), orderSearchDto.getIdCart());
    }

    @Override
    public OrderCart save(OrderCartRequest newOrder) {

        Customer customer = customerRepository.findById(newOrder.getIdCustomer())
                .orElseThrow(() -> new ResourceNotFoundException("Customer doesn't exist with id :" +newOrder.getIdCustomer()));

        ShoppingCart cart = shoppingCartRepository.findById(newOrder.getIdCart())
                .orElseThrow(() -> new ResourceNotFoundException("Shopping cart doesn't exist with id: " + newOrder.getIdCart()));

        OrderCart order = new OrderCart(customer,
                cart,
                newOrder.getDateOrdered(),
                newOrder.getDateShipped(),
                PurchaseStatus.CREATED
                );

        return orderCartRepository.save(order);
    }

    @Override
    public OrderCart update(long id, OrderCartRequest editedOrder) {
        Optional<OrderCart> optionalOrderCart = Optional.ofNullable(orderCartRepository.findById(id))
                .orElseThrow(() -> new ResourceNotFoundException("Order doesn't exist with id: " + id));
        OrderCart orderCart = optionalOrderCart.get();
        if(optionalOrderCart.isPresent()){
            Customer newCustomer = customerRepository.findById(editedOrder.getIdCustomer())
                    .orElseThrow(() -> new ResourceNotFoundException("Customer doesn't exist with id :" +editedOrder.getIdCustomer()));

            ShoppingCart newCart = shoppingCartRepository.findById(editedOrder.getIdCart())
                    .orElseThrow(() -> new ResourceNotFoundException("Shopping cart doesn't exist with id: " + editedOrder.getIdCart()));
            orderCart.setCustomer(newCustomer);
            orderCart.setCart(newCart);
            orderCart.setDateOrdered(editedOrder.getDateOrdered());
            orderCart.setDateShipped(editedOrder.getDateShipped());
            orderCart.setStatus(editedOrder.getStatus());

            orderCart = orderCartRepository.save(orderCart);
        }
        return orderCart;
    }

    @Override
    public boolean delete(long id) {

        return false;
    }
}
