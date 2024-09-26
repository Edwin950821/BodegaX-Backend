package com.edwin.bodega_x // Paquete principal donde se encuentra la aplicación BodegaX.

import org.springframework.boot.autoconfigure.SpringBootApplication // Importa la anotación para habilitar la configuración automática de Spring Boot.
import org.springframework.boot.runApplication // Importa la función para iniciar la aplicación Spring Boot.

@SpringBootApplication // Anotación que indica que esta es la clase principal de la aplicación Spring Boot, habilitando la configuración automática.
class BodegaXApplication // Clase principal de la aplicación. No necessitate contenido adicional por el momento.

fun main(args: Array<String>) { // Método principal que sirve como punto de entrada para la aplicación.
	runApplication<BodegaXApplication>(*args) // Inicia la aplicación Spring Boot con la clase BodegaXApplication y los argumentos pasados.
}


