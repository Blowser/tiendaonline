package cl.duoc.tiendaonline.service;
// @Service indica que esta clase pertenece a la capa de servicios.
// Su responsabilidad es contener la lógica de negocio de la aplicación,
// coordinando las operaciones entre el Controller y el Repository.
    // Flujo:
    // Controller
    // ↓
    // Service
    // ↓
    // Repository
    // ↓
    // Oracle

import java.util.ArrayList;

// El Service no recibe solicitudes HTTP directamente,
// tampoco ejecuta consultas SQL.
// Su función es aplicar reglas de negocio y utilizar
// el Repository para acceder a los datos.

import java.util.List;

import org.springframework.stereotype.Service;

import cl.duoc.tiendaonline.dto.UsuarioDTO;
import cl.duoc.tiendaonline.entity.Usuario;
import cl.duoc.tiendaonline.repository.UsuarioRepository;

// Spring crea automáticamente una instancia de UsuarioRepository
// y la inyecta mediante el constructor.
//
// Esto evita crear objetos manualmente con:
//
// UsuarioRepository repository = new UsuarioRepository();
//
// permitiendo que Spring administre el ciclo de vida
// de los componentes de la aplicación.
@Service
public class UsuarioService {

    // 1. Declaración de la dependencia.
    // El Service necesita utilizar los métodos del Repository
    // para acceder a los datos almacenados en Oracle.
    //UsuarioRepository es el tipo de dato y el nombre es repository.
    //private: Sólo UsuarioService puede usar esta variable.
    // final indica que la referencia no podrá cambiar
    // una vez que haya sido asignada por Spring.
    // Esto garantiza que el Service siempre utilice la misma instancia del Repository.
    
    // Dependencia que permite acceder a los datos de Oracle
    // mediante los métodos generados por JpaRepository.
        private final UsuarioRepository repository;

    // 2. Inyección mediante constructor.
    // Spring crea automáticamente una instancia de
    // un objeto de tipo UsuarioRepository y la entrega a este constructor.
    // Gracias a esto no es necesario crear manualmente
    // el objeto utilizando "new UsuarioRepository()".

    // Spring entrega automáticamente un UsuarioRepository
    // al crear UsuarioService.
    public UsuarioService(
            UsuarioRepository repository) {

        // 3. Asignación de la dependencia.
        // this.repository corresponde al atributo de la clase.
        // equivalente a: this.repository = this.repository;
        // repository corresponde al parámetro recibido 
        // por el constructordesde Spring.
        // Se guarda la referencia del Repository para que
        // pueda ser utilizada por todos los métodos del Service.

        // Guarda la referencia recibida para que pueda ser
        // utilizada por todos los métodos del Service.
        this.repository = repository;
    }


    // 4. Métodos del Service.
    // Cada método del Service implementa una operación
    // CRUD (Create, Read, Update, Delete) o una operación de negocio específica.

        //4.1. Métodos de conversión entre Entity y DTO
        // 4.1.1. DTO REFACTORIZADO
        // reutilizando el mismo DTO para crear, actualizar y eliminar usuarios.
        // Convierte una entidad Usuario
        // en un objeto UsuarioDTO.
        //
        // Entity
        // ↓
        // DTO
        private UsuarioDTO toDTO(
                Usuario usuario) {

        UsuarioDTO dto =
                new UsuarioDTO();

        dto.setNombre(
                usuario.getNombre());

        dto.setCorreo(
                usuario.getCorreo());

        dto.setPassword(
                usuario.getPassword());

        dto.setRol(
                usuario.getRol());

        return dto;
        }

        // DTO REFACTORIZADO
        // reutilizando el mismo DTO para crear, actualizar y eliminar usuarios.
        // Convierte un objeto UsuarioDTO
        // en una entidad Usuario.
        //
        // DTO
        // ↓
        // Entity
        private Usuario toEntity(
                UsuarioDTO dto) {

        Usuario usuario =
                new Usuario();

        usuario.setNombre(
                dto.getNombre());

        usuario.setCorreo(
                dto.getCorreo());

        usuario.setPassword(
                dto.getPassword());

        usuario.setRol(
                dto.getRol());

        return usuario;
        }








