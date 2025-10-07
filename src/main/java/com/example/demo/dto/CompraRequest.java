package com.example.demo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompraRequest {

    private List<ProductoCompra> productos;
    private String cliente;
    private String metodo;

    public static class ProductoCompra {
        private Long productId;
        private int cantidad;
        private double precioUnitario;

        public ProductoCompra(Long productId, int cantidad, double precioUnitario) {
            this.productId = productId;
            this.cantidad = cantidad;
            this.precioUnitario = precioUnitario;
        }

        public Long getProductId() {
            return productId;
        }
        public int getCantidad() {
            return cantidad;
        }
        public double getPrecioUnitario() {
            return precioUnitario;
        }
    }
}
