package com.edwin.bodega_x.model // Este paquete contiene las clases de modelo que representan las entidades de la base de datos.

import org.hibernate.annotations.Where
import java.time.LocalDate
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name="ventas") // Indica que la entidad 'Venta' se almacenará en la tabla "ventas".
@Entity // Marca esta clase como una entidad JPA, lo que significa que puede ser gestionada por el framework de persistencia de Spring.
@Where(clause="deleted=false") // Aplica un filtro a nivel de base de datos para que solo se recuperen las ventas que no estén marcadas como eliminadas.
data class Venta( // Define la clase de datos que representa una venta en el sistema.
        @Id // Indica que el campo uuid será la clave primaria de la tabla.
        var uuid: UUID? = UUID.randomUUID(), // Clave primaria generada automáticamente como un identificador único para cada venta.
        var uuidAdmin: UUID? = null, // Identificador único del administrador que procesó la venta, inicialmente null hasta ser asignado.
        var uuidCliente: UUID? = null, // Identificador único del cliente asociado con la venta, inicialmente null.
        var totalVenta: Long? = 0, // Almacena el monto total de la venta, comenzando con un valor inicial de 0.
        var deleted: Boolean? = false, // Indica si la venta ha sido eliminada, false por defecto, lo que significa que la venta es activa.
        var fecha: LocalDate? = null // Fecha en la que se realizó la venta, almacenada como un objeto LocalDate. Inicialmente null.
)
