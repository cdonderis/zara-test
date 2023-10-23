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