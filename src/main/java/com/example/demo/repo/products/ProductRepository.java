package com.example.demo.repo.products;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.products.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
