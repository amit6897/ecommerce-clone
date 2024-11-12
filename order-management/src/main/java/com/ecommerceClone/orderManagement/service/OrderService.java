package com.ecommerceClone.orderManagement.service;

import com.ecommerceClone.orderManagement.dto.OrderRequestDTO;
import com.ecommerceClone.orderManagement.dto.OrderResponseDTO;
import com.ecommerceClone.orderManagement.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<OrderResponseDTO> getAllOrders();

    Optional<OrderResponseDTO> getOrderById(Long id);

    OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO);

    Optional<OrderResponseDTO> updateOrder(Long id, OrderRequestDTO updatedOrderDTO);

    boolean deleteOrder(Long id);

    //boolean validateUser(Long userId);

    //void placeOrder(Long userId, OrderRequestDTO orderRequestDTO);
}
