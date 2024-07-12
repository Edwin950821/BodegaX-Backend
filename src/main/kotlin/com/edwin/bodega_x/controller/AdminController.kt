package com.edwin.bodega_x.controller

import com.edwin.bodega_x.dto.LoginDto
import com.edwin.bodega_x.model.Admin
import com.edwin.bodega_x.service.admin.AdminService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
@CrossOrigin("*")
@RequestMapping("admin")
class AdminController(             
        private val service: AdminService
) {
    @GetMapping("/all")
    fun findAll(): List<Admin>{
        return service.findAll()
    }

    @GetMapping("/{uuid}")
    fun findOne(@PathVariable uuid:UUID): Admin{
        return service.findByUuid(uuid)
    }

    @PostMapping("/create")
    fun create(@RequestBody admin: Admin): Admin{
        return  service.create(admin)
    }

    @PostMapping("/login")
    fun login (@RequestBody login: LoginDto): Admin{
        return service.login(login)
    }

    @PutMapping("/edit")
    fun edit(@RequestBody admin: Admin): Admin{
        return service.update(admin)
    }

    @DeleteMapping("/delete")
    fun delete(@RequestBody admin: Admin){
        service.deleted(admin)
    }

}