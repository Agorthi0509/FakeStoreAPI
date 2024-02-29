package com.example.product;

import com.example.product.models.Product;
import com.example.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class ProductApplicationTests {

	@Autowired
	ProductRepository productRepository;
	@Test
	void contextLoads() {
	}
	@Test
	public void getSomeProduct(){
		Optional<Product> optionalProduct= productRepository.findById(1L);
		Product product = optionalProduct.get();
		System.out.println(product.getId()+" "+product.getName());

	}
	@Test
	public void getNameofProduct(){
		Optional<Product> optionalProduct = productRepository.findByName("MacBook");
		Product product = optionalProduct.get();
		System.out.println(product.getId()+" "+product.getName());
	}



}
