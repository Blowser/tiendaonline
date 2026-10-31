package cl.duoc.tiendaonline.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cl.duoc.tiendaonline.dto.ProductoDTO;
import cl.duoc.tiendaonline.entity.Producto;
import cl.duoc.tiendaonline.repository.ProductoRepository;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(
            ProductoRepository repository) {

        this.repository = repository;
    }

    // Entity -> DTO
    private ProductoDTO toDTO(
            Producto producto) {

        ProductoDTO dto =
                new ProductoDTO();

        dto.setNombre(
                producto.getNombre());

        dto.setDescripcion(
                producto.getDescripcion());

        dto.setPrecio(
                producto.getPrecio());

        dto.setDescuento(
                producto.getDescuento());

        dto.setStock(
                producto.getStock());

        dto.setCategoria(
                producto.getCategoria());
        
        dto.setSubcategoria(
                producto.getSubcategoria());

        dto.setUrlImagen(
                producto.getUrlImagen());

        dto.setMarca(
                producto.getMarca());

        return dto;
    }

    // DTO -> Entity
    private Producto toEntity(
            ProductoDTO dto) {

        Producto producto =
                new Producto();

        producto.setNombre(
                dto.getNombre());

        producto.setDescripcion(
                dto.getDescripcion());

        producto.setPrecio(
                dto.getPrecio());

        producto.setDescuento(
                dto.getDescuento());

        producto.setStock(
                dto.getStock());

        producto.setCategoria(
                dto.getCategoria());
        
        producto.setSubcategoria(
                dto.getSubcategoria());
        
        producto.setUrlImagen(
                dto.getUrlImagen());

        producto.setMarca(
                dto.getMarca());

        return producto;
    }

    // CREATE
    public ProductoDTO crear(
            ProductoDTO request) {

        Producto producto =
                toEntity(request);

        Producto guardado =
                repository.save(producto);

        return toDTO(guardado);
    }

    // READ ALL
    public List<ProductoDTO> obtenerTodos() {

        List<Producto> productos =
                repository.findAll();

        List<ProductoDTO> respuesta =
                new ArrayList<>();

        for (Producto producto : productos) {

            respuesta.add(
                    toDTO(producto));
        }

        return respuesta;
    }

    // READ BY ID
    public ProductoDTO obtenerPorId(
            Long id) {

        Producto producto =
                repository.findById(id)
                .orElse(null);

        if (producto == null) {
            return null;
        }

        return toDTO(producto);
    }

    // UPDATE
    public ProductoDTO actualizar(
            Long id,
            ProductoDTO request) {

        Producto producto =
                repository.findById(id)
                .orElse(null);

        if (producto == null) {
            return null;
        }

        producto.setNombre(
                request.getNombre());

        producto.setDescripcion(
                request.getDescripcion());

        producto.setPrecio(
                request.getPrecio());

        producto.setDescuento(
                request.getDescuento());

        producto.setStock(
                request.getStock());

        producto.setCategoria(
                request.getCategoria());
        
        producto.setSubcategoria(
                request.getSubcategoria());

        producto.setUrlImagen(
                request.getUrlImagen());

        producto.setMarca(
                request.getMarca());

        return toDTO(
                repository.save(producto));
    }

    // DELETE
    public ProductoDTO eliminar(
            Long id) {

        Producto producto =
                repository.findById(id)
                .orElse(null);

        if (producto == null) {
            return null;
        }

        repository.deleteById(id);

        return toDTO(producto);
    }
}