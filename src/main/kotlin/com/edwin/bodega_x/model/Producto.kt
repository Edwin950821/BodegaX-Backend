package com.edwin.bodega_x.model

import org.hibernate.annotations.Where
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Table(name="productos")
@Entity
@Where(clause="deleted=false")
data class Producto(
        @Id
        var uuid: UUID?=UUID.randomUUID(),
        var uuidVenta:UUID?= null ,
        var uuidProducto:UUID?= null,
        var cantidad:Long?= 0,
        var valorParcial:Double,
        var deleted: Boolean?= false


)