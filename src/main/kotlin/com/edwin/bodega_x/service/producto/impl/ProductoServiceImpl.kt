package com.edwin.bodega_x.service.producto.impl // Paquete que contiene la implementación de los servicios de Producto.

import com.edwin.bodega_x.model.Producto // Importa la clase Producto que representa la entidad producto.
import com.edwin.bodega_x.repository.ProductoRepository // Importa el repositorio que proporciona acceso a la base de datos para la entidad Producto.
import com.edwin.bodega_x.service.producto.ProductoService // Importa la interfaz ProductoService que define los métodos para gestionar productos.
import org.springframework.http.HttpStatus // Importa HttpStatus para manejar códigos de estado HTTP.
import org.springframework.stereotype.Service // Importa la anotación para marcar esta clase como un servicio de Spring.
import org.springframework.web.server.ResponseStatusException // Importa la clase para manejar excepciones de estado HTTP en caso de errores.
import java.util.* // Importa utilidades como UUID.

@Service // Indica que esta clase es un servicio de Spring que contiene la lógica de negocio.
class ProductoServiceImpl(
    // Llamar al repositorio
    private val repository: ProductoRepository // Se inyecta el repositorio para acceder a las operaciones de la base de datos.
): ProductoService { // Implementa la interfaz ProductoService.

    // Implementación de métodos
    override fun findAll(): List<Producto> {
        // descripción de la función de los métodos
        return repository.findAll() // Devuelve una lista de todos los productos almacenados en la base de datos.
    }

    override fun findByUuid(uuid: UUID): Producto {
        // Llama al método findById del repositorio para buscar un producto por su UUID.
        return repository.findById(uuid).orElseThrow {
            // Si el producto no se encuentra, lanza una excepción con un estado HTTP 422 (Unprocessable Entity).
            throw ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY)
        }
    }

    override fun create(producto: Producto): Producto {
        // Guarda el nuevo producto en la base de datos y retorna el producto guardado.
        return repository.save(producto)
    }

    override fun update(producto: Producto): Producto {
        // Actualiza el producto existente en la base de datos y retorna el producto actualizado.
        return repository.save(producto)
    }

    override fun deleted(producto: Producto) {
        // Elimina el producto de la base de datos.
        return repository.delete(producto)
    }
}
