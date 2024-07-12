package com.edwin.bodega_x.controller

import com.edwin.bodega_x.model.ProductoVenta
import com.edwin.bodega_x.service.productoVenta.ProductoVentaService
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
@RequestMapping("producto-ventas")
class ProductoVentaController(
        private val service: ProductoVentaService
) {
    @GetMapping("/all")
    fun findAll(): List<ProductoVenta>{
        return service.findAll()
    }

    @GetMapping("/{uuid}")
    fun findOne(@PathVariable uuid:UUID): ProductoVenta{
        return service.findByUuid(uuid)
    }

    @PostMapping("/create")
    fun create(@RequestBody productoVenta: ProductoVenta): ProductoVenta{
        return  service.create(productoVenta)
    }

    @PutMapping("/edit")
    fun edit(@RequestBody productoVenta: ProductoVenta): ProductoVenta{
        return service.update(productoVenta)
    }

    @DeleteMapping("/delete")
    fun delete(@RequestBody productoVenta: ProductoVenta){
        service.deleted(productoVenta)
    }

}