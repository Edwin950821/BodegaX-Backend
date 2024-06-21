package com.edwin.bodega_x.service.producto

import com.edwin.bodega_x.model.Producto
import java.util.UUID

interface ProductoService {
    fun findAll(): List<Producto>
    fun findByUuid(uuid: UUID): Producto
    fun create(producto: Producto): Producto
    fun update(producto: Producto): Producto
    fun deleted(producto: Producto)
}