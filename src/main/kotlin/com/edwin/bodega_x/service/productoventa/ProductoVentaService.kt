package com.edwin.bodega_x.service.productoventa

import com.edwin.bodega_x.model.ProductoVenta
import java.util.UUID

interface ProductoVentaService {
    fun findAll(): List<ProductoVenta>
    fun findByUuid(uuid: UUID): ProductoVenta
    fun create(productoVenta: ProductoVenta): ProductoVenta
    fun update(productoVenta: ProductoVenta): ProductoVenta
    fun deleted(productoVenta: ProductoVenta)
}