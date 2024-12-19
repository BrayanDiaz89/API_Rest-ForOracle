package alura.fororacle.api_fororacle.domain.estudiante;

import java.time.LocalDateTime;

public record DatosRespuestaEstudiante(
                                    Long id,
                                    String nombre,
                                    String email,
                                    LocalDateTime fecha,
                                    Boolean activo,
                                    Long idCurso
) {
    public DatosRespuestaEstudiante(Estudiante estudiante) {
        this(estudiante.getId(), estudiante.getNombre(), estudiante.getEmail(), estudiante.getFecha(),estudiante.getActivo(),estudiante.getCurso().getId());
    }
}
