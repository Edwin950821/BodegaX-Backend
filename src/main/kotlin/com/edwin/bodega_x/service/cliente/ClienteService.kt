package com.edwin.bodega_x.service.cliente // Paquete que contiene la definición de la interfaz para los servicios relacionados con Cliente.

import com.edwin.bodega_x.model.Cliente
import java.util.*

interface ClienteService {
    // Define la interfaz ClienteService que contiene los métodos para gestionar los clientes en la aplicación.

    fun findAll(): List<Cliente>
    // Método que deberá retornar una lista con todos los clientes de la base de datos.

    fun findByUuid(uuid: UUID): Cliente
    // Método que recibe un UUID y retorna un cliente específico que coincida con ese UUID.

    fun create(cliente: Cliente): Cliente
    // Método que deberá crear un nuevo cliente y retornar el cliente creado.

    fun update(cliente: Cliente): Cliente
    // Método que actualiza la información de un cliente existente y devuelve el cliente actualizado.

    fun deleted(cliente: Cliente)
    // Método que elimina o marca como eliminado a un cliente.
}
