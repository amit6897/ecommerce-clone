package com.ecommerceClone.orderManagement.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Date orderDate;
    private Double totalAmount;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @Embedded
    private Address shippingAddress;
}
