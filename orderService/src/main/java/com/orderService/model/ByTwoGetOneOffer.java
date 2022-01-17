package com.orderService.model;

import com.orderService.entity.Product;

public class ByTwoGetOneOffer implements IOffer {
    @Override
    public Product applyOffer(Product product) {
        product.setPrice(product.getPrice() * 0.6);
        return product;
    }
}
