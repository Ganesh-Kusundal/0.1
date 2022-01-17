package com.orderService.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.function.Predicate;

@Data
@AllArgsConstructor
@Builder
public class Product {
    private Long id;
    private String name;
    private Double price;
    private Integer quantity;

    static Predicate<Product> isProduct(String productName) {
        return product -> product.getName().equalsIgnoreCase(productName);
    }

    double calculateProductPrice() {
        return getPrice() * getQuantity();
    }
}
