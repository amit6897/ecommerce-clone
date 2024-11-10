package com.ecommerceClone.orderManagement.dto;

import com.ecommerceClone.orderManagement.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {
    private Long userId;
    private Double totalAmount;
    private OrderStatus status;
    private AddressDTO shippingAddress;
}
