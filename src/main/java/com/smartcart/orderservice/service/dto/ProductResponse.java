
package com.smartcart.orderservice.dto;

public class ProductResponse {
    private Long id;
    private String name;
    private double price;
    private int stockQuantity;

    public Long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }
}