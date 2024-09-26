package com.edwin.bodega_x.controller // Paquete donde se encuentra el controlador de productos

import com.edwin.bodega_x.model.Producto // Importa el modelo de producto
import com.edwin.bodega_x.service.producto.ProductoService // Importa el servicio de productos
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
@RequestMapping("productos") // Establece la ruta base para este controlador
class ProductoController(
    private val service: ProductoService // Inyección del servicio de productos
) {
    @GetMapping("/all") // Maneja las solicitudes GET para obtener todos los productos
    fun findAll(): List<Producto>{
        return service.findAll() // Llama al servicio para obtener la lista de productos
    }

    @GetMapping("/{uuid}") // Maneja las solicitudes GET para obtener un producto específico por UUID
    fun findOne(@PathVariable uuid:UUID): Producto{
        return service.findByUuid(uuid) // Llama al servicio para obtener el producto por UUID
    }

    @PostMapping("/create") // Maneja las solicitudes POST para crear un nuevo producto
    fun create(@RequestBody producto: Producto): Producto{
        return  service.create(producto) // Llama al servicio para crear el producto
    }

    @PutMapping("/edit") // Maneja las solicitudes PUT para editar un producto existente
    fun edit(@RequestBody producto: Producto): Producto{
        return service.update(producto) // Llama al servicio para actualizar el producto
    }

    @DeleteMapping("/delete") // Maneja las solicitudes DELETE para eliminar un producto
    fun delete(@RequestBody producto: Producto){
        service.deleted(producto) // Llama al servicio para eliminar el producto
    }
}
