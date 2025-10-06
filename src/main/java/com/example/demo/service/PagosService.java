package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.payments.Payment;
import com.example.demo.repo.payments.PaymentRepository;

@Service
public class PagosService {

    private final PaymentRepository repo;

    public PagosService(PaymentRepository repo) {
        this.repo = repo;
    }

    @Transactional("txPayments")
    public Payment registrarPago(String metodo, double monto) {
        Payment payment = new Payment();
        payment.setMetodo(metodo);
        payment.setMonto(monto);
        payment.setFecha(LocalDateTime.now());
        return repo.save(payment);
    }

    @Transactional("txPayments")
    public void eliminarPago(Long id) {
        repo.deleteById(id);
    }

}
