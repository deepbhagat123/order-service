package com.smartcart.orderservice.service;

import com.smartcart.orderservice.model.OrderEntity;
import com.smartcart.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderEntity placeOrder(Long productId, int quantity) {
        OrderEntity order = new OrderEntity();
        order.setProductId(productId);
        order.setQuantity(quantity);
        order.setStatus("PLACED");
        return orderRepository.save(order);
    }
}