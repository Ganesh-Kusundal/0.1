package com.orderService.controller;

import com.orderService.entity.Order;
import com.orderService.service.OrderService;
import com.orderService.service.OrderServiceI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @GetMapping(value = "/orders")
    public List<Order> order() {
        OrderServiceI orderServiceI = new OrderService();
        return orderServiceI.getOrderDetails();
    }

    @GetMapping(value = "/orders/{id}")
    @ResponseBody
    public Order order(@PathVariable String id) {
        OrderServiceI orderServiceI = new OrderService();
        Optional<Order> order = orderServiceI.getOrder(Long.parseLong(id));
        if (order.isPresent())
            return order.get();
        return null;
    }
}
