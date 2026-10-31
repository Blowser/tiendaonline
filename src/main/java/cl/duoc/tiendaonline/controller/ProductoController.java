package cl.duoc.tiendaonline.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.tiendaonline.dto.ProductoDTO;
import cl.duoc.tiendaonline.service.ProductoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(
            ProductoService service) {

        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<ProductoDTO> crearProducto(
            @Valid @RequestBody ProductoDTO request) {

        ProductoDTO nuevoProducto =
                service.crear(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevoProducto);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<ProductoDTO>>
    obtenerTodos() {

        List<ProductoDTO> productos =
                service.obtenerTodos();

        return ResponseEntity.ok(productos);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> obtenerPorId(
            @PathVariable Long id) {

        ProductoDTO producto =
                service.obtenerPorId(id);

        if (producto != null) {

            return ResponseEntity.ok(producto);
        }

        return ResponseEntity.notFound().build();
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> actualizarProducto(
            @PathVariable Long id,
            @Valid @RequestBody ProductoDTO request) {

        ProductoDTO productoActualizado =
                service.actualizar(id, request);

        if (productoActualizado != null) {

            return ResponseEntity.ok(
                    productoActualizado);
        }

        return ResponseEntity.notFound().build();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(
            @PathVariable Long id) {

        ProductoDTO producto =
                service.eliminar(id);

        if (producto != null) {

            return ResponseEntity
                    .noContent()
                    .build();
        }

        return ResponseEntity
                .notFound()
                .build();
    }
}