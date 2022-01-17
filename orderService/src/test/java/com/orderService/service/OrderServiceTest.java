package com.orderService.service;

import com.orderService.entity.Order;
import com.orderService.repository.OrderRepo;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    @Test
    public void test_getOrderDetails() {
        OrderService orderService = new OrderService();
        assertEquals(orderService.getOrderDetails(), OrderRepo.orderList);
    }

    @Test
    public void test_getOrder() {
        OrderService orderService = new OrderService();
        Optional<Order> order = orderService.getOrder(001l);
        assertEquals(order.get().getProductList().get(0), OrderRepo.orderList.get(0).getProductList().get(0));
    }

    @Test
    public void test_getOrderWithOffer() {
        OrderService orderService = new OrderService();
        Optional<Order> order = orderService.getOrder(001l, "Apple", "ByOneGetOneFree");
        assertEquals(order.get().getOrderTotal(), 425d);
    }
}