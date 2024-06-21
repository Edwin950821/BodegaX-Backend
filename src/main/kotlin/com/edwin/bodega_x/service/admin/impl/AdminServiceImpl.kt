package com.edwin.bodega_x.service.admin.impl

import com.edwin.bodega_x.model.Admin
import com.edwin.bodega_x.repository.AdminRepository
import com.edwin.bodega_x.service.admin.AdminService
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException
import java.util.*

class AdminServiceImpl(
        //2) Llamar al repositorio
        private val repository: AdminRepository
): AdminService {
    //1) Implementacion de metodos
    override fun findAll(): List<Admin> {
        //3) descripcion de la funciones de los metodos
        return repository.findAll()
    }

    override fun findByUuid(uuid: UUID): Admin {
        //llama al metodo finById del repository
        return  repository.findById(uuid).orElseThrow{
            //si en caso tal da error se utiliza orElseThrow para especificar el error en la app
            throw ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY)
        }
    }

    override fun create(admin: Admin): Admin {
        return repository.save(admin)
    }

    override fun update(admin: Admin): Admin {
        return  repository.save(admin)
    }

    override fun deleted(admin: Admin) {
        return repository.delete(admin)
    }
}