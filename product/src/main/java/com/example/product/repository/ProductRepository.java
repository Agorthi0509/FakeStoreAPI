package com.example.product.repository;

import com.example.product.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findById(Long id);
    Optional<Product> findByName(String name);
    List<Product> findByNameAndPriceGreaterThan(String name,Long price);
    Product save(Product product);

}
