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
        var nombre:String?= null ,
        var precio:Double?= null,
        var stock:Int?= 0,
        var deleted: Boolean?= false


)