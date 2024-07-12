package com.edwin.bodega_x.controller

import com.edwin.bodega_x.model.Venta
import com.edwin.bodega_x.service.venta.VentaService
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
@RequestMapping("ventas")
class VentaController(
        private val service: VentaService
) {
    @GetMapping("/all")
    fun findAll(): List<Venta>{
        return service.findAll()
    }

    @GetMapping("/{uuid}")
    fun findOne(@PathVariable uuid:UUID): Venta{
        return service.findByUuid(uuid)
    }

    @PostMapping("/create")
    fun create(@RequestBody venta: Venta): Venta{
        return  service.create(venta)
    }

    @PutMapping("/edit")
    fun edit(@RequestBody venta: Venta): Venta{
        return service.update(venta)
    }

    @DeleteMapping("/delete")
    fun delete(@RequestBody venta: Venta){
        service.deleted(venta)
    }

}