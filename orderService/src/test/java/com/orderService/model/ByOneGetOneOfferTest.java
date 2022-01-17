package com.orderService.model;

import com.orderService.entity.Order;
import com.orderService.entity.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

class ByOneGetOneOfferTest {
    @Test
    void test_applyOffer() {
        Product product = Product.builder().name("Apples").price(10d).quantity(12).build();
        IOffer offer = new ByOneGetOneOffer();
        assert(offer.applyOffer(product).getPrice() == 5d);
    }
}