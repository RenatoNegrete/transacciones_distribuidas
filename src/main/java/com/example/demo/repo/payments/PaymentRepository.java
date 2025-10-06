package com.example.demo.repo.payments;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.payments.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
