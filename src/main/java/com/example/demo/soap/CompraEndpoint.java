package com.example.demo.soap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.compra.Producto;
import com.example.compra.RealizarCompraRequest;
import com.example.compra.RealizarCompraResponse;
import com.example.demo.dto.CompraRequest;
import com.example.demo.service.DalService;

@Endpoint
public class CompraEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/compra";
    private final DalService dal;
    
    public CompraEndpoint(DalService dal) {
        this.dal = dal;
    }

    @PayloadRoot(namespace = NAMESPACE_URI  , localPart = "realizarCompraRequest")
    @ResponsePayload
    public RealizarCompraResponse realizarCompra(@RequestPayload RealizarCompraRequest request) {
        RealizarCompraResponse response = new RealizarCompraResponse();

        try {
            CompraRequest compraRequest = mapToCompraRequest(request);
            dal.procesarCompra(compraRequest);
            response.setMensaje("Compra procesada correctamente");
        } catch (Exception e) {
            response.setMensaje("Error al procesar la compra: " + e.getMessage());
        }
        return response;
    }

    private CompraRequest mapToCompraRequest(RealizarCompraRequest request) {
        CompraRequest compra = new CompraRequest();
        compra.setCliente(request.getCliente());
        compra.setMetodo(request.getMetodo());
        List<CompraRequest.ProductoCompra> productos = new ArrayList<>();
        if (request.getProductos() != null && request.getProductos().getProducto() != null) {
            for (Producto p : request.getProductos().getProducto()) {
                CompraRequest.ProductoCompra item = new CompraRequest.ProductoCompra(
                    p.getProductId(),
                    p.getCantidad(),
                    p.getPrecioUnitario()
                );
                productos.add(item);
            }
        }
        compra.setProductos(productos);
        return compra;
    }

}
