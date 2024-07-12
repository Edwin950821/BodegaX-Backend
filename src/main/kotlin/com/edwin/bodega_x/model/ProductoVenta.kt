package com.edwin.bodega_x.model

import org.hibernate.annotations.Where
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Table(name="producto_ventas")
@Entity
@Where(clause="deleted=false")
data class ProductoVenta (
        @Id
        var uuid: UUID?=UUID.randomUUID(),
        var uuidProducto: UUID?=null,
        var uuidVenta:UUID?= null ,
        var cantidad: Int?= 0,
        var totalParcial: Long?=0,
        var deleted: Boolean?= false

)

