# GeoGenius 

El proyecto **GeoGenius** es una aplicación de preguntas y respuestas sobre geografía construida con **Spring Boot**. 

## Requisitos Previos


* **Java 21 ** 
* **Base de datos PostgreSQL**
* **Maven** 

## Dependencias y Versiones

El proyecto utiliza las siguientes dependencias:

* **Spring Boot**: `2.7.9` (o cualquier versión compatible con Spring 5)
* **Spring Data JPA**: `2.7.9`
* **Spring Web**: `5.3.15`
* **PostgreSQL JDBC Driver**: `42.5.0`
* **Spring Boot DevTools**: `2.7.9`


Aquí está la lista de dependencias en el archivo `pom.xml`:

```xml
<dependencies>
    <!-- Spring Boot Starter Web para construir APIs RESTful -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Boot Starter Data JPA para acceso a base de datos -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- Controlador JDBC para PostgreSQL -->
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <version>42.5.0</version>
    </dependency>

    <!-- Lombok para reducir código repetitivo (Opcional) -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.24</version>
        <scope>provided</scope>
    </dependency>

    <!-- Spring Boot DevTools para reinicios automáticos y recarga en caliente -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- Spring Boot Starter Test para pruebas unitarias -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## Configuración del Proyecto

### 1. Clonar el Repositorio

Clona este repositorio en tu máquina local:

```bash
git clone https://github.com/tu-usuario/geogenius-backend.git
cd geo-genius-backend
```

### 2. Configurar la Conexión a la Base de Datos

Hay que tener PostgreSQL instalado y ejecutándose en la máquina. La conexión se configura a la base de datos en el archivo `application.properties`.

Se actualiza el archivo `application.properties` con la configuración de base de datos PostgreSQL:

```properties
spring.application.name=geogeniusback

# Configuración de la Base de Datos PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/GeoGenius
spring.datasource.username=postgres
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=org.postgresql.Driver

# Configuración de Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.open-in-view=false

# Script de Inicialización de Datos
spring.sql.init.mode=always
spring.sql.init.data-locations=classpath:data.sql
```


### 3. Crear el archivo `data.sql` (Opcional)

Se puede usar un archivo SQL para poblar la base de datos. Crear un archivo `data.sql` en la carpeta `src/main/resources` y agregar datos de ejemplo como:

```sql
INSERT INTO countries (name, capital) VALUES
    ('Alemania', 'Berlín'),
    ('Francia', 'París'),
    ('Italia', 'Roma'),
    ('España', 'Madrid'),
    ('Estados Unidos', 'Washington, D.C.');
```

### 4. Construir el Proyecto

Para construir el proyecto, se usa **Maven**:

```bash
mvn clean install
```

### 5. Ejecutar la Aplicación

Ejecuta la aplicación utilizando **Spring Boot**:

```bash
mvn spring-boot:run
```

Por defecto, el backend se ejecutará en `http://localhost:8080`.

## Endpoints de la API

### 1. `/api/geoApi/question`

* **Método**: `GET`

* **Descripción**: Obtiene una pregunta aleatoria de trivia con cuatro opciones. La pregunta es "¿Cuál es la capital de \[País]?", con una opción correcta y tres opciones incorrectas.

* **Ejemplo de Respuesta**:

```json
{
  "question": "¿Cuál es la capital de Alemania?",
  "options": ["Berlín", "Madrid", "París", "Roma"],
  "correctAnswer": "Berlín"
}
```

## Solución de Problemas

### 1. Problemas de Conexión a la Base de Datos

* Si hay problemas para conectarte a la base de datos, hay de que:

  * PostgreSQL esté ejecutándose en `localhost:5432`.
  * La base de datos `GeoGenius` exista.
  * El usuario de la base de datos `postgres` tenga los privilegios adecuados.

### 2. Problemas de CORS (Frontend)

Si el puerto (por ejemplo, `http://localhost:3000`) está ocupada, se encuentran problemas de **CORS**. Para habilitar CORS en Spring Boot agregando la siguiente configuración:

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:3000");
    }
}
```

## Licencia

Este proyecto está sin Licencia. A disfrutar!

