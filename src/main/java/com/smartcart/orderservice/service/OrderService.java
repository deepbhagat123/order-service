package com.smartcart.orderservice.service;

import com.smartcart.orderservice.dto.ProductResponse;
import com.smartcart.orderservice.model.OrderEntity;
import com.smartcart.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public OrderEntity placeOrder(Long productId, int quantity) {
        try {
            ProductResponse product = restTemplate.getForObject(
                    "http://localhost:8081/products/" + productId,
                    ProductResponse.class
            );

            if (product == null || product.getStockQuantity() < quantity) {
                throw new RuntimeException("Insufficient stock or product not found");
            }

            OrderEntity order = new OrderEntity();
            order.setProductId(productId);
            order.setQuantity(quantity);
            order.setStatus("PLACED");
            return orderRepository.save(order);

        } catch (org.springframework.web.client.HttpClientErrorException e) {
            throw new RuntimeException("Product not found: " + productId);
        }
    }
}