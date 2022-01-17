package com.orderService.entity;

import com.orderService.model.ByOneGetOneOffer;
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

    @Test
    void test_applyOffer() {
        Order order = new Order(1l,
                List.of(Product.builder().name("Apples").price(10d).quantity(12).build(),
                        Product.builder().id(101l).name("Orange").price(10d).quantity(5).build()));
        order.applyOffer(new ByOneGetOneOffer(), "Apples");
        order.calculateOrderTotal();
        assert (order.getOrderTotal() == 110.00d);
    }


}