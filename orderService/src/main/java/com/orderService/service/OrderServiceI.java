package com.orderService.service;

import com.orderService.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderServiceI {
    List<Order> getOrderDetails();
    Optional<Order> getOrder(Long id);
    Optional<Order> getOrder(Long id, String Offer, String productName);
}
