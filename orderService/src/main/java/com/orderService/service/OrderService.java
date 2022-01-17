package com.orderService.service;

import com.orderService.entity.Order;
import com.orderService.entity.Product;
import com.orderService.repository.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements OrderServiceI{
    @Override
    public List<Order> getOrderDetails() {
        List<Order> orderList = OrderRepo.orderList;
        return orderList;
    }

    @Override
    public Optional<Order> getOrder(Long id) {
        return OrderRepo.orderList.stream().filter(order -> order.getId().equals(id)).findFirst();
    }

}
