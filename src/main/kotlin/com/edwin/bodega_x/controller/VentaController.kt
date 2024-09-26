package com.edwin.bodega_x.controller // Paquete donde se encuentra el controlador de ventas

import com.edwin.bodega_x.model.Venta // Importa el modelo de venta
import com.edwin.bodega_x.service.venta.VentaService // Importa el servicio de ventas
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
@RequestMapping("/ventas") // Establece la ruta base para este controlador
class VentaController(
    private val service: VentaService // Inyección del servicio de ventas
) {
    @GetMapping("/all") // Maneja las solicitudes GET para obtener todas las ventas
    fun findAll(): List<Venta> {
        return service.findAll() // Llama al servicio para obtener la lista de todas las ventas
    }

    @GetMapping("/{uuid}") // Maneja las solicitudes GET para obtener una venta específica por UUID
    fun findOne(@PathVariable uuid: UUID): Venta {
        return service.findByUuid(uuid) // Llama al servicio para obtener la venta por UUID
    }

    @PostMapping("/create") // Maneja las solicitudes POST para crear una nueva venta
    fun create(@RequestBody venta: Venta): Venta {
        return service.create(venta) // Llama al servicio para crear la nueva venta
    }

    @PutMapping("/edit") // Maneja las solicitudes PUT para editar una venta existente
    fun edit(@RequestBody venta: Venta): Venta {
        return service.update(venta) // Llama al servicio para actualizar la venta
    }

    @DeleteMapping("/delete") // Maneja las solicitudes DELETE para eliminar una venta
    fun delete(@RequestBody venta: Venta) {
        service.deleted(venta) // Llama al servicio para eliminar la venta
    }
}
