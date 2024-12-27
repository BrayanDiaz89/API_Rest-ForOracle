package alura.fororacle.api_fororacle.domain.respuestas;

import alura.fororacle.api_fororacle.domain.cursos.Curso;
import alura.fororacle.api_fororacle.domain.cursos.DatosRegistrarCurso;
import alura.fororacle.api_fororacle.domain.estudiante.DatosRegistrarEstudiante;
import alura.fororacle.api_fororacle.domain.estudiante.Estudiante;
import alura.fororacle.api_fororacle.domain.instructor.Instructor;
import alura.fororacle.api_fororacle.domain.topicos.DatosRegistrarTopico;
import alura.fororacle.api_fororacle.domain.topicos.Topico;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class RespuestaRepositoryTest {

    @Autowired
    private RespuestaRepository respuestaRepository;
    @Autowired
    private EntityManager em;

    @Test
    @DisplayName("Debería devolver Null, si los id de instructor, topico y respuesta no coinciden.")
    void findByCoincidenciaIdInstructorAndIdRespuestaEscenario1() {
        //given o arrange
        var fecha = LocalDateTime.now();
        var curso = registrarCurso("python", "aprende python", true);
        var estudiante = registrarEstudiante(curso, "Brayan", "brayan@gmail.com",fecha, true);
        var instructor = registrarInstructor(curso,"Artur", "artur@gmail.com",fecha,true);
        var topico = registrarTopico(curso, estudiante, "Dudas en python", "no se como usarlo",fecha, true);
        var respuesta = registrarRespuesta(estudiante, instructor, "contenido xd", fecha, topico, true);
        //when o act
        var idsCoincidenParaModificarRespuestaInstructor = respuestaRepository.findByCoincidenciaIdInstructorAndIdRespuesta(instructor.getId(), respuesta.getId(), topico.getId());
        //then o assert
        assertThat(idsCoincidenParaModificarRespuestaInstructor).isTrue();
    }

    @Test
    @DisplayName("Debería devolver true, si el topico fue creado por el id del estudiante que se ingresa en la consulta.")
    void findByCoincidenciaIdEstudianteAndIdRespuestaEscenario1() {
        //given o arrange
        var fecha = LocalDateTime.now();
        var curso = registrarCurso("python", "aprende python", true);
        var estudiante = registrarEstudiante(curso, "Brayan", "brayan@gmail.com",fecha, true);
        var instructor = registrarInstructor(curso,"Artur", "artur@gmail.com",fecha,true);
        var topico = registrarTopico(curso, estudiante, "Dudas en python", "no se como usarlo",fecha, true);
        var respuesta = registrarRespuesta(estudiante, instructor, "contenido xd", fecha, topico, true);
        //when o act
        var idsCoincidenParaModificarRespuestaEstudiante = respuestaRepository.findByCoincidenciaIdEstudianteAndIdRespuesta(estudiante.getId(), respuesta.getId(), topico.getId());
        //then o assert
        assertThat(idsCoincidenParaModificarRespuestaEstudiante).isTrue();
    }

    @Test
    @DisplayName("Debería devolver true, si el topico fue creado por el id del estudiante que se ingresa en la consulta.")
    void findByActivoTrueAndIsIdRespuestaEscenario1() {
        //given o arrange
        var fecha = LocalDateTime.now();
        var curso = registrarCurso("python", "aprende python", true);
        var estudiante = registrarEstudiante(curso, "Brayan", "brayan@gmail.com",fecha, true);
        var instructor = registrarInstructor(curso,"Artur", "artur@gmail.com",fecha,true);
        var topico = registrarTopico(curso, estudiante, "Dudas en python", "no se como usarlo",fecha, true);
        var respuesta = registrarRespuesta(estudiante, instructor, "contenido xd", fecha, topico, false);
        //when o act
        var respuestaEstaActivaAndIdCoincideParaModificar = respuestaRepository.findByActivoTrueAndIsIdRespuesta(respuesta.getId());
        //then o assert
        assertThat(respuestaEstaActivaAndIdCoincideParaModificar).isTrue();
    }

    private Curso registrarCurso(String nombre, String descripcion, Boolean activo) {
        var curso = new Curso(nombre, descripcion, activo);
        em.persist(curso);
        return curso;
    }

    private Estudiante registrarEstudiante(Curso curso, String nombre, String email, LocalDateTime fecha, Boolean activo) {
        var estudiante = new Estudiante(curso, nombre, email, fecha, activo);
        em.persist(estudiante);
        return estudiante;
    }

    private Instructor registrarInstructor(Curso curso, String nombre, String email, LocalDateTime fecha, Boolean activo) {
        var instructor = new Instructor(curso, nombre, email, fecha, activo);
        em.persist(instructor);
        return instructor;
    }

    private Topico registrarTopico(Curso curso, Estudiante estudiante, String titulo, String descripcion, LocalDateTime fecha, Boolean no_resuelto) {
        var topico = new Topico(curso, estudiante, titulo, descripcion, fecha, no_resuelto);
        em.persist(topico);
        return topico;
    }
    private Respuesta registrarRespuesta(Estudiante estudiante, Instructor instructor, String contenido, LocalDateTime fecha, Topico topico, Boolean activo) {
        var respuesta = new Respuesta(estudiante, instructor, contenido, fecha, topico, activo);
        em.persist(respuesta);
        return respuesta;
    }
    private DatosRegistrarCurso datosCurso(String nombre, String descripcion, Boolean activo){
        return new DatosRegistrarCurso(nombre,descripcion, activo);
    }


    private DatosRegistrarEstudiante datosEstudiante(Long idCurso, String nombre, String email, LocalDateTime fecha, Boolean activo){
        return new DatosRegistrarEstudiante(
                idCurso,
                nombre,
                email,
                fecha,
                activo
        );
    }
    private DatosRegistrarTopico datosTopico(Long idCurso, Long idEstudiante,
                                             String titulo, String descripcion, LocalDateTime fecha, Boolean no_resuelto){
        return new DatosRegistrarTopico(
                idCurso,
                idEstudiante,
                titulo,
                descripcion,
                fecha,
                no_resuelto
        );
    }
    private DatosRegistroRespuesta datosRespuesta(Long idEstudiante, Long idInstructor,
                                             String contenido, LocalDateTime fecha, Long idTopico){
        return new DatosRegistroRespuesta(
                idEstudiante,
                idInstructor,
                contenido,
                fecha,
                idTopico
        );
    }


}

