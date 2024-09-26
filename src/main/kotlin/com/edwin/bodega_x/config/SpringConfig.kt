package com.edwin.bodega_x.config // Paquete donde se encuentra la clase de configuración

import org.springframework.context.annotation.Configuration // Importa la anotación para marcar esta clase como configuración de Spring
import org.springframework.scheduling.annotation.EnableAsync // Importa la anotación para habilitar métodos asíncronos
import org.springframework.scheduling.annotation.EnableScheduling // Importa la anotación para habilitar la programación de tareas

@Configuration // Indica que esta clase proporciona configuraciones para el contexto de la aplicación
@EnableScheduling // Habilita la capacidad de programar tareas en la aplicación
@EnableAsync // Permite la ejecución de métodos de forma asíncrona, lo que permite mejorar la eficiencia y la capacidad de respuesta
class SpringConfig { // Clase de configuración principal
}
