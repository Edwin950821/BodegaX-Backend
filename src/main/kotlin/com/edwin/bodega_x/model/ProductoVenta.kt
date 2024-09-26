package com.edwin.bodega_x.model // Este paquete contiene las clases que representan los modelos de datos en la aplicación.

import org.hibernate.annotations.Where
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name="producto_ventas") // Indica que esta entidad se almacenará en la tabla "producto_ventas" de la base de datos.
@Entity // Marca la clase como una entidad JPA que representa una venta de producto en el sistema.
@Where(clause="deleted=false") // Aplica un filtro para que solo se recuperen los registros de ventas de productos que no han sido marcados como eliminados.
data class ProductoVenta( // Define una clase de datos que representa la relación entre productos y ventas.
        @Id // Marca la propiedad uuid como la clave primaria de la entidad.
        var uuid: UUID? = UUID.randomUUID(), // Asigna un identificador único a cada transacción de venta de producto, generando uno nuevo por defecto si no se proporciona.
        var uuidProducto: UUID? = null, // Almacena el identificador único del producto relacionado con esta venta, inicializado como null hasta que se asigne un valor.
        var uuidVenta: UUID? = null, // Guarda el identificador único de la venta a la que pertenece este producto, también inicializado como null.
        var cantidad: Int? = 0, // Representa la cantidad del producto vendido, inicializada en 0, ya que aún no se ha realizado ninguna venta.
        var totalParcial: Long? = 0, // Guarda el total parcial de la venta de este producto, que se calcula multiplicando el precio por la cantidad, inicializado en 0.
        var deleted: Boolean? = false // Indica si la venta de este producto ha sido eliminada, inicializada en false, lo que significa que está activa por defecto.
)
