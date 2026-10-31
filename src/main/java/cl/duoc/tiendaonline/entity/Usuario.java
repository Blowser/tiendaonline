package cl.duoc.tiendaonline.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "USUARIOS")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "CORREO", nullable = false)
    private String correo;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "ROL", nullable = false)
    private String rol;

    // Constructor vacío requerido por JPA
    // Constructor vacío requerido por frameworks de serialización/deserialización
    // JPA/Hibernate necesita un constructor sin argumentos para poder instanciar y luego
    // utilizar los getters y setters y mapear los datos de la base de datos a los atributos de la clase.

    
    public Usuario() {
    }
    // Getters y Setters
    //El encapsulamiento protege los datos internos de una clase.
    //evita modificaciones directas no controladas y mejora la mantenibilidad del software.

    //Para acceder a los atributos privados de la clase UsuarioDTO, 
    // se utilizan métodos públicos llamados getters y setters.
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
