package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CompraRequest;
import com.example.demo.service.DalService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/compras")
public class CompraRestController {

    private final DalService dalService;

    public CompraRestController(DalService dalService) {
        this.dalService = dalService;
    }

    @PostMapping
    public ResponseEntity<String> realizarCompra(@RequestBody CompraRequest request) {
        try {
            dalService.procesarCompra(request);
            return ResponseEntity.ok("Compra realizada correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al realizar la compra: " + e.getMessage());
        }
        
    } 

}
