package com.edwin.bodega_x.controller

import com.edwin.bodega_x.model.Cliente
import com.edwin.bodega_x.service.cliente.ClienteService
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
@CrossOrigin
@RequestMapping("clientes")
class ClienteController(
        private val service: ClienteService
) {
    @GetMapping("/all")
    fun findAll(): List<Cliente>{
        return service.findAll()
    }

    @GetMapping("/{uuid}")
    fun findOne(@PathVariable uuid:UUID): Cliente{
        return service.findByUuid(uuid)
    }

    @PostMapping("/create")
    fun create(@RequestBody cliente: Cliente): Cliente{
        return  service.create(cliente)
    }

    @PutMapping("/edit")
    fun edit(@RequestBody cliente: Cliente): Cliente{
        return service.update(cliente)
    }

    @DeleteMapping("/delete")
    fun delete(@RequestBody cliente: Cliente){
        service.deleted(cliente)
    }

}