package com.edwin.bodega_x.repository // Paquete que contiene las interfaces de repositorios para interactuar con la base de datos.

import com.edwin.bodega_x.model.Cliente // Importa el modelo Cliente, que será gestionado por el repositorio.
import org.springframework.data.jpa.repository.JpaRepository // Proporciona operaciones CRUD estándar para la entidad Cliente.
import org.springframework.data.jpa.repository.JpaSpecificationExecutor // Permite la ejecución de consultas más complejas basadas en especificaciones.
import org.springframework.stereotype.Repository // Indica que esta interfaz es un componente de repositorio en el contexto de Spring.
import java.util.UUID // Importa UUID, que es el tipo de dato usado como identificador único de Cliente.

@Repository("cliente.repository") // Marca la interfaz como un repositorio y le asigna el identificador de bean "cliente.repository" en el contexto de Spring.
interface ClienteRepository: JpaRepository<Cliente, UUID>, JpaSpecificationExecutor<Cliente> {
    // ClienteRepository extiende JpaRepository para la gestión de la entidad Cliente, utilizando UUID como identificador único.
    // También extiende JpaSpecificationExecutor para realizar consultas dinámicas y basadas en criterios complejos.
    // Actualmente, no hay métodos personalizados, pero pueden agregarse en el futuro para consultas específicas.
}
