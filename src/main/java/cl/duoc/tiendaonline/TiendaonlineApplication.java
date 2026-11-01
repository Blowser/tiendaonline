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




// Contexto
//Desarrollamos un e-commerce llamado RotomTech utilizando Spring Boot y Oracle.

//El sistema permite gestionar usuarios y productos mediante operaciones CRUD.

//La arquitectura está separada en capas para facilitar el mantenimiento y la escalabilidad del proyecto.



// FLUJO DE EJECUCIÓN
//POV CLIENTE:
//Cliente (Postman) -> Controller -> Service -> Repository -> Oracle DBA 

//POV APP: 
//Oracle DBA -> Repository -> Service -> Controller -> JSON -> Cliente	

//POV ERROR:
//Cliente->JSON->DTO + Validaciones->Error->GlobalExceptionHandler->JSON Error->Cliente

