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
  Fororacle es un proyecto personal, que busca resolver un problema de la vida cotidiana, por medio de una API Rest, enfocada especialmente para un foro participativo,
  el cual se liberará por medio de un login Admin, y desde este login bajo endpoints como GET, POST, PUT y DELETE, que facilitarán la visualización de los tópicos, por 
  estudiante, sus respuestas, así como las respuestas a estos tópicos por parte de los instructores, y además todos ellos estarán relacionados a un curso específico, 
  esto lo hace más concorde a la realidad y una resolución a un problema cotidiano.
</p>
<p align="justify">
Bienvenido!, la implementación de la <b>API</b> está realizada con <b>Java 17, Spring boot 3.4.0, Maven, Spring Security, MySQL, Hibernate,</b> entre otras tecnologías y principios
utilizados, que serán nombrados posteriormente; Así como se mencionarán sus <b>consideraciones o reglas de negocio</b> que se han tenido en cuenta para su desarrollo.
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
      <td>A continuación se visualizará el modelado de la base de datos, en la parte inferior, para comprender de mejor manera la estructura de la <b>API:</b>⬇️</td>
    </tr>
  </table>
</p>

![modeladoBaseDatos](https://github.com/user-attachments/assets/db9ee711-87d0-4648-8ace-db349f6e00d3)


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



