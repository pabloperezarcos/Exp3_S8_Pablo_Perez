# MScloud_crud

Este es un microservicio desarrollado en Java para realizar operaciones CRUD, creado como parte de un examen para el ramo FullStack I.

## Descripción

MScloud_crud es un microservicio que se conecta a una base de datos en Oracle Cloud y se despliega en Docker (dockerlab). Implementa dos casos de uso solicitados en el examen:

- **Caso A:** CRUD para usuarios y direcciones, junto con un login básico que utiliza un POST y devuelve una respuesta positiva o negativa.
- **Caso B:** CRUD para pacientes y consultas.

## Características

- **Tecnologías utilizadas:** 
  - Java
  - Oracle Cloud (base de datos)
  - Docker (deploy en dockerlab)

## Uso

1. Clona este repositorio:
    ```bash
    git clone https://github.com/tu-usuario/MScloud_crud.git
    ```
2. Navega al directorio del proyecto:
    ```bash
    cd MScloud_crud
    ```
3. Construye el proyecto con Maven:
    ```bash
    mvn clean install
    ```
4. Construye y despliega el contenedor Docker:
    ```bash
    docker build -t mscloud_crud .
    docker run -p 8080:8080 mscloud_crud
    ```

## Endpoints

### Caso A: Usuarios y Direcciones
- **Crear usuario:** `POST /usuarios`
- **Obtener usuarios:** `GET /usuarios`
- **Actualizar usuario:** `PUT /usuarios/{id}`
- **Eliminar usuario:** `DELETE /usuarios/{id}`
- **Login básico:** `POST /login`

### Caso B: Pacientes y Consultas
- **Crear paciente:** `POST /pacientes`
- **Obtener pacientes:** `GET /pacientes`
- **Actualizar paciente:** `PUT /pacientes/{id}`
- **Eliminar paciente:** `DELETE /pacientes/{id}`
- **Crear consulta:** `POST /consultas`
- **Obtener consultas:** `GET /consultas`
- **Actualizar consulta:** `PUT /consultas/{id}`
- **Eliminar consulta:** `DELETE /consultas/{id}`

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue o envía un pull request para cualquier mejora o corrección.

---

¡Gracias por visitar y utilizar MScloud_crud! Si tienes alguna pregunta o sugerencia, no dudes en contactarme.
