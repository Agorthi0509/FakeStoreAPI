package com.example.product.services;

import com.example.product.DTO.ProductRequestDto;
import com.example.product.DTO.ProductResponseDto;
import com.example.product.exception.ProductDoesnotExistException;
import com.example.product.models.Category;
import com.example.product.models.Product;
import com.example.product.repository.CategoryRepository;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Qualifier("selfStoreProductService")
@Service

public class SelfStoreProductService implements  IProductService{

    ProductRepository productRepository;


    CategoryRepository categoryRepository;

@Autowired
    public  SelfStoreProductService(ProductRepository productRepository,CategoryRepository categoryRepository){
this.productRepository=productRepository;
this.categoryRepository = categoryRepository;
    }


    @Override
    public Product getSingleProduct(Long id) throws InvalidIdException {

        Optional<Product> optionalProduct= productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new InvalidIdException("This no is invalid");
        }
        Product product = optionalProduct.get();
        return product;


    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product updateProduct(Long id, ProductRequestDto productRequestDto) throws ProductDoesnotExistException {
        Product ExistProduct = new Product();
        Product product = new Product();
        product.setId(id);
        product.setName(productRequestDto.getTitle());
        product.setCategory(new Category());
        product.setPrice(productRequestDto.getPrice());
        product.getCategory().setName(productRequestDto.getCategory());
        product.setDescription(productRequestDto.getDescription());


        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isEmpty()){
            throw new ProductDoesnotExistException();
        }

        Product existingProduct = productOptional.get();
        Product updatedProduct = new Product();

        updatedProduct.setId(id);

        updatedProduct.setName(
                product.getName() != null ?
                        product.getName() :
                        existingProduct.getName()
        );

        updatedProduct.setDescription(
                product.getDescription() != null ?
                        product.getDescription() :
                        existingProduct.getDescription()
        );

        updatedProduct.setImage(
                product.getImage() != null ?
                        product.getImage() :
                        existingProduct.getImage()
        );

        updatedProduct.setPrice(
                product.getPrice() > 0 ?
                        product.getPrice() :
                        existingProduct.getPrice()
        );

        Optional<Category> categoryOptional = categoryRepository.findByName(product.getCategory().getName());
        if(categoryOptional.isEmpty()){
            Category categoryToSave = new Category();
            categoryToSave.setName(product.getCategory().getName());
            Category savedCategory = categoryRepository.save(categoryToSave);
            updatedProduct.setCategory(savedCategory);
        } else {
            updatedProduct.setCategory(categoryOptional.get());
        }

        Product savedUpdatedProduct = productRepository.save(updatedProduct);
        return savedUpdatedProduct;
    }

    @Override
    public Product addProduct(Product product) {
        Optional<Category> categoryOptional= categoryRepository.findByName(product.getCategory().getName());  //Optional to check null
        if(categoryOptional.isEmpty())
            {
            //Note - not required after cascading in model - Product
//            Category categoryToSave = new Category();
//            categoryToSave.setName(product.getCategory().getName());  // to save without id
//            Category savedCategory = categoryRepository.save(categoryToSave); // after saving in DB Category with DB
//            product.setCategory(savedCategory);
        }
        else{
            product.setCategory(categoryOptional.get());

        }
        Product savedProduct = productRepository.save(product);

        return savedProduct;
    }
}
