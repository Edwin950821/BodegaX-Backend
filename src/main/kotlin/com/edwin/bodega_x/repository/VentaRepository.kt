package com.edwin.bodega_x.repository // Paquete que contiene las interfaces para la gestión de la persistencia de datos.

import com.edwin.bodega_x.model.Venta // Importa la entidad Venta, que será gestionada por este repositorio.
import org.springframework.data.jpa.repository.JpaRepository // Proporciona operaciones CRUD predeterminadas para la entidad Venta.
import org.springframework.data.jpa.repository.JpaSpecificationExecutor // Permite consultas dinámicas y personalizadas sobre la entidad Venta.
import org.springframework.stereotype.Repository // Marca esta interfaz como un componente de repositorio gestionado por Spring.
import java.util.UUID // Importa UUID, utilizado como el identificador único para la entidad Venta.

@Repository("venta.repository") // Anotación que indica que esta interfaz es un repositorio de Spring con el nombre opcional "venta.repository".
interface VentaRepository: JpaRepository<Venta, UUID>, JpaSpecificationExecutor<Venta> {
    // La interfaz extiende JpaRepository para proporcionar métodos CRUD y JpaSpecificationExecutor para consultas avanzadas.
    // JpaRepository<Venta, UUID>: Gestiona la entidad Venta utilizando UUID como clave primaria.
    // JpaSpecificationExecutor<Venta>: Habilita la creación de consultas avanzadas o personalizadas sobre la entidad Venta.
}
