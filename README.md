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
Fororacle es un proyecto personal diseñado para resolver un problema común de interacción educativa mediante una API REST. Su enfoque principal es ofrecer una plataforma para un foro participativo, accesible a través de un login de administrador. Esta API permite realizar operaciones sobre diversos recursos mediante endpoints como GET, POST, PUT y DELETE, facilitando la gestión y visualización de tópicos, respuestas de estudiantes, y comentarios de instructores, todo vinculado a un curso específico. Esta estructura busca reflejar un entorno educativo más realista y proporcionar una solución efectiva a un desafío cotidiano en el ámbito académico.
</p>
<p align="justify">
¡Bienvenido! La implementación de esta API se ha realizado utilizando Java 17, Spring Boot 3.4.0, Maven, Spring Security, MySQL, Hibernate, entre otras tecnologías y principios clave, que se detallarán a lo largo de la documentación. Asimismo, se presentarán las principales consideraciones y reglas de negocio que se tomaron en cuenta durante su desarrollo para garantizar una solución robusta y alineada con los requerimientos del sistema.
</p>
<p align="justify">Para comenzar, quiero compartirte una pequeña visualización de los endpoints disponibles, y gestionados con la herramienta <b>Insomnia:</b></p>

![EndpointsInsomniaAPIFororacle](https://github.com/user-attachments/assets/d4b1e741-e468-4a5c-a94c-a0ca458e39da)

<p align="justify">Como se observa arriba ⬆️, allí solo se visualiza una parte de los endpoints disponibles, conforme avances en la presente documentación, entenderás de mejor manera
como funcionarán estos endpoint, con las consideraciones y reglas de negocio compartidas posteriormente, así lograrás comprender las relaciones entre tablas de la base de datos,
sus condiciones de creación de registros y qué poderes tiene esta <b>API.</b></p>

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



