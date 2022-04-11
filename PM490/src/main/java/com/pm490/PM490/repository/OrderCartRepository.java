//Author Oyunbold
package com.pm490.PM490.repository;

import com.pm490.PM490.model.OrderCart;
import com.pm490.PM490.model.Product;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface OrderCartRepository extends JpaRepository<OrderCart, Long> {

//    @Query("select o from OrderCart o where o.name like %:searchPro%")
//    List<OrderCart> searchOrder(@Param("searchOrderById") Long searchOrder);

    @Query("select o from OrderCart o where o.dateOrdered=:orderedDate " +
            "and o.dateShipped=:shippedDate and o.customer=:idCustomer and o.cart=:idShoppingCart")
    List<OrderCart> searchOrderAdvanced(@Param("orderedDate") LocalDate dateOrdered,
                                        @Param("shippedDate") LocalDate dateShipped,
                                        @Param("idCustomer") long idCustomer,
                                        @Param("idShoppingCart") long idCart);

}
