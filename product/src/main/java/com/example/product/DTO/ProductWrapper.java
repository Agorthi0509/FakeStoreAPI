package com.example.product.DTO;

import com.example.product.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductWrapper {
    Product product;
    String message;

    public ProductWrapper(Product product, String s) {
        this.product= product;
        this.message= s;
    }
}