package com.example.demo.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class MultiDataSourceConfig {

    @Bean
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder() {
        return new EntityManagerFactoryBuilder(
            new org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter(),
            new HashMap<>(),
            null
        );
    }

    // ---------------- PRODUCTS ----------------
    @Bean
    @ConfigurationProperties("app.datasource.products")
    public DataSourceProperties productsDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "dsProducts")
    public DataSource dsProducts(@Qualifier("productsDataSourceProperties") DataSourceProperties dsp) {
        return dsp.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean(name = "emfProducts")
    public LocalContainerEntityManagerFactoryBean emfProducts(
            EntityManagerFactoryBuilder builder,
            @Qualifier("dsProducts") DataSource ds) {

        Map<String, Object> props = new HashMap<>();
        props.put("hibernate.hbm2ddl.auto", "update");
        props.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        props.put("jakarta.persistence.transactionType", "RESOURCE_LOCAL");

        return builder
                .dataSource(ds)
                .packages("com.example.demo.entity.products") // entidades del módulo de productos
                .persistenceUnit("pu-products")
                .properties(props)
                .build();
    }

    @Bean(name = "txProducts")
    public PlatformTransactionManager txProducts(@Qualifier("emfProducts") LocalContainerEntityManagerFactoryBean emf) {
        return new JpaTransactionManager(emf.getObject());
    }

    // ---------------- INVOICES ----------------
    @Bean
    @ConfigurationProperties("app.datasource.invoices")
    public DataSourceProperties invoicesDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "dsInvoices")
    public DataSource dsInvoices(@Qualifier("invoicesDataSourceProperties") DataSourceProperties dsp) {
        return dsp.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean(name = "emfInvoices")
    public LocalContainerEntityManagerFactoryBean emfInvoices(
            EntityManagerFactoryBuilder builder,
            @Qualifier("dsInvoices") DataSource ds) {

        Map<String, Object> props = new HashMap<>();
        props.put("hibernate.hbm2ddl.auto", "update");
        props.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        props.put("jakarta.persistence.transactionType", "RESOURCE_LOCAL");

        return builder
                .dataSource(ds)
                .packages("com.example.demo.entity.invoices") // entidades de facturas
                .persistenceUnit("pu-invoices")
                .properties(props)
                .build();
    }

    @Bean(name = "txInvoices")
    public PlatformTransactionManager txInvoices(@Qualifier("emfInvoices") LocalContainerEntityManagerFactoryBean emf) {
        return new JpaTransactionManager(emf.getObject());
    }

    // ---------------- PAYMENTS ----------------
    @Bean
    @ConfigurationProperties("app.datasource.payments")
    public DataSourceProperties paymentsDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "dsPayments")
    public DataSource dsPayments(@Qualifier("paymentsDataSourceProperties") DataSourceProperties dsp) {
        return dsp.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean(name = "emfPayments")
    public LocalContainerEntityManagerFactoryBean emfPayments(
            EntityManagerFactoryBuilder builder,
            @Qualifier("dsPayments") DataSource ds) {

        Map<String, Object> props = new HashMap<>();
        props.put("hibernate.hbm2ddl.auto", "update");
        props.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        props.put("jakarta.persistence.transactionType", "RESOURCE_LOCAL");

        return builder
                .dataSource(ds)
                .packages("com.example.demo.entity.payments") // entidades de pagos
                .persistenceUnit("pu-payments")
                .properties(props)
                .build();
    }

    @Bean(name = "txPayments")
    public PlatformTransactionManager txPayments(@Qualifier("emfPayments") LocalContainerEntityManagerFactoryBean emf) {
        return new JpaTransactionManager(emf.getObject());
    }

}
