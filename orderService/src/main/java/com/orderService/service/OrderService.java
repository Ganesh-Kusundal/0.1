package com.orderService.service;

import com.orderService.entity.Order;
import com.orderService.model.OfferFactory;
import com.orderService.repository.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class OrderService implements OrderServiceI{
    @Override
    public List<Order> getOrderDetails() {
        List<Order> orderList = OrderRepo.orderList;
        return orderList;
    }

    @Override
    public Optional<Order> getOrder(Long id) {
        return OrderRepo.orderList.stream().filter(isOrder(id)).findFirst();
    }

    @Override
    public Optional<Order> getOrder(Long id, String productName, String offerName) {
        return OrderRepo.orderList.stream()
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
