package com.orderService.entity;

import com.orderService.model.IOffer;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@ToString
@Entity
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @OneToMany(targetEntity=Product.class, mappedBy="id", fetch= FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Product> productList;
    private Double orderTotal;

    public Order(Long id, List<Product> productList) {
        this.id = id;
        this.productList = productList;
        this.orderTotal = 0d;
    }

    public void calculateOrderTotal() {
        orderTotal=  productList.stream().
                mapToDouble(Product::calculateProductPrice).sum();
    }

    public void applyOffer(IOffer offer, String productName) {
        this.getProductList().stream()
                .filter(Product.isProduct(productName))
                .forEach(offer::applyOffer);
    }
}
