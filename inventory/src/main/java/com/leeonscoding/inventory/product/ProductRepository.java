package com.leeonscoding.inventory.product;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);
    List<Product> findByNameStartsWithIgnoreCase(String name, Pageable pageable);
}
