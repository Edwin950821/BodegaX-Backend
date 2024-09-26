package com.edwin.bodega_x.repository // Paquete donde se gestionan las interfaces para interactuar con la base de datos.

import com.edwin.bodega_x.model.Producto // Importa la entidad Producto, que será gestionada por el repositorio.
import org.springframework.data.jpa.repository.JpaRepository // Proporciona las operaciones CRUD para la entidad Producto.
import org.springframework.data.jpa.repository.JpaSpecificationExecutor // Permite realizar consultas dinámicas o basadas en criterios en la entidad Producto.
import org.springframework.stereotype.Repository // Marca esta interfaz como un componente de repositorio de Spring.
import java.util.UUID // Importa UUID, que es el tipo utilizado como identificador único para los productos.

@Repository("producto.repository") // Marca esta interfaz como un repositorio de Spring y le da el identificador opcional "producto.repository".
interface ProductoRepository: JpaRepository<Producto, UUID>, JpaSpecificationExecutor<Producto> {
    // Esta interfaz extiende JpaRepository para obtener métodos CRUD predeterminados y JpaSpecificationExecutor para realizar consultas personalizadas y complejas.
    // JpaRepository<Producto, UUID>: Gestión estándar de la entidad Producto, usando UUID como clave primaria.
    // JpaSpecificationExecutor<Producto>: Permite ejecutar consultas basadas en especificaciones dinámicas.
}
