package cl.duoc.tiendaonline.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCTOS")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;

    @Column(name = "PRECIO", nullable = false)
    private BigDecimal precio;

    @Column(name = "DESCUENTO", nullable = false)
    private BigDecimal descuento;

    @Column(name = "STOCK", nullable = false)
    private Integer stock;

    @Column(name = "CATEGORIA", nullable = false)
    private String categoria;

    @Column(name = "SUBCATEGORIA", nullable = false)
    private String subcategoria;

    @Column(name = "URL_IMAGEN")
    private String urlImagen;

    @Column(name = "MARCA", nullable = false)
    private String marca;




    // Constructor vacío requerido por JPA
    public Producto() {
    }


    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }


    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}