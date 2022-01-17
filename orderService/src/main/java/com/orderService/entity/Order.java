package com.orderService.entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Order {
    private Long id;
    private List<Product> productList;
    private Double orderTotal;

    public Order(Long id, List<Product> productList) {
        this.id = id;
        this.productList = productList;
        this.orderTotal = 0d;
    }

    public void calculateOrderTotal() {
        orderTotal=  productList.stream().
                mapToDouble(product -> product.getPrice() * product.getQuantity()).sum();
    }
}
