package com.edwin.bodega_x.model // Paquete donde se encuentra la clase que representa el modelo de datos Admin

import org.hibernate.annotations.Where // Importa la anotación para agregar cláusulas WHERE a las consultas
import java.util.UUID // Importa la clase UUID para manejar identificadores únicos
import javax.persistence.Entity // Importa la anotación para marcar esta clase como entidad JPA
import javax.persistence.Id // Importa la anotación para marcar la propiedad UUID como identificador
import javax.persistence.Table // Importa la anotación para definir la tabla de la base de datos

@Table(name="admins") // Especifica el nombre de la tabla en la base de datos
@Entity // Indica que esta clase es una entidad JPA
@Where(clause="deleted=false") // Agrega una cláusula WHERE para filtrar registros eliminados
data class Admin ( // Clase de datos que representa a un administrador
        @Id // Marca la propiedad uuid como el identificador de la entidad
        var uuid: UUID?=UUID.randomUUID(), // UUID único para cada administrador, se genera uno nuevo por defecto
        var role: String?="", // Rol del administrador (por ejemplo, "admin", "user"), inicializado como cadena vacía
        var nombre:String?= "", // Nombre del administrador, inicializado como cadena vacía
        var password: String?= "", // Contraseña del administrador, inicializada como cadena vacía
        var direccion: String?= "", // Dirección del administrador, inicializada como cadena vacía
        var stock: Int?= 0, // Stock o cantidad de productos que gestiona el administrador, inicializado en 0
        var deleted: Boolean?= false, // Indica si el registro ha sido eliminado, por defecto es false
        var id: String? = null // Identificador adicional, puede ser nulo
)
