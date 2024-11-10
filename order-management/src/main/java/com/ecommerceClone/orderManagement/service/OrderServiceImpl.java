package com.ecommerceClone.orderManagement.service;

import com.ecommerceClone.orderManagement.dto.AddressDTO;
import com.ecommerceClone.orderManagement.dto.OrderRequestDTO;
import com.ecommerceClone.orderManagement.dto.OrderResponseDTO;
import com.ecommerceClone.orderManagement.entity.Address;
import com.ecommerceClone.orderManagement.entity.Order;
import com.ecommerceClone.orderManagement.entity.OrderStatus;
import com.ecommerceClone.orderManagement.repo.OrderRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /*
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    */

    @Override
    public List<OrderResponseDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<OrderResponseDTO> getOrderById(Long id) {
        return orderRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO) {
        Order order = convertToEntity(orderRequestDTO);
        order.setOrderDate(new java.util.Date());
        order.setStatus(OrderStatus.PENDING);
        Order savedOrder = orderRepository.save(order);
        return convertToDTO(savedOrder);
    }

    @Override
    public Optional<OrderResponseDTO> updateOrder(Long id, OrderRequestDTO updatedOrderDTO) {
        return orderRepository.findById(id).map(order -> {
            order.setTotalAmount(updatedOrderDTO.getTotalAmount());
            order.setStatus(updatedOrderDTO.getStatus());
            order.setShippingAddress(convertToEntity(updatedOrderDTO.getShippingAddress()));
            return convertToDTO(orderRepository.save(order));
        });
    }

    @Override
    public boolean deleteOrder(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private OrderResponseDTO convertToDTO(Order order) {
        OrderResponseDTO dto = new OrderResponseDTO();
        dto.setId(order.getId());
        dto.setUserId(order.getUserId());
        dto.setOrderDate(order.getOrderDate());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setStatus(order.getStatus());
        dto.setShippingAddress(convertToDTO(order.getShippingAddress()));
        return dto;
    }

    private Order convertToEntity(OrderRequestDTO dto) {
        Order order = new Order();
        order.setUserId(dto.getUserId());
        order.setTotalAmount(dto.getTotalAmount());
        order.setStatus(dto.getStatus());
        order.setShippingAddress(convertToEntity(dto.getShippingAddress()));
        return order;
    }

    private AddressDTO convertToDTO(Address address) {
        AddressDTO dto = new AddressDTO();
        dto.setStreet(address.getStreet());
        dto.setCity(address.getCity());
        dto.setState(address.getState());
        dto.setPostalCode(address.getPostalCode());
        dto.setCountry(address.getCountry());
        return dto;
    }

    private Address convertToEntity(AddressDTO dto) {
        Address address = new Address();
        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setPostalCode(dto.getPostalCode());
        address.setCountry(dto.getCountry());
        return address;
    }
}
