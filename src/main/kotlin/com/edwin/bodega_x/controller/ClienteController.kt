package com.edwin.bodega_x.controller // Paquete donde se encuentra el controlador de clientes

import com.edwin.bodega_x.model.Cliente // Importa el modelo de cliente
import com.edwin.bodega_x.service.cliente.ClienteService // Importa el servicio de clientes
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
@RequestMapping("clientes") // Establece la ruta base para este controlador
class ClienteController(
    private val service: ClienteService // Inyección del servicio de clientes
) {
    @GetMapping("/all") // Maneja las solicitudes GET para obtener todos los clientes
    fun findAll(): List<Cliente>{
        return service.findAll() // Llama al servicio para obtener la lista de clientes
    }

    @GetMapping("/{uuid}") // Maneja las solicitudes GET para obtener un cliente específico por UUID
    fun findOne(@PathVariable uuid: UUID): Cliente {
        return service.findByUuid(uuid) // Llama al servicio para obtener el cliente por UUID
    }

    @PostMapping("/create") // Maneja las solicitudes POST para crear un nuevo cliente
    fun create(@RequestBody cliente: Cliente): Cliente {
        return service.create(cliente) // Llama al servicio para crear el cliente
    }

    @PutMapping("/edit") // Maneja las solicitudes PUT para editar un cliente existente
    fun edit(@RequestBody cliente: Cliente): Cliente {
        return service.update(cliente) // Llama al servicio para actualizar el cliente
    }

    @DeleteMapping("/delete") // Maneja las solicitudes DELETE para eliminar un cliente
    fun delete(@RequestBody cliente: Cliente) {
        service.deleted(cliente) // Llama al servicio para eliminar el cliente
    }
}
