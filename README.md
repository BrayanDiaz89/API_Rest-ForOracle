<h1 align="center">API REST - FORORACLE</h1>

![readmeFororacle](https://github.com/user-attachments/assets/5d7be095-0a61-46c3-a953-087bda6d175f)

<p align="center">
<img alt="Static Badge" src="https://img.shields.io/badge/Release%20date-Diciembre%202024-green">
<img alt="Static Badge" src="https://img.shields.io/badge/Status-En%20constante%20desarrollo-green">
<img alt="Static Badge" src="https://img.shields.io/badge/Project%20version-1.0-blue">
<img alt="Static Badge" src="https://img.shields.io/badge/Java%20version-17.0-blue">
<img alt="Static Badge" src="https://img.shields.io/badge/Spring%20version-3.4.0-blue">
</p>

<h2>Introducción:</h2>
<p align="justify">
Fororacle es un proyecto personal diseñado para resolver un problema común de interacción educativa mediante una API REST. Su enfoque principal es ofrecer una plataforma para un foro participativo, accesible a través de un login de administrador. Esta API permite realizar operaciones sobre diversos recursos mediante endpoints como GET, POST, PUT y DELETE, facilitando la gestión y visualización de tópicos, respuestas de estudiantes, y también de instructores, todo vinculado a un curso específico. Esta estructura busca reflejar un entorno educativo más realista y proporcionar una solución efectiva a un desafío cotidiano en el ámbito académico.
</p>
<p align="justify">
¡Bienvenido! La implementación de esta API se ha realizado utilizando Java 17, Spring Boot 3.4.0, Maven, Spring Security, MySQL, Hibernate, entre otras tecnologías y principios clave, que se detallarán a lo largo de la documentación. Asimismo, se presentarán las principales consideraciones y reglas de negocio que se tomaron en cuenta durante su desarrollo para garantizar una solución robusta y alineada con los requerimientos del sistema.
</p>
<p align="justify">Para comenzar, quiero compartirte una pequeña visualización de los endpoints disponibles, y gestionados con la herramienta <b>Insomnia:</b></p>

![EndpointsInsomniaAPIFororacle](https://github.com/user-attachments/assets/d4b1e741-e468-4a5c-a94c-a0ca458e39da)

<p align="justify">Como se observa arriba ⬆️, allí solo se visualiza una parte de los endpoints disponibles, conforme avances en la presente documentación, entenderás de mejor manera
como funcionarán estos endpoint, con las consideraciones y reglas de negocio compartidas posteriormente, así lograrás comprender las relaciones entre tablas de la base de datos,
sus condiciones de creación de registros y qué poderes tiene esta <b>API.</b></p>

<hr>
<p align="justify">
  <table>
    <tr>
      <td><img src="https://github.com/user-attachments/assets/fe1fe25f-31aa-4c05-98f9-4de5404b2ce7" alt="siganViendo" /></td>
      <td>A continuación se visualizarán las consideraciones y reglas del negocio que se tuvieron en cuenta para el desarrollo de la <b>API:</b>⬇️</td>
    </tr>
  </table>
</p>

<p align="justify">
  <table>
    <tr>
      <td><img src="https://github.com/user-attachments/assets/faf10061-e1a1-416f-b1cc-5524cffe2bff" alt="consideraciones" /></td>
      <td><img src="https://github.com/user-attachments/assets/6112d09e-5ac1-48fc-9b8a-5b1e550668aa" alt="reglasDelNegocio" /></td>
    </tr>
  </table>
</p>

<p align="justify">
  <table>
    <tr>
      <td><img src="https://github.com/user-attachments/assets/fe1fe25f-31aa-4c05-98f9-4de5404b2ce7" alt="siganViendo" /></td>
      <td>Teniendo en cuenta las consideraciones y reglas del negocio anteriormente mencionadas, a continuación se visualizará el modelado de la base de datos, 
        en la parte inferior, para comprender de mejor manera la estructura de la <b>API</b> requerida: ⬇️</td>
    </tr>
  </table>
</p>
<p style="text-align: center;">
  <img src="https://github.com/user-attachments/assets/9f1361ea-9580-408b-b347-8d15d3e08088" alt="modeladoDeLaBaseDatos" />
</p>

<p align="justify">
🧱 Como se observa en el modelado de la base de datos, las relaciones son: 
</p>
<p align="justify">➡️  Estudiantes - cursos: Relación 1 a muchos, un estudiante puede pertenecer a un curso, pero un curso puede tener varios estudiantes. </p>
<p align="justify">➡️ Cursos - topicos: Relación 1 a muchos, un curso tiene varios tópicos, pero un tópico pertenece a un único curso.</p>
<p align="justify">➡️ Estudiantes - topicos: Relación 1 a muchos, un estudiante puede crear varios tópicos, pero cada tópico, pertenece a un estudiante.</p>
<p align="justify">➡️ Estudiantes - respuestas: Relación 1 a muchos, un estudiante puede dar múltiples respuestas, pero cada respuesta pertenece a un estudiante.</p>
<p align="justify">➡️ Topicos - respuestas: Relación 1 a muchos, un tópico puede tener múltiples respuestas, pero una respuesta pertenece a un único tópico.</p>
<p align="justify">➡️ Instructores - cursos: Relación 1 a muchos, un estudiante puede pertenecer a un curso, pero un curso puede tener varios estudiantes.</p>
<p align="justify">➡️ Instructores - respuestas: Relación 1 a muchos, un instructor puede dar múltiples respuestas, pero cada respuesta pertenece a un instructor.</p>
<p align="justify">
🌟 Una caracterísitca particular, es que todas las tablas tienen un campo boolean (activo o noResuelto), que facilitará su eliminación lógica, más no su eliminación directa
de la base de datos, esto es una buena práctica, ya que no perderemos por completo un registro y no habrán registros huerfanos en nuestra base de datos, solo se desactivarán.
</p>
<hr>

# 🎨 Explicación general acerca de los Endpoints desarrollados en la API:
- `GET`: Todos las entidades cuentan con el método GET, para obtener la lista de registros, con las consideraciones y reglas anteriormente mencionadas. También cuentan con un GET por id, para obtener específicamente de una entidad, el recurso que se busca.
- `POST`: Todas las entidades pueden ser gestionadas mediante POST, para permitir la agregación de nuevos registros en ellas.
- `PUT`: Todas las entidades cuentan con el poder de actualización en sus registros, siempre y cuando se cumplan las reglas anteriormente mencionadas.
- `DELETE`: Todas las entidades, podrán ser desactivadas temporalmente, más no eliminadas directamente de la base de datos.
- `NOTA`: Todos los métodos están siendo validados según las consideraciones y reglas del negocio.
<hr>

# 🔨 Funcionalidades a detalle. Como Admin puedes:
- `CURSOS`: Podrás visualizar, crear, actualizar y eliminar lógicamente, un curso.
- `ESTUDIANTES`: Podrás visualizar, crear, actualizar y eliminar lógicamente, un estudiante, relacionandolo con un curso.
- `INSTRUCTORES`: Podrás visualizar, crear, actualizar y eliminar lógicamente, un instructor, relacionandolo con un curso.
- `TOPICOS`: Podrás visualizar, crear, actualizar y eliminar lógicamente, un tópico, siempre y cuando desde la request estés enviando el id del creador, esto asegura que se cumpla una de las reglas del negocio, solo el creador podrá eliminar su tópico o actualizarlo, a excepción de un usuario ADMIN, ya que tiene acceso a todo.
- `RESPUESTAS`: Podrás visualizar, crear, actualizar y eliminar lógicamente, una respuesta, siempre y cuando desde la request estés enviando el id del creador, esto asegura que se cumpla una de las reglas del negocio, solo el creador podrá eliminar su respuesta o actualizarla, a excepción de un usuario ADMIN, ya que tiene acceso a todo.
<hr>

<p align="justify">Previsualización desde una herramienta cliente, llamada Insomnia</p>

![visualizacionDeEnpointsDesdeInsomnia](https://github.com/user-attachments/assets/9b5df751-a5c9-4c76-af45-bb2e1fee368e)

<hr>

<p align="justify">El proyecto está realizado bajo una arquitectura en capas modularizado, y sus tecnologías son: </p>

## 🧠 Tecnologías utilizadas: 
- Java 17.0:
  - Java Streams y Lambdas
- Spring Framework (versión: 3.4.0):
  - Spring Boot
  - Spring Data JPA
  - Spring Doc
  - Lombok
  - Spring Security (JWT, Login usuario Admin, Encriptamiento Bcrypt)
  - Spring test (Mockito, JUnit)
  - Componentes de Spring, uso de componentes @RestController, @Servide, etc.
- Maven:
  - Gestión de dependencias y construcción del proyecto.
- Base de datos:
  - MySQL
  - Hibernate
  - Migrations con Flyway
- Protocolo HTTP:
  - Implementación de métodos GET, POST, PUT y DELETE, según las mejores prácticas RESTful
- Consultas JPA
  - Anotaciones JPA: Como @Entity, @Table, @ManyToMany, @OneToMany, etc.
  - Consultas personalizadas: Uso de @Query en interfaces de repositorio para consultas personalizadas.
- JSON y serialización:
  - Jackson: Biblioteca para el manejo de JSON (serialización y deserialización).
- Testing y Calidad de Código:
  - JUnit y Mockito: Pruebas unitarias y simulación de comportamientos con mocks
  - Test con Spring Boot: Integración de pruebas con el contexto de Spring.
- Configuración y Variables de entorno
  - Manejo de configuraciones sensibles a través de variables de entorno y application.properties.
<hr>

## 📂 Acceso al proyecto: 
![TutorialdeDescarga](https://github.com/user-attachments/assets/45294179-c3ac-45c6-9989-4311f6b82b50)
<p>Dale click en <strong style="color:red">Download ZIP</strong>.</p>
<p>Posteriormente, asegúrate de tener instalado un editor de código, preferiblemente IntelliJ. Desde allí:</p>

![Tutorialdescarga1](https://github.com/user-attachments/assets/15e48718-903c-444f-9604-d50bf9d2d32c)

<p align="justify">
Dale click en el menú y selecciona "Open File" para abrir la carpeta descomprimida. Luego podrás navegar en las carpetas de la izquierda, como se muestra en el despliegue a continuación:
</p>

![ejecutarElProyecto](https://github.com/user-attachments/assets/3be8aec8-1d23-4d3a-a7d9-fdc399336472)

<p align="justify">
<b>Antes de ejecutar</b>, es importante ajustar tus variables de entorno en Windows o Linux. A continuación, un breve ejemplo de cómo encontrarlas en <b>Windows</b> (En inicio escribe variables de entorno) y abrirás la siguiente ventana:
</p>

![variables_de_entorno](https://github.com/user-attachments/assets/04e90722-40ba-4cf3-b2d5-0ad8c1304843)

<p align="justify">
Haz click en "Variables de entorno" y modifícalas según sea necesario. ⬆️
</p>

<p align="justify">
En el menú de la izquierda, haz click en la carpeta resources, 🧱 ingresa a <b>application.properties</b> y verás las variables de entorno configuradas. Puedes ajustarlas para que coincidan con tu configuración:
</p>

![applicationProperties](https://github.com/user-attachments/assets/adadf511-d37c-4661-ba27-cdabfcac041e)

<p align="justify">

Algo importante que destacar de nuestro aplication properties, es que el valor que guardes en tú variable de entorno:

![secretKey](https://github.com/user-attachments/assets/4644369f-362e-4d37-87e5-6102e178affc)

🔐 Debe ser el mismo valor de la contraseña del usuario ADMIN, ya que si estas no coinciden, no se logrará una validación exitosa.

- `NOTA`: Debes crear la base de datos en tú gestor de base de datos MySql, con el mismo nombre, que la llamaste en properties. Así ella, automáticamente la reconocerá y realizará las migraciones necesarias para poner en funcionamiento la API. Posteriormente es necesario crear un tú usuario admin en la tabla usuarios, con la contraseña, que colocaste en tú variable de entorno. Si este proceso se omite, tendrá problemas al ejecutar o administrar la API.
  
Una vez configurado lo anterior, ya podrás utilizar correctamente la aplicación. Ve a la clase principal y dale click en ejecutar:
</p>

![ejecutarMain](https://github.com/user-attachments/assets/4d4ae4e6-e1e5-4cc0-9e36-c6cfddfc911c)

<p align="justify">
✔️ ¡Listo!, una vez la ejecución se haya realizado con éxito, podrás ingresar a las siguientes url:
  
  - `http://localhost:8080/v3/api-docs` Esta opción es bastante técnica, te recomiendo la segunda opción.
  - `http://localhost:8080/swagger-ui.html` Desde aquí podrás gestionar la API de una manera más intuitiva.
  - `NOTA:` Debes logearte con el usuario admin anteriormente creado y configurado con su variable de entorno, para que pueda utilizar los recursos de la API como ADMIN.
</p>

<hr>

## Autor:

| [<img src="https://avatars.githubusercontent.com/u/166320575?s=400&u=d0ae42a77ad4a0d990a57bb194d54e427bd34df3&v=4" width=115><br><sub>Brayan Díaz</sub>](https://github.com/BrayanDiaz89) |
| :---: |

<hr>

## 🥇 Créditos:

<p align="justify"> 
Gracias a <a href="https://www.aluracursos.com/" target="_blank"><strong>Alura LATAM</strong></a> y a <a href="https://www.oracle.com/co/education/oracle-next-education/" target="_blank"><strong>Oracle Next Education</strong></a> por esta gran oportunidad!.















