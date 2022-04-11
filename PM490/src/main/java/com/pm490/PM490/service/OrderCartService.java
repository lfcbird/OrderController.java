//Author Oyunbold

package com.pm490.PM490.service;

import com.pm490.PM490.dto.OrderCartSearchDto;

import com.pm490.PM490.dto.OrderCartRequest;
import com.pm490.PM490.model.OrderCart;


import java.util.List;

public interface OrderCartService {

    List<OrderCart> showAll();
    List<OrderCart> searchOrder(Long searchOrder);
    List<OrderCart> searchOrderAdvanced(OrderCartSearchDto orderSearchDto);
    OrderCart save(OrderCartRequest order);
    OrderCart update(long id, OrderCartRequest order);
    boolean delete(long id);

}
