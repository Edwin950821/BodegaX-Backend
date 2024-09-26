package com.edwin.bodega_x.repository // Paquete que contiene las interfaces para interactuar con la base de datos.

import com.edwin.bodega_x.model.ProductoVenta // Importa la entidad ProductoVenta, que será gestionada por el repositorio.
import org.springframework.data.jpa.repository.JpaRepository // Proporciona las operaciones CRUD predeterminadas para la entidad ProductoVenta.
import org.springframework.data.jpa.repository.JpaSpecificationExecutor // Permite realizar consultas dinámicas o basadas en especificaciones para ProductoVenta.
import org.springframework.stereotype.Repository // Marca esta interfaz como un componente de repositorio de Spring.
import java.util.UUID // Importa UUID, que es el tipo de identificador único utilizado para la entidad ProductoVenta.

@Repository("productoVenta.repository") // Marca esta interfaz como un repositorio de Spring con el identificador opcional "productoVenta.repository".
interface ProductoVentaRepository: JpaRepository<ProductoVenta, UUID>, JpaSpecificationExecutor<ProductoVenta> {
    // Esta interfaz extiende JpaRepository para obtener métodos CRUD predeterminados y JpaSpecificationExecutor para consultas dinámicas.
    // JpaRepository<ProductoVenta, UUID>: Permite gestionar la entidad ProductoVenta utilizando UUID como clave primaria.
    // JpaSpecificationExecutor<ProductoVenta>: Habilita consultas avanzadas y personalizadas sobre ProductoVenta.
}
