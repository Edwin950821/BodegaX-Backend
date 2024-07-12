package com.edwin.bodega_x.service.productoVenta.impl

import com.edwin.bodega_x.model.ProductoVenta
import com.edwin.bodega_x.repository.ProductoVentaRepository
import com.edwin.bodega_x.service.productoVenta.ProductoVentaService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class ProductoVentaServiceImpl(
        //2) Llamar al repositorio
        private val repository: ProductoVentaRepository
): ProductoVentaService {
    //1) Implementacion de metodos
    override fun findAll(): List<ProductoVenta> {
        //3) descripcion de la funciones de los metodos
        return repository.findAll()
    }

    override fun findByUuid(uuid: UUID): ProductoVenta {
        //llama al metodo finById del repository
        return  repository.findById(uuid).orElseThrow{
            //si en caso tal da error se utiliza orElseThrow para especificar el error en la app
            throw ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY)
        }
    }

    override fun create(productoVenta: ProductoVenta): ProductoVenta {
        return repository.save(productoVenta)
    }

    override fun update(productoVenta: ProductoVenta): ProductoVenta {
        return  repository.save(productoVenta)
    }

    override fun deleted(productoVenta: ProductoVenta) {
        return repository.delete(productoVenta)
    }
}