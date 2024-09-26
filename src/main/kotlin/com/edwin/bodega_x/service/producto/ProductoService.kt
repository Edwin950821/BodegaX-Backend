package com.edwin.bodega_x.service.producto // Paquete que contiene la definición de la interfaz para los servicios relacionados con Producto.

import com.edwin.bodega_x.model.Producto
import java.util.*

interface ProductoService {
    // Define la interfaz ProductoService que contiene los métodos para gestionar los productos en la aplicación.

    fun findAll(): List<Producto>
    // Método que retorna una lista de todos los productos disponibles en la base de datos.

    fun findByUuid(uuid: UUID): Producto
    // Método que busca un producto específico utilizando su UUID y retorna dicho producto.

    fun create(producto: Producto): Producto
    // Método que permite crear un nuevo producto en la base de datos y devuelve el producto creado.

    fun update(producto: Producto): Producto
    // Método que actualiza la información de un producto existente y retorna el producto actualizado.

    fun deleted(producto: Producto)
    // Método que elimina o marca como eliminado a un producto en la base de datos.
}
