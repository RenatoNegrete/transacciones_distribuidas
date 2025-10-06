package com.example.demo.repo.invoices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.invoices.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
