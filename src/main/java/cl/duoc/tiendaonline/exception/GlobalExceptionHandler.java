package cl.duoc.tiendaonline.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
// RestControllerAdvice permite capturar excepciones de forma global
// para todos los Controllers de la aplicación.
// Su objetivo es centralizar el manejo de errores y evitar repetir
// bloques try-catch en cada endpoint.
// Maneja errores de validación (@NotBlank, @Email, @Size, etc.)
@RestControllerAdvice
public class GlobalExceptionHandler {

    // ERRORES DE VALIDACIÓN 
    
    // Captura errores generados por @Valid y devuelve una 
    // respuesta 400 personalizada.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>>
    handleValidationErrors(
            MethodArgumentNotValidException ex) {

        Map<String, String> errores =
                new HashMap<>();
        // Guarda cada error con el formato:
        // campo -> mensaje                
        for (FieldError error :
                ex.getBindingResult().getFieldErrors()) {

            errores.put(
                    error.getField(),
                    error.getDefaultMessage());
        }

        Map<String, Object> response =
                new HashMap<>();

        response.put(
                "timestamp",
                LocalDateTime.now());

        response.put(
                "status",
                HttpStatus.BAD_REQUEST.value());

        response.put(
                "errores",
                errores);

        return ResponseEntity
                .badRequest()
                .body(response);
    }


    // ERRORES GENERALES

    // Captura errores no controlados y devuelve una respuesta 500.
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>>
    handleGeneralError(
            Exception ex) {

        Map<String, Object> response =
                new HashMap<>();

        response.put(
                "timestamp",
                LocalDateTime.now());

        response.put(
                "status",
                HttpStatus.INTERNAL_SERVER_ERROR.value());

        response.put(
                "mensaje",
                "Error interno del servidor");

        response.put(
                "detalle",
                ex.getMessage());

        return ResponseEntity
                .status(
                        HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}
    // Flujo:
    // Exception
    // ↓
    // GlobalExceptionHandler
    // ↓
    // ResponseEntity
    // ↓
    // Cliente / Postman