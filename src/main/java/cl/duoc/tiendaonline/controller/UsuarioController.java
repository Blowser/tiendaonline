package cl.duoc.tiendaonline.controller;

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

import cl.duoc.tiendaonline.dto.UsuarioDTO;
import cl.duoc.tiendaonline.service.UsuarioService;
import jakarta.validation.Valid;
import java.util.List;

// El Controller representa la capa de presentación
// de la API y actúa como punto de entrada de las solicitudes.

// @RestController indica que esta clase puede recibir
// solicitudes HTTP (GET, POST, PUT y DELETE)
// y devolver respuestas HTTP.
@RestController

// @RequestMapping define la ruta base de este Controller.
// Todos los endpoints declarados dentro de esta clase
// comenzarán con "/usuarios".
// Ejemplos:
// GET    /usuarios
// GET    /usuarios/1
// POST   /usuarios
// PUT    /usuarios/1
// DELETE /usuarios/1
// Esto evita repetir "/usuarios"
// en cada método del controlador.
@RequestMapping("/usuarios")
public class UsuarioController {

    // Dependencia que permite acceder a la lógica
    // de negocio implementada en UsuarioService.
    //
    // El Controller no accede directamente al Repository
    // ni a Oracle.
    private final UsuarioService service;

    // Spring crea automáticamente una instancia
    // de UsuarioService y la inyecta mediante
    // el constructor.
    //
    // Flujo de inyección:
    //
    // UsuarioController
    // ↓ necesita
    // UsuarioService
    // ↓ necesita
    // UsuarioRepository
    // ↓ utiliza
    // Oracle
    public UsuarioController(
            UsuarioService service) {

        // Guarda la referencia recibida por Spring
        // para utilizarla en todos los endpoints
        // de este controlador.
        this.service = service;
    }
    // CREAR USUARIO (POST)
    // @PostMapping asocia este método a solicitudes HTTP POST.
    // @RequestBody convierte automáticamente el JSON recibido
    // en un objeto UsuarioDTO.
    // @Valid ejecuta las validaciones definidas en UsuarioDTO
    // antes de llamar al Service.
    @PostMapping
    public ResponseEntity<UsuarioDTO> crearUsuario(
            @Valid @RequestBody UsuarioDTO request) {

        UsuarioDTO nuevoUsuario =
                service.crear(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevoUsuario);
    }

    // OBTENER TODOS LOS USUARIOS (GET)
    // @GetMapping asocia este método a solicitudes HTTP GET.
    // Ejemplo:
    // GET /usuarios
    // El Controller solicita los datos al Service
    // y devuelve una respuesta HTTP 200 OK con la lista
    // de usuarios obtenida desde Oracle.
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>>
    obtenerTodos() {

        List<UsuarioDTO> usuarios =
                service.obtenerTodos();

        return ResponseEntity.ok(usuarios);
    }


    // OBTENER USUARIO POR ID (GET)
    // @PathVariable obtiene el ID directamente desde la URL.
    // Ejemplo:
    // GET /usuarios/1
    // id = 1
    // El Controller solicita el usuario al Service.
    // Si existe:
    // devuelve HTTP 200 OK.
    // Si no existe:
    // devuelve HTTP 404 Not Found.
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obtenerPorId(
            @PathVariable Long id) {

        UsuarioDTO usuario =
                service.obtenerPorId(id);

        if (usuario != null) {

            return ResponseEntity.ok(usuario);
        }

        return ResponseEntity.notFound().build();
    }    



    // ACTUALIZAR USUARIO (PUT)
    // @PutMapping asocia este método a solicitudes HTTP PUT.
    // @PathVariable obtiene el ID desde la URL.
    // @RequestBody convierte el JSON recibido
    // en un objeto UsuarioDTO.
    // @Valid ejecuta las validaciones definidas
    // en UsuarioDTO.
    // Ejemplo:
    // PUT /usuarios/1

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> actualizarUsuario(
            @PathVariable Long id,
            @Valid @RequestBody UsuarioDTO request) {

        UsuarioDTO usuarioActualizado =
                service.actualizar(id, request);

        if (usuarioActualizado != null) {

            return ResponseEntity.ok(
                    usuarioActualizado);
        }

        return ResponseEntity.notFound().build();
    }

    // ELIMINAR USUARIO (DELETE)
    // @DeleteMapping asocia este método
    // a solicitudes HTTP DELETE.
    // @PathVariable obtiene el ID
    // desde la URL.
    // Ejemplo:
    // DELETE /usuarios/1
    // Si el usuario existe:
    // devuelve HTTP 204 No Content.
    // Si el usuario no existe:
    // devuelve HTTP 404 Not Found.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(
            @PathVariable Long id) {

        UsuarioDTO usuario =
                service.eliminar(id);

        if (usuario != null) {

            return ResponseEntity
                    .noContent()
                    .build();
        }

        return ResponseEntity
                .notFound()
                .build();
    }




}


// Flujo:
// Cliente / Postman
// ↓
// Controller
// ↓
// Service
// ↓
// Repository
// ↓
// Oracle