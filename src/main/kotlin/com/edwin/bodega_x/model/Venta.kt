package com.edwin.bodega_x.model

import org.hibernate.annotations.Where
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Table(name="ventas")
@Entity
@Where(clause="deleted=false")
data class Venta (
        @Id
        var uuid: UUID?=UUID.randomUUID(),
        var uuidAdmin:UUID?= null ,
        var uuidCliente: UUID?= null,
        var totalVenta: Double?= 0.0,
        var deleted: Boolean?= false

)