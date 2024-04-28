package com.example.product.controllers;

import com.example.product.DTO.ProductRequestDto;
import com.example.product.exception.ProductDoesnotExistException;
import com.example.product.models.Category;
import com.example.product.repository.ProductRepository;
import com.example.product.services.InvalidIdException;
import com.example.product.models.Product;
import com.example.product.DTO.ProductWrapper;
import com.example.product.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;
//private IProductService productService;
//@Autowired
//public ProductController(@Qualifier("selfStoreProductService") IProductService productService){
//this.productService=productService;
//}


    @PostMapping("/hi")
    public String sayHello(){
        return "Hello";
    }

    //Get All Products
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    //Get single product
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductWrapper> getSingleProduct(@PathVariable("id") Long id) throws InvalidIdException {
        ResponseEntity<ProductWrapper> response;
//        try {
//            Product product= productService.getSingleProduct(id);
//            ProductWrapper productWrapper= new ProductWrapper(product,"All good fellas!!");
//            response = new ResponseEntity<>(productWrapper, HttpStatus.OK);
//
//        } catch (InvalidIdException e) {
//            ProductWrapper productWrapper= new ProductWrapper(null,"All not good fellas!!");
//            response = new ResponseEntity<>(productWrapper,HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return response;

        //Using RestControllerAdvice for exception handling

        Product product= productService.getSingleProduct(id);
        ProductWrapper productWrapper= new ProductWrapper(product,"All good fellas!!");
        response = new ResponseEntity<>(productWrapper, HttpStatus.OK);
        return response;

    }

    //Add product
    @PostMapping("/products")
    public Product addProduct(@RequestBody ProductRequestDto productRequestDto){
        Product product = new Product();
        product.setName(productRequestDto.getTitle());
        product.setCategory(new Category());
        product.setPrice(productRequestDto.getPrice());
        product.getCategory().setName(productRequestDto.getCategory());
        product.setDescription(productRequestDto.getDescription());

    return productService.addProduct(product);
    }
    @PutMapping("/products/{id}")
    public ResponseEntity<ProductWrapper> updateProduct(@PathVariable("id") Long id, @RequestBody ProductRequestDto productRequestDto) throws ProductDoesnotExistException {
        Product product = productService.updateProduct(id,productRequestDto);
        ProductWrapper productWrapper = new ProductWrapper(product,"It is updated!!");
    return new ResponseEntity<>(productWrapper,HttpStatus.OK);
    }
    @DeleteMapping("/products/{id}")
    public boolean deleteProduct(@PathVariable("id") Long id){
        return true;
    }
}

