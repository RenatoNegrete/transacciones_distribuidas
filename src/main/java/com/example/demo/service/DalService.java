package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CompraRequest;
import com.example.demo.entity.invoices.Invoice;
import com.example.demo.entity.payments.Payment;

@Service
public class DalService {

    private final InventarioService invService;
    private final FacturacionService factService;
    private final PagosService pagService;
    private final KafkaProducerService kafkaService;

    public DalService(InventarioService invService, FacturacionService factService, PagosService pagService,  KafkaProducerService kafkaService) {
        this.invService = invService;
        this.factService = factService;
        this.pagService = pagService;
        this.kafkaService = kafkaService;
    }

    public void procesarCompra(CompraRequest request) {
        Long facturaId = null;
        Long pagoId = null;
        List<Long> productosProcesados = new ArrayList<>();
        double total = 0.0;

        try {
            for (CompraRequest.ProductoCompra p : request.getProductos()) {
                invService.descontarStock(p.getProductId(), p.getCantidad());
                productosProcesados.add(p.getProductId());
                total += p.getCantidad() * p.getPrecioUnitario();
            }
            Invoice factura = factService.crearFactura(request.getCliente(), total);
            facturaId = factura.getId();
            Payment pago = pagService.registrarPago(request.getMetodo(), total);
            pagoId = pago.getId();
            System.out.println("Compra procesada correctamente");
            kafkaService.enviarFactura(factura);
            kafkaService.enviarNotificacion("Compra procesada correctamente");
        } catch (Exception e) {
            System.err.println("Error en el proceso: " + e.getMessage());
            if (pagoId != null) pagService.eliminarPago(pagoId);
            if (facturaId != null) factService.eliminarFactura(facturaId);
            for (CompraRequest.ProductoCompra p : request.getProductos()) {
                if (productosProcesados.contains(p.getProductId())) {
                    try {
                        invService.descontarStock(p.getProductId(), -p.getCantidad());
                    } catch (Exception ex) {
                        System.err.println("No se pudo revertir el inventario: " + ex.getMessage());
                    }
                }
            }
            throw new RuntimeException("Transaccion distribuida fallida y revertida");
        }
    }

}
