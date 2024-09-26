package com.edwin.bodega_x.service.admin.impl // Paquete que contiene la implementación del servicio para la entidad Admin.

import com.edwin.bodega_x.dto.LoginDto // Importa la clase DTO para manejar las credenciales de inicio de sesión.
import com.edwin.bodega_x.model.Admin // Importa el modelo Admin que representa la entidad en la base de datos.
import com.edwin.bodega_x.repository.AdminRepository // Importa el repositorio de Admin para las operaciones CRUD.
import com.edwin.bodega_x.service.admin.AdminService // Importa la interfaz que define los métodos del servicio de Admin.
import org.springframework.data.jpa.repository.JpaRepository // Proporciona funcionalidades adicionales de persistencia.
import org.springframework.http.HttpStatus // Importa las respuestas HTTP para manejar errores.
import org.springframework.stereotype.Service // Marca esta clase como un servicio de Spring.
import org.springframework.web.server.ResponseStatusException // Permite lanzar excepciones personalizadas con códigos de estado HTTP.
import java.util.* // Importa UUID y otras utilidades necesarias.

@Service // Indica que esta clase es un servicio gestionado por Spring.
class AdminServiceImpl(
    //2) Inyección del repositorio de Admin para acceder a las operaciones de base de datos.
    private val repository: AdminRepository
): AdminService { // Implementa la interfaz AdminService para definir el comportamiento de los métodos.

    //1) Implementación de los métodos definidos en la interfaz AdminService.
    override fun findAll(): List<Admin> {
        //3) Método que devuelve una lista de todos los Admins desde el repositorio.
        return repository.findAll() // Llama al método findAll del repositorio para obtener todos los Admins.
    }

    override fun findByUuid(uuid: UUID): Admin {
        // Método para buscar un Admin específico por UUID.
        return  repository.findById(uuid).orElseThrow{
            // Si no encuentra el Admin, lanza una excepción HTTP 422 (Entidad no procesable).
            throw ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY)
        }
    }

    override fun create(admin: Admin): Admin {
        // Método para crear un nuevo Admin. Guarda el objeto Admin en la base de datos.
        return repository.save(admin)
    }

    override fun update(admin: Admin): Admin {
        // Método para actualizar un Admin existente. Guarda los cambios del Admin en la base de datos.
        return  repository.save(admin)
    }

    override fun deleted(admin: Admin) {
        // Método para eliminar un Admin. Utiliza el método delete del repositorio.
        return repository.delete(admin)
    }

    override fun login(login: LoginDto): Admin {
        // Método para manejar el inicio de sesión. Verifica si el nombre y la contraseña coinciden.
        return  repository.findFirstByNombreAndPassword(login.username!!, login.password!!).orElseThrow{
            // Si las credenciales no coinciden, lanza una excepción HTTP 401 (No autorizado) con un mensaje personalizado.
            throw ResponseStatusException(HttpStatus.UNAUTHORIZED,"Credenciales No Válidas")
        }
    }
}
