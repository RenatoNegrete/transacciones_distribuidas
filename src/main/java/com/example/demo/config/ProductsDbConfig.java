package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.example.demo.repo.products",
    entityManagerFactoryRef = "emfProducts",
    transactionManagerRef = "txProducts"
)
public class ProductsDbConfig {
}
