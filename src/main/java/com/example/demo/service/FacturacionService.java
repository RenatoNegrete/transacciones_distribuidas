package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.invoices.Invoice;
import com.example.demo.repo.invoices.InvoiceRepository;

@Service
public class FacturacionService {

    private final InvoiceRepository repo;

    public FacturacionService(InvoiceRepository repo) {
        this.repo = repo;
    }

    @Transactional("txInvoices")
    public Invoice crearFactura(String cliente, double total) {
        Invoice invoice = new Invoice();
        invoice.setCliente(cliente);
        invoice.setTotal(total);
        invoice.setFecha(LocalDateTime.now());
        return repo.save(invoice);
    }

    @Transactional("txInvoices")
    public void eliminarFactura(Long id) {
        repo.deleteById(id);
    }

}
