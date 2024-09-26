package com.edwin.bodega_x.service.cliente.impl // Paquete que contiene la implementación del servicio relacionado con la entidad Cliente.

import com.edwin.bodega_x.model.Cliente
import com.edwin.bodega_x.repository.ClienteRepository
import com.edwin.bodega_x.service.cliente.ClienteService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service // Anotación para que Spring registre esta clase como un servicio que puede ser inyectado en otras partes del sistema.
class ClienteServiceImpl(
    //2) Llama al repositorio para realizar operaciones con la base de datos.
    private val repository: ClienteRepository
): ClienteService { // Implementa la interfaz ClienteService, que define los métodos que deben ser desarrollados.

    //1) Implementación de los métodos declarados en ClienteService.

    override fun findAll(): List<Cliente> {
        //3) Utiliza el repositorio para obtener una lista de todos los clientes de la base de datos.
        return repository.findAll()
    }

    override fun findByUuid(uuid: UUID): Cliente {
        // Llama al método findById del repositorio para buscar un cliente por su UUID.
        return  repository.findById(uuid).orElseThrow{
            // Si no encuentra el cliente, lanza una excepción con el estado HTTP 422 (UNPROCESSABLE_ENTITY).
            throw ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY)
        }
    }

    override fun create(cliente: Cliente): Cliente {
        // Usa el método save del repositorio para guardar un nuevo cliente en la base de datos.
        return repository.save(cliente)
    }

    override fun update(cliente: Cliente): Cliente {
        // Usa el método save del repositorio para actualizar los datos de un cliente existente.
        return  repository.save(cliente)
    }

    override fun deleted(cliente: Cliente) {
        // Usa el método delete del repositorio para eliminar un cliente de la base de datos.
        return repository.delete(cliente)
    }
}
