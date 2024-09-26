package com.edwin.bodega_x.controller // Paquete donde se encuentra el controlador de administración

import com.edwin.bodega_x.dto.LoginDto // Importa el DTO para el inicio de sesión
import com.edwin.bodega_x.model.Admin // Importa el modelo de administración
import com.edwin.bodega_x.service.admin.AdminService // Importa el servicio de administración
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
@RequestMapping("admin") // Establece la ruta base para este controlador
class AdminController(
    private val service: AdminService // Inyección del servicio de administración
) {
    @GetMapping("/all") // Maneja las solicitudes GET para obtener todos los administradores
    fun findAll(): List<Admin>{
        return service.findAll() // Llama al servicio para obtener la lista de administradores
    }

    @GetMapping("/{uuid}") // Maneja las solicitudes GET para obtener un administrador específico por UUID
    fun findOne(@PathVariable uuid:UUID): Admin{
        return service.findByUuid(uuid) // Llama al servicio para obtener el administrador por UUID
    }

    @PostMapping("/create") // Maneja las solicitudes POST para crear un nuevo administrador
    fun create(@RequestBody admin: Admin): Admin{
        return  service.create(admin) // Llama al servicio para crear el administrador
    }

    @PostMapping("/login") // Maneja las solicitudes POST para el inicio de sesión
    fun login (@RequestBody login: LoginDto): Admin{
        return service.login(login) // Llama al servicio para autenticar al administrador
    }

    @PutMapping("/edit") // Maneja las solicitudes PUT para editar un administrador existente
    fun edit(@RequestBody admin: Admin): Admin{
        return service.update(admin) // Llama al servicio para actualizar el administrador
    }

    @DeleteMapping("/delete") // Maneja las solicitudes DELETE para eliminar un administrador
    fun delete(@RequestBody admin: Admin){
        service.deleted(admin) // Llama al servicio para eliminar el administrador
    }
}
