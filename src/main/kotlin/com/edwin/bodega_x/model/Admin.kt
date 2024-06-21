package com.edwin.bodega_x.model

import org.hibernate.annotations.Where
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Table(name="admins")
@Entity
@Where(clause="deleted=false")
data class Admin (
        @Id
        var uuid: UUID?=UUID.randomUUID(),
        var nombre:String?= "",
        var direccion: String?= "",
        var stock: Int?= 0,
        var deleted: Boolean?= false

 )

