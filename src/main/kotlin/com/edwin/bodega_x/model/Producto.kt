package com.edwin.bodega_x.model // Este paquete contiene las clases que representan los modelos de datos en la aplicación.

import org.hibernate.annotations.Where
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name="productos") // Indica que esta entidad se almacenará en la tabla "productos" de la base de datos.
@Entity // Marca la clase como una entidad JPA que representa un producto en el sistema.
@Where(clause="deleted=false") // Aplica un filtro para que solo se recuperen los registros de productos que no han sido marcados como eliminados.
data class Producto( // Define una clase de datos que representa un producto en el sistema.
        @Id // Marca la propiedad uuid como la clave primaria de la entidad.
        var uuid: UUID? = UUID.randomUUID(), // Asigna un identificador único al producto, generando uno nuevo por defecto si no se proporciona.
        var nombre: String? = null, // Almacena el nombre del producto, inicializado como null, permitiendo que se asigne un valor posteriormente.
        var precio: Double? = null, // Guarda el precio del producto, también inicializado como null para que pueda ser definido más tarde.
        var stock: Int? = 0, // Representa la cantidad disponible del producto en stock, se inicializa en 0.
        var deleted: Boolean? = false // Indica si el producto ha sido eliminado, inicializado en false, por lo que se considera activo por defecto.
)
