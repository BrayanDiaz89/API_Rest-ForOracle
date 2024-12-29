package alura.fororacle.api_fororacle.domain.respuestas;

import alura.fororacle.api_fororacle.domain.instructor.Instructor;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface
RespuestaRepository extends JpaRepository<Respuesta, Long> {

    @Query("""
           SELECT r 
           FROM Respuesta r 
           WHERE r.instructor.id IS NOT NULL
           AND r.activo = true
            """)
    Page<Respuesta> findByIdInstructorNotNullAndRespuestaActiva(Pageable paginacion);

    @Query("""
           SELECT r 
           FROM Respuesta r 
           WHERE r.estudiante.id IS NOT NULL
           AND r.activo = true
            """)
    Page<Respuesta> findByIdEstudianteNotNullAndRespuestaActiva(Pageable paginacion);

    @Query("""
       SELECT EXISTS (
           SELECT 1
           FROM Respuesta r
           WHERE r.instructor.id = :idInstructor
           AND r.id = :idRespuesta
           AND r.topico.id = :idTopico
       )
       """)
    Boolean findByCoincidenciaIdInstructorAndIdRespuesta(Long idInstructor, Long idRespuesta, Long idTopico);

    @Query("""
       SELECT EXISTS (
           SELECT 1
           FROM Respuesta r
           WHERE r.instructor.id = :idEstudiante
           AND r.id = :idRespuesta
           AND r.topico.id = :idTopico
       )
       """)
    Boolean findByCoincidenciaIdEstudianteAndIdRespuesta(Long idEstudiante, Long idRespuesta, Long idTopico);

    @Query("""
           select r.activo
           from Respuesta r
           where
           r.id = :idRespuesta
           """)
    boolean findByActivoTrueAndIsIdRespuesta(Long idRespuesta);
}
