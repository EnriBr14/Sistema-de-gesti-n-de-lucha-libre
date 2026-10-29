# 🥊 Sistema de Gestión de Lucha Libre

Aplicación de consola desarrollada en Java para gestionar empresas de lucha libre y sus luchadores mediante una base de datos MySQL.

El proyecto permite realizar operaciones CRUD, consultar registros y relacionar información entre empresas y luchadores. Fue desarrollado como proyecto de práctica para reforzar conocimientos de programación orientada a objetos, acceso a bases de datos y organización del código en Java.

## 🚀 Funcionalidades

- **Gestión de empresas:** registrar, consultar, actualizar y eliminar empresas.
- **Gestión de luchadores:** registrar, consultar, actualizar y eliminar luchadores.
- **Búsqueda por ID:** consultar registros específicos.
- **Consultas relacionadas:** mostrar luchadores asociados a una empresa mediante consultas SQL con `INNER JOIN`.
- **Menú interactivo:** navegar por las operaciones desde la consola.

## 🛠️ Tecnologías utilizadas

- Java
- MySQL
- JDBC
- SQL
- Programación orientada a objetos (POO)

## 🧱 Estructura del proyecto

El código está organizado en paquetes para separar responsabilidades:

- `Modelo`: clases que representan las entidades del sistema, como `Empresa` y `Luchador`.
- `DAO`: clases encargadas de realizar las operaciones de acceso a datos.
- `Servicio`: lógica que coordina las operaciones de la aplicación.
- `Conexion`: configuración y conexión con la base de datos.
- `Main`: punto de entrada y menú principal de la aplicación.

> Los nombres anteriores describen la organización lógica del proyecto. Ajusta los nombres de los paquetes a los que aparecen realmente en tu código.

## ⚙️ Requisitos

Antes de ejecutar la aplicación, necesitas:

- Tener instalado el JDK de Java.
- Tener instalado MySQL Server.
- Contar con un IDE compatible con Java, como IntelliJ IDEA, Eclipse o NetBeans.
- Configurar la dependencia o el controlador JDBC de MySQL.

## ▶️ Instalación y ejecución

1. Clona el repositorio:

   ```bash
   git clone URL_DE_TU_REPOSITORIO
   ```

2. Abre el proyecto en tu IDE.

3. Crea la base de datos en MySQL utilizando el nombre configurado en la clase de conexión.

4. Crea las tablas necesarias para empresas y luchadores, incluyendo sus campos y relaciones.

5. Configura la conexión a MySQL con tu usuario, contraseña, servidor y nombre de base de datos.

6. Verifica que el controlador JDBC de MySQL esté incluido en el proyecto.

7. Ejecuta la clase `Main` y utiliza el menú de la consola.

## 🧠 Conocimientos aplicados

Este proyecto me permitió practicar:

- Programación orientada a objetos en Java.
- Operaciones CRUD sobre una base de datos relacional.
- Conexión a MySQL mediante JDBC.
- Consultas SQL parametrizadas con `PreparedStatement`.
- Uso de `INNER JOIN` para relacionar información entre tablas.
- Separación de responsabilidades mediante el patrón DAO.
- Organización de un proyecto en clases y paquetes.

## 🔮 Mejoras futuras

- Incorporar validaciones de datos y mensajes de error más claros.
- Mejorar el manejo de excepciones y el cierre de conexiones.
- Agregar pruebas unitarias.
- Externalizar las credenciales de la base de datos.
- Desarrollar una interfaz gráfica para facilitar el uso del sistema.

## 👨‍💻 Autor

Proyecto personal de práctica desarrollado con Java y MySQL.

