package com.edwin.bodega_x.service.admin // Paquete que agrupa las interfaces y servicios relacionados con la entidad Admin.

import com.edwin.bodega_x.dto.LoginDto
import com.edwin.bodega_x.model.Admin
import java.util.*

interface AdminService { // Definición de la interfaz que establece los métodos de servicio relacionados con Admin.

    // Método que devuelve una lista de todos los objetos Admin almacenados en la base de datos.
    fun findAll(): List<Admin>

    // Método que busca un Admin en la base de datos por su UUID.
    fun findByUuid(uuid: UUID): Admin

    // Método que permite crear un nuevo Admin en la base de datos.
    fun create(admin: Admin): Admin

    // Método que actualiza un Admin existente en la base de datos.
    fun update(admin: Admin): Admin

    // Método que elimina un Admin de la base de datos.
    fun deleted(admin: Admin)

    // Método para manejar el inicio de sesión, toma un objeto LoginDto y devuelve un Admin si las credenciales son válidas.
    fun login(login: LoginDto): Admin
}
