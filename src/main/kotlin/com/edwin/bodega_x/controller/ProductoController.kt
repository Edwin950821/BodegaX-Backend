package com.edwin.bodega_x.controller

import com.edwin.bodega_x.model.Producto
import com.edwin.bodega_x.service.producto.ProductoService
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
@RequestMapping("productos")
class ProductoController(
        private val service: ProductoService
) {
    @GetMapping("/all")
    fun findAll(): List<Producto>{
        return service.findAll()
    }

    @GetMapping("/{uuid}")
    fun findOne(@PathVariable uuid:UUID): Producto{
        return service.findByUuid(uuid)
    }

    @PostMapping("/create")
    fun create(@RequestBody producto: Producto): Producto{
        return  service.create(producto)
    }

    @PutMapping("/edit")
    fun edit(@RequestBody producto: Producto): Producto{
        return service.update(producto)
    }

    @DeleteMapping("/delete")
    fun delete(@RequestBody producto: Producto){
        service.deleted(producto)
    }

}