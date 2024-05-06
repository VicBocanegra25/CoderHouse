# Projecto Final - Aplicación Restful con Spring Boot
## Descripción
Este proyecto presenta una aplicación Restful, creada en Java y utilizando el framework Spring Boot. 
La aplicación consiste en un sistema de compras, en el cual se maneja información sobre los clientes, productos y compras. 
El proyecto utiliza el modelo de capas para abstraer la funcionalidad de cada clase: 
- Las entidades se definen dentro de los modelos. 
- Cada entidad cuenta con un repositorio, el cual se encarga de realizar las operaciones CRUD en la BD.
- Los servicios se encargan de la lógica de negocio.
- Los controladores se encargan de recibir las peticiones y enviar las respuestas.

## Entidades
La aplicación cuenta con las siguientes entidades: 
- Cliente
- Producto
- Compra
- Comprobante

## Consideraciones
De acuerdo a las especificaciones del proyecto (dictadas por CoderHouse), existen ciertas reglas
que se deben cumplir al realizar una operación de compra.
- Se deben manejar correctamente las excepciones (por ejemplo, si se queire comprar más productos de los que hay en existencia).
- Las compras llaman una API externa para obtener la fecha. 
- Los clientes y productos cuentan con todas las operaciones CRUD, pero la compra no se puede modificar. 
- Se documenta la aplicación utilizando Swagger.
- El proyecto se encuentra en formato jar ejecutable dentro de la carpeta target

## Requests - Resposnes
Todas las operaciones a realizar se realizaron en POSTMAN y se exportaron en la carpeta 'Postman'.

## Swagger
Se puede acceder a la documentación a través del siguiente enlace: http://localhost:8080/swagger-ui/index.html#/
