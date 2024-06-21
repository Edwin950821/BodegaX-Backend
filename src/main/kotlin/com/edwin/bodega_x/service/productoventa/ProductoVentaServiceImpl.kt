package com.edwin.bodega_x.service.productoventa

import com.edwin.bodega_x.model.Producto
import com.edwin.bodega_x.repository.ProductoRepository
import com.edwin.bodega_x.service.producto.ProductoService
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException
import java.util.*

class ProductoVentaServiceImpl(
        //2) Llamar al repositorio
        private val repository: ProductoRepository
): ProductoService {
    //1) Implementacion de metodos
    override fun findAll(): List<Producto> {
        //3) descripcion de la funciones de los metodos
        return repository.findAll()
    }

    override fun findByUuid(uuid: UUID): Producto {
        //llama al metodo finById del repository
        return  repository.findById(uuid).orElseThrow{
            //si en caso tal da error se utiliza orElseThrow para especificar el error en la app
            throw ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY)
        }
    }

    override fun create(producto: Producto): Producto {
        return repository.save(producto)
    }

    override fun update(producto: Producto): Producto {
        return  repository.save(producto)
    }

    override fun deleted(producto: Producto) {
        return repository.delete(producto)
    }
}