package com.ecommerceClone.orderManagement.dto;

import com.ecommerceClone.orderManagement.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDTO {
    private Long id;
    private Long userId;
    private Date orderDate;
    private Double totalAmount;
    private OrderStatus status;
    private AddressDTO shippingAddress;
}
