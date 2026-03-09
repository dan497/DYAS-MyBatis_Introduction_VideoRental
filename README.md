# Taller: Tecnologías de persistencia - Frameworks de Persistencia - Introducción a MyBatis

## Universidad de la Sabana - Diseño y Arquitectura de Software

### Integración de MyBatis para la gestión de datos y relaciones entre clases

## Descripción del Proyecto

Este proyecto implementa el uso de **MyBatis**, un framework de persistencia en Java, para gestionar consultas y mapeos de objetos a bases de datos. El sistema está diseñado para manejar operaciones entre las entidades `Cliente`, `Item`, `ItemRentado` y `TipoItem`, junto con sus relaciones, a través de múltiples mappers. Gracias a esto, MyBatis facilita la interacción con la base de datos SQLite y la reconstrucción de objetos Java a partir de consultas SQL.

## Requisitos del Proyecto

El sistema desarrollado cumple con los siguientes aspectos:

- Utiliza **MyBatis** para manejar las consultas y el mapeo de objetos a las tablas de la base de datos.
- Incluye las entidades `Cliente`, `Item`, `ItemRentado` y `TipoItem`, con sus respectivas relaciones.
- Permite realizar operaciones de inserción y consulta mediante el uso de mappers en MyBatis.
- Implementa consultas con relaciones de uno a muchos entre `Cliente` e `ItemRentado`.
- Implementa relaciones de uno a uno entre `ItemRentado` e `Item`, y entre `Item` y `TipoItem`.
- Usa consultas con `JOIN` y aliases para evitar conflictos entre columnas con nombres repetidos.

## Implementación

### Mapeo con MyBatis

En este proyecto, MyBatis se utiliza para gestionar la conversión de los resultados de las consultas SQL a objetos Java y viceversa. Para ello se configuró el archivo `mybatis-config.xml`, se agregaron los `typeAliases` correspondientes a las entidades y se definieron los archivos XML de los mappers necesarios para conectar la lógica Java con la base de datos.

Se construyeron distintos `resultMap` para mapear correctamente las propiedades de las clases Java a las columnas de la base de datos y manejar las relaciones entre las entidades del modelo.

### Principales Operaciones

1. **Consultar Clientes**: permite consultar todos los clientes junto con sus items rentados, los datos de cada item y su tipo asociado.  
2. **Consultar un Cliente por id**: permite buscar un cliente específico utilizando un parámetro en la consulta SQL.  
3. **Agregar Item Rentado a Cliente**: permite registrar un nuevo item rentado asociado a un cliente.  
4. **Insertar Item**: permite insertar un nuevo item en la base de datos y asociarlo con un `TipoItem`.  
5. **Consultar Item por id**: permite recuperar un item específico junto con la información de su tipo.  
6. **Consultar todos los Items**: permite obtener todos los items registrados en la base de datos.  

## Estructura del Proyecto

### Clases

- **Cliente**: representa a un cliente con atributos como `nombre`, `documento`, `telefono`, `direccion`, `email` y una lista de `ItemRentado` asociados.
- **Item**: representa un ítem disponible para renta con atributos como `id`, `nombre`, `descripcion`, `fechaLanzamiento`, `tarifaxDia`, `formatoRenta`, `genero` y `tipo`.
- **ItemRentado**: representa un ítem rentado por un cliente, incluyendo su `id`, el `Item` asociado y las fechas de inicio y fin de la renta.
- **TipoItem**: representa la categoría o tipo de un ítem.

### Mappers

- **ClienteMapper**: define las operaciones relacionadas con los clientes, sus consultas y la asociación con items rentados.
- **ItemMapper**: define las operaciones de inserción y consulta de items.
- **TipoItemMapper**: define las operaciones de consulta relacionadas con tipos de item.

## Lógica del Proyecto

El proyecto permite trabajar con una base de datos local SQLite y usar MyBatis para reconstruir objetos complejos a partir de varias tablas relacionadas.

Entre las funcionalidades implementadas se encuentran:

- Consultar todos los clientes con sus items rentados.
- Consultar un cliente de manera individual usando un parámetro en el mapper.
- Insertar un nuevo item en la base de datos.
- Consultar un item específico y validar que quede asociado a su tipo.
- Consultar la lista completa de items disponibles.
- Manejar las relaciones entre tablas usando `resultMap`, `association` y `collection`.

## Ejemplo de Uso

1. **Consultar Clientes**: usando `ClienteMapper`, se pueden obtener todos los clientes con sus ítems rentados asociados.  
2. **Consultar Cliente por id**: usando `ClienteMapper`, se puede buscar un cliente específico por su documento.  
3. **Insertar un Item**: usando `ItemMapper`, se puede insertar un nuevo item asociado a un tipo de item.  
4. **Consultar un Item**: usando `ItemMapper`, se puede recuperar el item insertado y verificar su información.  

## Ejecución del Programa

Para comprobar el funcionamiento del proyecto se utilizó la clase `MyBatisExample`, desde la cual se realizó una prueba de inserción y consulta de un item.

Durante la ejecución del programa:

- se abrió una sesión con MyBatis,
- se creó un objeto `Item`,
- se insertó el item en la base de datos,
- se confirmó la transacción,
- y luego se consultó el mismo item para verificar que la inserción se realizó correctamente.

## Salida Esperada

Una ejecución exitosa del programa produce una salida similar a la siguiente:

```
Insertando el siguiente Item:
Item{id=0, nombre='Nuevo Item', descripcion='Descripción del nuevo item', fechaLanzamiento=Sun Mar 08 22:46:35 GMT-05:00 2026, tarifaxDia=5000, formatoRenta='Diario', genero='Electrónica', tipo=TipoItem{id=1, descripcion='Electrónico'}}
Item insertado correctamente.
ID generado para el nuevo item: 4
Item recuperado desde la base de datos:
Item{id=4, nombre='Nuevo Item', descripcion='Descripción del nuevo item', fechaLanzamiento=Sun Mar 08 22:46:35 GMT-05:00 2026, tarifaxDia=5000, formatoRenta='Diario', genero='Electrónica', tipo=TipoItem{id=1, descripcion='Electrónico'}}
```

## Autores

**Daniel Riveros**  
**Manuel Castillo**  

Estudiantes de la Universidad de La Sabana
