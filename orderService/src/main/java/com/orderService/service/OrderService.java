package com.orderService.service;

import com.orderService.entity.Order;
import com.orderService.model.OfferFactory;
import com.orderService.repository.OrderRepo;
import com.orderService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class OrderService implements OrderServiceI {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getOrderDetails() {
        List<Order> rt = new ArrayList<>();
        orderRepository.findAll().forEach(order -> rt.add(order));
        return rt;
    }

    @Override
    public Optional<Order> getOrder(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Optional<Order> getOrder(Long id, String productName, String offerName) {
        List<Order> rt = new ArrayList<>();
        orderRepository.findAll().forEach(order -> rt.add(order));
        return rt.stream()
                .filter(isOrder(id))
                .map(order ->
                {
                    order.applyOffer(OfferFactory.getOfferInstance(offerName), productName);
                    order.calculateOrderTotal();
                    return order;
                })
                .findFirst();
    }

    private Predicate<Order> isOrder(Long id) {
        return order -> order.getId().equals(id);
    }

}
