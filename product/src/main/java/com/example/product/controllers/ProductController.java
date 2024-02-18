package com.example.product.controllers;

import com.example.product.DTO.ProductRequestDto;
import com.example.product.ProductApplication;
import com.example.product.models.Product;
import com.example.product.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private IProductService productService;


    //Get All Products
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return new ArrayList<>();
    }
    //Get single product
    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id){
        return productService.getSingleProduct(id);

    }

    //Add product
    @PostMapping("/products")
    public Product addProduct(@RequestBody ProductRequestDto productRequestDto){
        return new Product();
    }
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody ProductRequestDto productRequestDto){
        return new Product();
    }
    @DeleteMapping("/products/{id}")
    public boolean updateProduct(@PathVariable("id") Long id){
        return true;
    }
}

