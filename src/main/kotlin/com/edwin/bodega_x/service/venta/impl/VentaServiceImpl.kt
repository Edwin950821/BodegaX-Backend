package com.edwin.bodega_x.service.venta.impl

import com.edwin.bodega_x.model.Venta
import com.edwin.bodega_x.repository.VentaRepository
import com.edwin.bodega_x.service.venta.VentaService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class VentaServiceImpl(
        //2) Llamar al repositorio
        private val repository: VentaRepository
): VentaService {
    //1) Implementacion de metodos
    override fun findAll(): List<Venta> {
        //3) descripcion de la funciones de los metodos
        return repository.findAll()
    }

    override fun findByUuid(uuid: UUID): Venta {
        //llama al metodo finById del repository
        return  repository.findById(uuid).orElseThrow{
            //si en caso tal da error se utiliza orElseThrow para especificar el error en la app
            throw ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY)
        }
    }

    override fun create(venta: Venta): Venta {
        return repository.save(venta)
    }

    override fun update(venta: Venta): Venta {
        return  repository.save(venta)
    }

    override fun deleted(venta: Venta) {
        return repository.delete(venta)
    }
}