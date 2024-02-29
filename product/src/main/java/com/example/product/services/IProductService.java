package com.example.product.services;

import com.example.product.DTO.ProductRequestDto;
import com.example.product.ProductApplication;
import com.example.product.exception.ProductDoesnotExistException;
import com.example.product.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    public Product getSingleProduct(Long id) throws InvalidIdException;
    public List<Product> getAllProducts();
    public Product updateProduct(Long id, ProductRequestDto productRequestDto) throws ProductDoesnotExistException;
    Product addProduct(Product product);



}
