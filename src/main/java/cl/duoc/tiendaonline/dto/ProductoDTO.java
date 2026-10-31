package cl.duoc.tiendaonline.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public class ProductoDTO {

    // Nombre del producto
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
    private String nombre;

    // Descripción del producto
    @NotBlank(message = "La descripción es obligatoria")
    @Size(max = 300, message = "La descripción no puede superar los 300 caracteres")
    private String descripcion;

    // Precio mayor a 0
    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor que 0")
    private BigDecimal precio;

    // Descuento mayor o igual a 0
    @NotNull(message = "El descuento es obligatorio")
    @PositiveOrZero(message = "El descuento no puede ser negativo")
    private BigDecimal descuento;

    // Stock mayor o igual a 0
    @NotNull(message = "El stock es obligatorio")
    @PositiveOrZero(message = "El stock no puede ser negativo")
    private Integer stock;

    // Categoría del producto
    @NotBlank(message = "La categoría es obligatoria")
    private String categoria;

    // Subcategoría del producto
    @NotBlank(message = "La subcategoría es obligatoria")
    private String subcategoria;

    //imagen del producto
    private String urlImagen;


    // Marca del producto
    @NotBlank(message = "La marca es obligatoria")
    @Size(max = 100, message = "La marca no puede superar los 100 caracteres")
    private String marca;




    // Constructor vacío requerido por Spring y Jackson
    public ProductoDTO() {
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