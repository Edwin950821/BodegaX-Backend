package com.edwin.bodega_x.model // Este paquete contiene las clases que representan los modelos de datos de la aplicación.

import org.hibernate.annotations.Where
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name="clientes") // Especifica que esta entidad se almacenará en la tabla "clientes" de la base de datos.
@Entity // Marca la clase como una entidad JPA que se puede persistir en la base de datos.
@Where(clause="deleted=false") // Agrega un filtro para que solo se recuperen los registros que no han sido marcados como eliminados.
data class Cliente ( // Define una clase de datos que representa a un cliente en el sistema.
        @Id // Indica que la propiedad uuid es la clave primaria de la entidad.
        var uuid: UUID?=UUID.randomUUID(), // Asigna un identificador único al cliente, generando uno nuevo por defecto si no se proporciona.
        var nombre:String?= "", // Almacena el nombre del cliente, inicializado como una cadena vacía.
        var direccion: String?= "", // Almacena la dirección del cliente, también inicializada como una cadena vacía.
        var deleted: Boolean?= false // Indica si el cliente ha sido eliminado, por defecto se establece en false.
)
