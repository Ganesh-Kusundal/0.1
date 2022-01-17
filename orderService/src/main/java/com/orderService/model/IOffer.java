package com.orderService.model;

import com.orderService.entity.Order;
import com.orderService.entity.Product;

public interface IOffer {
    Product applyOffer(Product product);
}
