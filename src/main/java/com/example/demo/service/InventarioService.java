package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.products.Product;
import com.example.demo.repo.products.ProductRepository;

@Service
public class InventarioService {

    private final ProductRepository repo;

    public InventarioService(ProductRepository repo) {
        this.repo = repo;
    }

    @Transactional("txProducts")
    public void descontarStock(Long productId, int cantidad) {
        Product product = repo.findById(productId)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        if(product.getStock() < cantidad) {
            throw new RuntimeException("Stock insuficiente");
        }

        product.setStock(product.getStock() - cantidad);
        repo.save(product);
    }

}
