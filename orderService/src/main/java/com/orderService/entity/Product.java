package com.orderService.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.function.Predicate;

@Data
@AllArgsConstructor
@Builder
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
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
