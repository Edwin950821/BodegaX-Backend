package com.edwin.bodega_x.service.cliente

import com.edwin.bodega_x.model.Cliente
import java.util.UUID

interface ClienteService {
    fun findAll(): List<Cliente>
    fun findByUuid(uuid: UUID): Cliente
    fun create(cliente: Cliente): Cliente
    fun update(cliente: Cliente): Cliente
    fun deleted(cliente: Cliente)
}