package com.edwin.bodega_x.model

import org.hibernate.annotations.Where
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Table(name="clientes")
@Entity
@Where(clause="deleted=false")
data class Cliente (
        @Id
        var uuid: UUID?=UUID.randomUUID(),
        var nombre:String?= "",
        var direccion: String?= "",
        var deleted: Boolean?= false

 )

