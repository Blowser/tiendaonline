package cl.duoc.tiendaonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TiendaonlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaonlineApplication.class, args);
	}
}
// FLUJO DE DESARROLLO DEL PROYECTO TIENDA ONLINE

// FASE 1. PERSISTENCIA DE DATOS
// Tabla Oracle (USUARIOS/PRODUCTOS) SCRIPT SQL
// ↓
// Entity (Usuario)
// ↓
// DTO (UsuarioDTO)
// ↓
// Repository (UsuarioRepository)
// ↓
// Configuración Oracle (application.properties)
// -----------------------------------------------------

// FASE 2. LÓGICA DE NEGOCIO
// Service (UsuarioService)
// ↓
// CRUD
// ↓
// Refactorización
// ↓
// Conversión DTO ↔ Entity
// -----------------------------------------------------

// FASE 3. EXPOSICIÓN DE LA API
// Controller (UsuarioController)
// ↓
// Endpoints REST
// POST
// GET
// GET/{id}
// PUT/{id}
// DELETE/{id}
// -----------------------------------------------------

// FASE 4. MANEJO DE ERRORES
// Excepciones personalizadas
// ↓
// GlobalExceptionHandler
// ↓
// Respuestas HTTP controladas
// -----------------------------------------------------

// FASE 5. VALIDACIÓN Y PRUEBAS
// DTO + Validation
// (@NotBlank, @Email, @Size)
// ↓
// Postman
// ↓
// Verificación del CRUD completo
// -----------------------------------------------------

// FASE 6. PRESENTACIÓN (OPCIONAL)
// Thymeleaf
// HTML
// CSS
// JavaScript
// =====================================================

// ARQUITECTURA DE EJECUCIÓN
// Cliente / Postman
// ↓
// Controller
// ↓
// Service
// ↓
// Repository
// ↓
// Oracle
// =====================================================

// ARQUITECTURA DE DATOS
//
// JSON
// ↓
// DTO
// ↓
// Entity
// ↓
// Oracle
//
// Oracle
// ↓
// Entity
// ↓
// DTO
// ↓
// JSON
