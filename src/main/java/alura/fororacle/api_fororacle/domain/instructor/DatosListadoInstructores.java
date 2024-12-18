package alura.fororacle.api_fororacle.domain.instructor;

import java.time.LocalDateTime;

public record DatosListadoInstructores(Long id,
                                       String nombre,
                                       String email,
                                       LocalDateTime fecha,
                                       Long idCurso,
                                       String nombreCurso) {
public DatosListadoInstructores(Instructor instructor){
    this(instructor.getId(),instructor.getNombre(),instructor.getEmail(), instructor.getFecha(), instructor.getCurso().getId(), instructor.getCurso().getNombre());
}
}
