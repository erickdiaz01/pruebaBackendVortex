# Proyecto Base Implementando Clean Architecture

## Pasos previos necesarios para levantar el servicio:

* Crear la base de datos MySQL 'vortex' de manera local para conectar el servicio
* El servicio REST esta construido y configurado de tal manera que cuando se ejecute la MainApplication va a crear y actualizar las tablas de las entidades requeridas en el sistema, esto gracias a la configuracion de JPA/hibernate ddl-auto update.




## Antes de Iniciar

Empezaremos por explicar los diferentes componentes del proyectos y partiremos de los componentes externos, continuando con los componentes core de negocio (dominio) y por �ltimo el inicio y configuraci�n de la aplicaci�n.

Lee el art�culo [Clean Architecture � Aislando los detalles](https://medium.com/bancolombia-tech/clean-architecture-aislando-los-detalles-4f9530f35d7a)

# Arquitectura

![Clean Architecture](https://miro.medium.com/max/1400/1*ZdlHz8B0-qu9Y-QO3AXR_w.png)

## Domain

Es el m�dulo m�s interno de la arquitectura, pertenece a la capa del dominio y encapsula la l�gica y reglas del negocio mediante modelos y entidades del dominio.
![entidad](images/Captura%20de%20pantalla%202023-06-20%20034318.jpg)

![repositorio](images/Captura%20de%20pantalla%202023-06-20%20034435.jpg)
## Usecases

Este m�dulo gradle perteneciente a la capa del dominio, implementa los casos de uso del sistema, define l�gica de aplicaci�n y reacciona a las invocaciones desde el m�dulo de entry points, orquestando los flujos hacia el m�dulo de entities.

![casodeuso](images/Captura%20de%20pantalla%202023-06-20%20034530.jpg)

![test](images/Captura%20de%20pantalla%202023-06-20%20034651.jpg)

## Infrastructure

### Helpers

En el apartado de helpers tendremos utilidades generales para los Driven Adapters y Entry Points.

Estas utilidades no est�n arraigadas a objetos concretos, se realiza el uso de generics para modelar comportamientos
gen�ricos de los diferentes objetos de persistencia que puedan existir, este tipo de implementaciones se realizan
basadas en el patr�n de dise�o [Unit of Work y Repository](https://medium.com/@krzychukosobudzki/repository-design-pattern-bc490b256006)

Estas clases no puede existir solas y debe heredarse su compartimiento en los **Driven Adapters**

### Driven Adapters (JPA REPOSITORY - EntityDATA)

![data](images/Captura%20de%20pantalla%202023-06-20%20034742.jpg)

![adapter](images/Captura%20de%20pantalla%202023-06-20%20034843.jpg)

Los driven adapter representan implementaciones externas a nuestro sistema, como lo son conexiones a servicios rest,
soap, bases de datos, lectura de archivos planos, y en concreto cualquier origen y fuente de datos con la que debamos
interactuar.

En este modulo se tienen por cada entidad del dominio, una entidad data que es la que se persistira, se tiene un repositorio para esta data y un adaptador en donde se van a implementar los metodos del repositorio del dominio y se utilizara como base el repositorio de la entidad data, que contiene los metodos crud.

### Entry Points

![entrypoint](images/Captura%20de%20pantalla%202023-06-20%20034843.jpg)

Los entry points representan los puntos de entrada de la aplicaci�n o el inicio de los flujos de negocio.

## Application

Este m�dulo es el m�s externo de la arquitectura, es el encargado de ensamblar los distintos m�dulos, resolver las dependencias y crear los beans de los casos de use (UseCases) de forma autom�tica, inyectando en �stos instancias concretas de las dependencias declaradas. Adem�s inicia la aplicaci�n (es el �nico m�dulo del proyecto donde encontraremos la funci�n �public static void main(String[] args)�.

**Los beans de los casos de uso se disponibilizan automaticamente gracias a un '@ComponentScan' ubicado en esta capa.**

![jacoco](images/Captura%20de%20pantalla%202023-06-20%20035730.jpg)