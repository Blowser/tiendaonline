package cl.duoc.tiendaonline.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioDTO {

    // No permitimos nombres vacíos
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
    private String nombre;


    // Verifica formato de correo
    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo debe tener un formato válido")
    private String correo;

    // Mínimo 8 caracteres
    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, max = 100,
            message = "La contraseña debe tener entre 8 y 100 caracteres")
    private String password;

    // ADMIN o USUARIO
    @NotBlank(message = "El rol es obligatorio")
    private String rol;

    // Constructor vacío requerido por frameworks de serialización/deserialización
    // Spring y Jackson necesitan un constructor sin argumentos para crear instancias del objeto.
    // Luego de instanciar las clases, los framework utilizan los getters y setters 
    // para mapear los datos del JSON a los atributos de la clase.

    public UsuarioDTO() {
    }

    // Getters y Setters
    //El encapsulamiento protege los datos internos de una clase.
    //evita modificaciones directas no controladas y mejora la mantenibilidad del software.

    //Para acceder a los atributos privados de la clase UsuarioDTO, 
    // se utilizan métodos públicos llamados getters y setters.
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}