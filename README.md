# coworking_reservas
Sistema de reservas
# Sistema de Reservas Coworking

Aplicación web desarrollada como parte de un parcial de Programación Web Backend.  
El sistema permite registrar, visualizar y eliminar reservas de espacios de trabajo en un coworking.

## Tecnologías utilizadas

- Java
- JSP
- Servlets
- JPA (Java Persistence API)
- MySQL
- Apache Tomcat

## Funcionalidades

- Crear reservas de espacios de trabajo
- Mostrar lista de reservas
- Eliminar reservas
- Validación de campos en el formulario

## Configuración de la Base de Datos

Antes de ejecutar el proyecto es necesario crear la base de datos en MySQL.

### 1. Crear la base de datos
```sql
CREATE DATABASE reservas_coworking;

###2. Seleccionar la base de datos

###3. Crear la tabla utilizada por la aplicación

CREATE TABLE claseReserva (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(100),
    fecha_reserva VARCHAR(50),
    espacio_trabajo VARCHAR(50),
    duracion VARCHAR(50)
);
----------
## Ejecución del proyecto

Clonar el repositorio.

Importar el proyecto en NetBeans.

Configurar la conexión a la base de datos MySQL.

Ejecutar el proyecto en Apache Tomcat.

Abrir el navegador y acceder a:

http://localhost:8080/reservas_coworkingg
