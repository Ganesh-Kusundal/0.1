package com.orderService.model;
import com.orderService.entity.Product;

public class ByOneGetOneOffer implements IOffer {
    @Override
    public Product applyOffer(Product product) {
        product.setPrice(product.getPrice() / 2);
        return product;
    }
}
