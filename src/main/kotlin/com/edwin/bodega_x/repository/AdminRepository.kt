package com.edwin.bodega_x.repository // Paquete que contiene las interfaces de repositorio de la aplicación, las cuales interactúan con la base de datos.

import com.edwin.bodega_x.model.Admin // Importa el modelo Admin que será gestionado por el repositorio.
import org.springframework.data.jpa.repository.JpaRepository // Proporciona operaciones CRUD y más para la entidad Admin.
import org.springframework.data.jpa.repository.JpaSpecificationExecutor // Permite ejecutar consultas basadas en especificaciones complejas.
import org.springframework.stereotype.Repository // Indica que esta interfaz es un componente de repositorio de Spring.
import java.util.Optional // Se usa para manejar resultados de consultas que pueden o no devolver un valor.
import java.util.UUID // Tipo de dato para el identificador único de cada Admin.

@Repository("admin.repository") // Anotación que marca esta interfaz como un repositorio y le da un identificador de bean opcional "admin.repository".
interface AdminRepository: JpaRepository<Admin, UUID>, JpaSpecificationExecutor<Admin> {
    // AdminRepository extiende JpaRepository para la gestión básica de la entidad Admin, utilizando UUID como identificador único.
    // También extiende JpaSpecificationExecutor para realizar consultas dinámicas o complejas basadas en criterios.

    fun findFirstByNombreAndPassword(nombre: String, password: String): Optional<Admin>
    // Método personalizado para buscar el primer registro de un Admin por nombre y contraseña.
    // Devuelve un Optional<Admin>, lo que significa que podría devolver un valor Admin o estar vacío si no se encuentra coincidencia.
}
