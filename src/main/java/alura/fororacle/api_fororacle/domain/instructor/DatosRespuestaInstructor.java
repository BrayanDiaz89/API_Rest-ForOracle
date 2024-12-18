package alura.fororacle.api_fororacle.domain.instructor;

import java.time.LocalDateTime;

public record DatosRespuestaInstructor(Long id,
                                       String nombre,
                                       String email,
                                       LocalDateTime fecha,
                                       boolean activo,
                                       Long idCurso) {

    public DatosRespuestaInstructor(Instructor instructor){
        this(instructor.getId(),instructor.getNombre(),instructor.getEmail(), instructor.getFecha(), instructor.isActivo(), instructor.getCurso().getId());
    }
}
