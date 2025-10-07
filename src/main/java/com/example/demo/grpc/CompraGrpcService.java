package com.example.demo.grpc;

import java.util.stream.Collectors;

import org.springframework.grpc.server.service.GrpcService;

import com.example.demo.dto.CompraRequest;
import com.example.demo.service.DalService;

import io.grpc.stub.StreamObserver;

@GrpcService
public class CompraGrpcService extends CompraServiceGrpc.CompraServiceImplBase {

    private final DalService dal;

    public CompraGrpcService(DalService dal) {
        this.dal = dal;
    }

    @Override
    public void realizarCompra(RealizarCompraRequest request,
                                StreamObserver<RealizarCompraResponse> responseObserver) {

        try {
            CompraRequest compra = new CompraRequest();
            compra.setCliente(request.getCliente());
            compra.setMetodo(request.getMetodo());
            compra.setProductos(
                request.getProductosList().stream()
                    .map(p -> new CompraRequest.ProductoCompra(
                        p.getProductId(),
                        p.getCantidad(),
                        p.getPrecioUnitario()))
                    .collect(Collectors.toList())  
            );
            dal.procesarCompra(compra);

            RealizarCompraResponse response = RealizarCompraResponse.newBuilder()
                    .setMensaje("Compra procesada correctamente por gRPC")
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }

    }

}
