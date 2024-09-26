package com.edwin.bodega_x.service.venta // Paquete que agrupa la lógica de negocio para la gestión de ventas.

import com.edwin.bodega_x.model.Venta
import java.util.*

interface VentaService { // Interfaz que define las operaciones disponibles para gestionar ventas.
    fun findAll(): List<Venta> // Método para obtener una lista de todas las ventas registradas en el sistema.
    fun findByUuid(uuid: UUID): Venta // Método para buscar una venta específica utilizando su identificador único (UUID).
    fun create(venta: Venta): Venta // Método para crear una nueva venta, retornando la instancia de la venta creada.
    fun update(venta: Venta): Venta // Método para actualizar los detalles de una venta existente, retornando la venta actualizada.
    fun deleted(venta: Venta) // Método para eliminar una venta del sistema, asegurando que ya no esté disponible.
}
