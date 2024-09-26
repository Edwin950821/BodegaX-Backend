package com.edwin.bodega_x.controller // Paquete donde se encuentra el controlador de ventas de productos

import com.edwin.bodega_x.model.ProductoVenta // Importa el modelo de venta de producto
import com.edwin.bodega_x.service.productoVenta.ProductoVentaService // Importa el servicio de ventas de productos
import org.springframework.web.bind.annotation.CrossOrigin // Importa la anotación para habilitar el soporte de CORS
import org.springframework.web.bind.annotation.DeleteMapping // Importa la anotación para manejar solicitudes DELETE
import org.springframework.web.bind.annotation.GetMapping // Importa la anotación para manejar solicitudes GET
import org.springframework.web.bind.annotation.PathVariable // Importa la anotación para manejar variables de ruta
import org.springframework.web.bind.annotation.PostMapping // Importa la anotación para manejar solicitudes POST
import org.springframework.web.bind.annotation.PutMapping // Importa la anotación para manejar solicitudes PUT
import org.springframework.web.bind.annotation.RequestBody // Importa la anotación para el cuerpo de la solicitud
import org.springframework.web.bind.annotation.RequestMapping // Importa la anotación para mapear solicitudes a un controlador
import org.springframework.web.bind.annotation.RestController // Importa la anotación para definir un controlador REST
import java.util.* // Importa la clase UUID

@RestController // Indica que esta clase es un controlador REST
@CrossOrigin("*") // Habilita CORS para todas las rutas
@RequestMapping("producto-ventas") // Establece la ruta base para este controlador
class ProductoVentaController(
    private val service: ProductoVentaService // Inyección del servicio de ventas de productos
) {
    @GetMapping("/all") // Maneja las solicitudes GET para obtener todas las ventas de productos
    fun findAll(): List<ProductoVenta> {
        return service.findAll() // Llama al servicio para obtener la lista de ventas de productos
    }

    @GetMapping("/{uuid}") // Maneja las solicitudes GET para obtener una venta de producto específica por UUID
    fun findOne(@PathVariable uuid: UUID): ProductoVenta {
        return service.findByUuid(uuid) // Llama al servicio para obtener la venta de producto por UUID
    }

    @PostMapping("/create") // Maneja las solicitudes POST para crear una nueva venta de producto
    fun create(@RequestBody productoVenta: ProductoVenta): ProductoVenta {
        return service.create(productoVenta) // Llama al servicio para crear la venta de producto
    }

    @PutMapping("/edit") // Maneja las solicitudes PUT para editar una venta de producto existente
    fun edit(@RequestBody productoVenta: ProductoVenta): ProductoVenta {
        return service.update(productoVenta) // Llama al servicio para actualizar la venta de producto
    }

    @DeleteMapping("/delete") // Maneja las solicitudes DELETE para eliminar una venta de producto
    fun delete(@RequestBody productoVenta: ProductoVenta) {
        service.deleted(productoVenta) // Llama al servicio para eliminar la venta de producto
    }
}