    // 4.2. CREAR USUARIO (POST)
    // Recibe un UsuarioDTO desde el Controller.
    // El DTO representa los datos que llegan desde la API.
    // Luego se crea una entidad Usuario,
    // se copian los datos del DTO hacia la entidad
    // y finalmente se guarda en Oracle mediante el Repository.
    // Flujo:
    // JSON
    // ↓
    // UsuarioDTO
    // ↓
    // Usuario (Entity)
    // ↓
    // Repository
    // ↓
    // Oracle
public UsuarioDTO crear(
        UsuarioDTO request) {

    Usuario usuario =
            toEntity(request);

    Usuario guardado =
            repository.save(usuario);

    return toDTO(guardado);
        }
       
    // 4.3.1 OBTENER TODOS LOS USUARIOS (GET)
    // Obtiene todos los registros almacenados en Oracle
    // mediante el Repository.
    // Cada entidad Usuario es transformada a UsuarioDTO
    // antes de ser enviada a la API.
    // Flujo:
    //
    // Oracle
    // ↓
    // Entity
    // ↓
    // DTO
    // ↓
    // API
public List<UsuarioDTO> obtenerTodos() {

    List<Usuario> usuarios =
            repository.findAll();

    List<UsuarioDTO> respuesta =
            new ArrayList<>();

    for (Usuario usuario : usuarios) {

        respuesta.add(
                toDTO(usuario));
    }

    return respuesta;
        }    

    // 4.3.2 OBTENER USUARIO POR ID (GET)
    //
    // Busca un usuario utilizando su clave primaria (ID).
    //
    // Primero solicita la entidad al Repository.
    //
    // Si el usuario existe:
    // Entity → DTO → Response
    //
    // Si el usuario no existe:
    // retorna null.
    //
    // Más adelante reemplazaremos este null
    // por una excepción personalizada.
public UsuarioDTO obtenerPorId(
        Long id) {

    Usuario usuario =
            repository.findById(id)
            .orElse(null);

    if(usuario == null){
        return null;
    }

    return toDTO(usuario);
        }

    // 4.4. ACTUALIZAR USUARIO (PUT)
    // Busca un usuario existente utilizando su ID.
    // Si el usuario existe:
    // 1. Obtiene la entidad desde Oracle.
    // 2. Actualiza sus atributos con los datos recibidos en el DTO.
    // 3. Guarda los cambios mediante el Repository.
    // 4. Convierte la entidad actualizada a DTO.
    // Si el usuario no existe:
    // retorna null.
    // Flujo:
    // DTO
    // ↓
    // Entity existente
    // ↓
    // save()
    // ↓
    // Oracle
    // ↓
    // Entity actualizada
    // ↓
    // DTO
public UsuarioDTO actualizar(
        Long id,
        UsuarioDTO request) {

    Usuario usuario = repository.findById(id)
            .orElse(null);

    if (usuario == null) {
        return null;
    }

    // DTO → Entity

    usuario.setNombre(
            request.getNombre());

    usuario.setCorreo(
            request.getCorreo());

    usuario.setPassword(
            request.getPassword());

    usuario.setRol(
            request.getRol());

    return toDTO(
        repository.save(usuario));
        
        }


    // 4.5. ELIMINAR USUARIO (DELETE)
    // Busca un usuario existente utilizando su ID.
    // Si el usuario existe:
    // 1. Obtiene la entidad desde Oracle.
    // 2. Elimina el registro mediante el Repository.
    // 3. Convierte la entidad eliminada a DTO.
    // 4. Devuelve el DTO eliminado.
    // Si el usuario no existe:
    // retorna null.
    // Flujo:
    // Oracle
    // ↓
    // Entity
    // ↓
    // deleteById()
    // ↓
    // Oracle
    //
public UsuarioDTO eliminar(Long id) {

    Usuario usuario = repository.findById(id)
            .orElse(null);

    if (usuario == null) {
        return null;
    }

    repository.deleteById(id);

return toDTO(usuario);
    }
    
}







  

