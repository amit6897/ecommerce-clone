package com.ecommerceClone.orderManagement.repo;

import com.ecommerceClone.orderManagement.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
