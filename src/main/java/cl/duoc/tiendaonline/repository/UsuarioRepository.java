package cl.duoc.tiendaonline.repository;

// JpaRepository pertenece a Spring Data JPA.
// Esta interfaz actúa como puente entre la aplicación y la base de datos.
// A partir de la entidad Usuario y su clave primaria (Long),
// Spring genera automáticamente las operaciones CRUD más comunes,
// evitando escribir consultas SQL manualmente.

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cl.duoc.tiendaonline.entity.Usuario;

@Repository
public interface UsuarioRepository
        extends JpaRepository<Usuario, Long> {

}

//Repository:
//Capa encargada de acceder a la base de datos.

//JpaRepository recibe una entidad y el tipo de su clave primaria.

//A partir de esta información, Spring Data JPA genera
//automáticamente los métodos CRUD básicos sin necesidad
//de escribir SQL manualmente.


// Usuario
// ↓
// Entidad que será gestionada por el repositorio.
//
// Long
// ↓
// Tipo de dato utilizado por la clave primaria (ID).
//
// Spring Data JPA genera automáticamente:
//
// save()
// findAll()
// findById()
// deleteById()
//
// Cuando alguno de estos métodos es invocado,
// Hibernate genera el SQL correspondiente y lo ejecuta sobre Oracle.
