# EasyPokeApi

## Descripción del Proyecto
El fin de este proyecto es aprender como funciona un backend y un frontend de manera conjunta para mostrar de manera gráfica y sencilla los datos de los pokemones
los cuales incluye: Estadísticas, Nombre, Movimientos, Tipos, Imagen, etc.
Todo esto con SpringBoot y HTML, CSS, Javascript y una base de datos la cual está dentro de un contenedor que actúa como caché guardando pokemones pedidos por los usuarios para acelerar el proceso. 


## 🛠️ Tecnologías utilizadas

| Tecnología      | Uso                            |
| --------------- | ------------------------------ |
| Java 25         | Lenguaje de programación       |
| Spring Boot     | Framework backend              |
| Spring Web      | Desarrollo de API REST         |
| Spring Data JPA | Persistencia y acceso a datos  |
| PostgreSQL      | Base de datos                  |
| MapStruct       | Mapeo entre entidades y DTOs   |
| Lombok          | Reducción de código repetitivo |
| Maven           | Gestión de dependencias        |
| RestClient      | Peticiones a la poke-api       |
| Podman          | Administrar contenedor de la Base de datos |
| HTML,Css y Js   | Front-End de la API            | 




## 📂 Estructura General del proyecto

```text
src/
├── main/
│   ├── java/
│   │   └── io.github.kevin_puertos.EasyPokeAPI/
│   │       ├── client/
│   │       ├── config/
│   │       ├── exceptions/
│   │       └── pokemon/
│   │
│   └── resources/
│        ├── application.properties
│        └── static/
|              ├── assets/
|              ├── css/
|              └── js/
└── test/
    └── java/
```

---




## 📋 Endpoints


### 📚 Documentación de la API

La API cuenta con documentación interactiva mediante **Swagger UI**, que permite consultar los endpoints disponibles y realizar peticiones directamente desde el navegador.

Una vez iniciada la aplicación, puedes acceder a Swagger UI en:

```text
http://localhost:8080/swagger-ui/index.html
```


### 📦 Pokemones

| Método   | Endpoint         | Descripción                 |
| -------- | ---------------- | --------------------------- | 
| `GET`    | `/api/v1/pokemons/loadAll`      | Cargar todos los pokemones de la poke-api a la base de datos         | 
| `GET`    | `/api/v1/pokemons/` | Obtener todos los pokemones de la base de datos         | 
| `GET`    | `/api/v1/pokemons/detail/{name}`     | Obtener información detallada de un pokemón por su Nombre, desde la base de datos           | 
| `GET`    | `/api/v1/pokemons/detail/{ID}` | Obtener información detallada de un pokemón por su ID, desde la base de datos         |
| `GET`    | `/api/v1/pokemons/simple/{name}` | Obtener información simple de un pokemón por su nombre         | 
| `GET`    | `/api/v1/pokemons/simple/{ID}` | Obtener información simple de un pokemón por su nombre         |
| `GET`    | `/api/v1/pokemons/type/{typeName}` | Obtener todos los pokemones que pertenecen a un tipo         |





## ⚙️ Configuración

La aplicación utiliza variables de entorno para configurar la conexión
a PostgreSQL , la clave y tiempo de expiración utilizada para JWT.

### Variables de entorno

| Variable | Descripción | Ejemplo |
|----------|-------------|---------|
| `DB_URL` | URL de conexión a PostgreSQL | `jdbc:postgresql://localhost:5432/inventory` |
| `DB_USERNAME` | Usuario de PostgreSQL | `postgres` |
| `DB_PASSWORD` | Contraseña de PostgreSQL | `tu_contraseña` |


### Configuración en IntelliJ IDEA

Las variables de entorno son cargadas desde un archivo .env, por eso para usarlo primero debe descargar el plugin '.env files' en Intellij Idea.

Luego tiene que agregar ese archivo .env a las variables de entorno:

`Run → Edit Configurations → Environment variables → Buscar y seleccionar el archivo .env`


*Un ejemplo de un archivo .env está subido al repositorio como '.env.example'*


Estos valores son necesarios tanto para el archivo 'aplication.properties' como para el 'compose.yml':

### aplication.properties
 ```properties
spring.application.name=easypoke-api

spring.datasource.url=${DB_URL}

spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}


```
### compose.yml
```yml
services:
  db:
    image: docker.io/library/postgres:15
    container_name: postgres_poke_api
    environment:
      POSTGRES_DB: poke_api
      POSTGRES_USER: ${DB_USERNAME}
      POSTGRES_PASSWORD: ${DB_PASSWORD}
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data

volumes:
  postgres_data:

```


### Notas
- El proyecto contiene Usuarios y Equipos pero falta la lógica para su implementación, esto fue con el fin de dejar la api lo mas básica posible. 



## 👨‍💻 Autor

**Kevin Puertos**

Desarrollador novato interesado en backend, Java y desarrollo de aplicaciones con Spring Boot.

- GitHub: [@kevin-puertos](https://github.com/kevin-puertos)
- CV : [CV](https://kevin-puertos.github.io/)
- LinkedIn: [Kevin Puertos](https://linkedin.com/in/kevin-puertos-a09559428/)



---
