package com.orderService.entity;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void test_calculateOrderTotal() {
        Order order = new Order(1l,
                List.of(Product.builder().name("Apples").price(10d).quantity(12).build()));
        order.calculateOrderTotal();
        assert (order.getOrderTotal() == 120.00d);


    }
}