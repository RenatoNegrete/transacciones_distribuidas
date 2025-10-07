//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.2 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2025.10.06 a las 10:22:26 PM COT 
//


package com.example.compra;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.compra package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.compra
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RealizarCompraRequest }
     * 
     */
    public RealizarCompraRequest createRealizarCompraRequest() {
        return new RealizarCompraRequest();
    }

    /**
     * Create an instance of {@link ProductosList }
     * 
     */
    public ProductosList createProductosList() {
        return new ProductosList();
    }

    /**
     * Create an instance of {@link RealizarCompraResponse }
     * 
     */
    public RealizarCompraResponse createRealizarCompraResponse() {
        return new RealizarCompraResponse();
    }

    /**
     * Create an instance of {@link Producto }
     * 
     */
    public Producto createProducto() {
        return new Producto();
    }

}
