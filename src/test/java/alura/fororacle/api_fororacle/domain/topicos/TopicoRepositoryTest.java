package alura.fororacle.api_fororacle.domain.topicos;

import alura.fororacle.api_fororacle.domain.cursos.Curso;
import alura.fororacle.api_fororacle.domain.cursos.DatosRegistrarCurso;
import alura.fororacle.api_fororacle.domain.estudiante.DatosRegistrarEstudiante;
import alura.fororacle.api_fororacle.domain.estudiante.Estudiante;
import alura.fororacle.api_fororacle.domain.estudiante.EstudianteRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.cglib.core.Local;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class TopicoRepositoryTest {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private EntityManager em;

    @Test
    @DisplayName("Debería devolver true, si el topico fue creado por el id del estudiante que se ingresa en la consulta.")
    void findByTopicoIfEstudianteCreoElTopicoEscenario1() {
        var fecha = LocalDateTime.now();
        var curso = registrarCurso("python", "aprende python", true);
        var estudiante = registrarEstudiante(curso, "Brayan", "brayan@gmail.com",fecha, true);
        var topico = registrarTopico(curso, estudiante, "Dudas en python", "no se como usarlo",fecha, true);
        var estudianteEsAutor = topicoRepository.findByTopicoIfEstudianteCreoElTopico(topico.getId(), estudiante.getId());
        assertThat(estudianteEsAutor).isTrue();
    }

    private Estudiante registrarEstudiante(Curso curso, String nombre, String email, LocalDateTime fecha, Boolean activo){
        var estudiante = new Estudiante(curso,nombre,email,fecha,activo);
        em.persist(estudiante);
        return estudiante;
    }
    private Topico registrarTopico(Curso curso, Estudiante estudiante, String titulo, String descripcion, LocalDateTime fecha, Boolean no_resuelto){
        var topico = new Topico(curso, estudiante, titulo, descripcion, fecha, no_resuelto);
        em.persist(topico);
        return topico;
    }
    private Curso registrarCurso(String nombre, String descripcion, Boolean activo){
        var curso = new Curso(nombre, descripcion, activo);
        em.persist(curso);
        return curso;
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
}