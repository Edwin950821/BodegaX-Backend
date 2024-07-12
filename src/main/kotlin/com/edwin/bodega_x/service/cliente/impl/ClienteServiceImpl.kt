package com.edwin.bodega_x.service.cliente.impl

import com.edwin.bodega_x.model.Cliente
import com.edwin.bodega_x.repository.ClienteRepository
import com.edwin.bodega_x.service.cliente.ClienteService
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class ClienteServiceImpl(
        //2) Llamar al repositorio
        private val repository: ClienteRepository
): ClienteService {
    //1) Implementacion de metodos
    override fun findAll(): List<Cliente> {
        //3) descripcion de la funciones de los metodos
        return repository.findAll()
    }

    override fun findByUuid(uuid: UUID): Cliente {
        //llama al metodo finById del repository
        return  repository.findById(uuid).orElseThrow{
            //si en caso tal da error se utiliza orElseThrow para especificar el error en la app
            throw ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY)
        }
    }

    override fun create(cliente: Cliente): Cliente {
        return repository.save(cliente)
    }

    override fun update(cliente: Cliente): Cliente {
        return  repository.save(cliente)
    }

    override fun deleted(cliente: Cliente) {
        return repository.delete(cliente)
    }
}