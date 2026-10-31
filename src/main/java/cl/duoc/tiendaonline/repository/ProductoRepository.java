package cl.duoc.tiendaonline.repository;

// JpaRepository pertenece a Spring Data JPA.
// Esta interfaz actúa como puente entre la aplicación y la base de datos.
//
// A partir de la entidad Producto y su clave primaria (Long),
// Spring genera automáticamente las operaciones CRUD más comunes,
// evitando escribir consultas SQL manualmente.

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.tiendaonline.entity.Producto;

@Repository
public interface ProductoRepository
        extends JpaRepository<Producto, Long> {

}