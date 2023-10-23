# Prueba técnica Minsait

## Estructura del proyecto

La estructura del proyecto se ha generado a partir de https://start.spring.io.
Como gestor de proyecto se ha seleccionado Maven y la versión 8 de Java.</br>
Las dependencias que se han añadido son:

    1.Spring Data JPa.

    2.Spring Web.
    
    3.Spring Web DevTools
    
    4.H2 Database.

## Base de datos H2

Se ha utilizado una base de datos embebida H2 que contiene los datos en los ficheros:

    schema.sql  --> Contiene los scripts DDL para la estructura de las tablas que se van a utilizar en el proyecto.    
    
    data.sql    --> Contiene los scripts DML con los registros a insertar proporcionados en el enunciado de la prueba.

## Patrón de diseño

He escogido Pattern Repository como patrón de diseño ya que es con el que más familiarizado estoy. Cada capa de la
aplicación está organizada por carpetas (entity, repository, service,resource).

Este patrón además del desacoplamiento de capas permite la encapsulación de métodos gracias al uso de interfaces,
por lo que a la hora de implementar la lógica de negocio, solo se permite el uso de los métodos proporcionados por la
interfaz correspondiente. Además facilita la futura escalabilidad y mantenibilidad del código ya que se pueden localizar
rápidamente los métodos que no se están utilizando e implementar de forma sencilla otros nuevos.

## Data Transfer Object

En el enunciado se pide mostrar solo algunos de los datos que obtenemos de nuestra BBDD, no obstante para trabajar con
estos datos de forma interna si que se necesitan todos los atributos, por ello he creado un DTO del entity Price para
ocultar los campos que no necesito para la funcionalidad solicitada.

## Ejecutar aplicación
El puerto definido para el despliegue en local es el 8080.

Para limpiar target y volver a compilar e instalar las dependencias `./mvnw clean install`

Para iniciar la aplicación utilizar el comando `./mvnw spring-boot:run`

Las pruebas unitarias se han desarrollado con JUnit. Si se desea ejecutar unicamente los test utilizar el comando `./mvnw test`

Al iniciar la aplicación se deben mostrar todos los registros añadidos en la base de datos embebida.

## Observaciones
Solo he desarrollado excepciones en la capa de servicio para no tener que implementar un tipo de Exception por cada capa.
En caso de error he devuelto un mensaje en la petición ya que no se trata de una aplicación real, no obstante suelo
trabajar con códigos de error que luego gestiona el front para no dejar rastro del error y evitar vulnerabilidades.

## Ejecución de Endpoints
En caso de tener el puerto 8080 ocupado añadir `server.port=puerto` en el application.properties cambiando "puerto" por la dirección deseada.

Para hacer pruebas de peticiones hay que introducir esta URL en el navegador:

`http://localhost:8080/price/allPrices`

`http://localhost:8080/price/filter/2020-06-15-17:00:00/35455/1`

Adjunto el fichero postman_collection.json por si se desean importar los endpoint en Postman y ejecutarlos desde ahí.
