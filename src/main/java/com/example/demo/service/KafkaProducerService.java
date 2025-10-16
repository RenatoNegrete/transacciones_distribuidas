package com.example.demo.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.entity.invoices.Invoice;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarFactura(Invoice factura) {
        kafkaTemplate.send("facturas", factura);
    }

    public void enviarNotificacion(String mensaje) {
        kafkaTemplate.send("notificaciones", mensaje);
    }

}
