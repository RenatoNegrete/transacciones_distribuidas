//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.2 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2025.10.06 a las 07:45:52 PM COT 
//


package com.example.compra;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cliente" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="metodo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="productos" type="{http://example.com/compra}ProductosList"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cliente",
    "metodo",
    "productos"
})
@XmlRootElement(name = "realizarCompraRequest")
public class RealizarCompraRequest {

    @XmlElement(required = true)
    protected String cliente;
    @XmlElement(required = true)
    protected String metodo;
    @XmlElement(required = true)
    protected ProductosList productos;

    /**
     * Obtiene el valor de la propiedad cliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * Define el valor de la propiedad cliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCliente(String value) {
        this.cliente = value;
    }

    /**
     * Obtiene el valor de la propiedad metodo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetodo() {
        return metodo;
    }

    /**
     * Define el valor de la propiedad metodo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetodo(String value) {
        this.metodo = value;
    }

    /**
     * Obtiene el valor de la propiedad productos.
     * 
     * @return
     *     possible object is
     *     {@link ProductosList }
     *     
     */
    public ProductosList getProductos() {
        return productos;
    }

    /**
     * Define el valor de la propiedad productos.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductosList }
     *     
     */
    public void setProductos(ProductosList value) {
        this.productos = value;
    }

}
