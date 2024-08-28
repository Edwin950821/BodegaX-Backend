package com.edwin.bodega_x.model

import org.hibernate.annotations.Where
import java.util.UUID
import javax.accessibility.AccessibleRole
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Table(name="admins")
@Entity
@Where(clause="deleted=false")
data class Admin (
        @Id
        var uuid: UUID?=UUID.randomUUID(),
        var role: String?="",
        var nombre:String?= "",
        var password: String?= "",
        var direccion: String?= "",
        var stock: Int?= 0,
        var deleted: Boolean?= false,
        var id: String? = null

 )

