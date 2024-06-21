package com.edwin.bodega_x.service.venta

import com.edwin.bodega_x.model.Venta
import java.util.UUID

interface VentaService {
    fun findAll(): List<Venta>
    fun findByUuid(uuid: UUID): Venta
    fun create(venta: Venta): Venta
    fun update(venta: Venta): Venta
    fun deleted(venta: Venta)
}