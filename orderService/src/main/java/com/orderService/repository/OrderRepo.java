package com.orderService.repository;

import com.orderService.entity.Order;
import com.orderService.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderRepo {
    public static List<Order> orderList = new ArrayList<>();

    static {
        List<Product> productList = List.of(
                Product.builder().id(100l).name("Apple").price(60d).quantity(10).build(),
                Product.builder().id(101l).name("Orange").price(25d).quantity(5).build());

        Order order1 = new Order(001l, productList);
        order1.calculateOrderTotal();

        List<Product> productList2 = List.of(
                Product.builder().id(100l).name("Apple").price(60d).quantity(5).build());

        Order order2 = new Order(002l, productList2);
        order2.calculateOrderTotal();

        orderList.add(order1);
        orderList.add(order2);
    }
}
