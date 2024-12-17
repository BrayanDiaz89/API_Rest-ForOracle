package alura.fororacle.api_fororacle.domain.estudiante;

import java.time.LocalDateTime;

public record DatosRespuestaEstudiante(
                                    Long id,
                                    String nombre,
                                    String email,
                                    LocalDateTime fecha,
                                    boolean activo,
                                    Long idCurso
) {
    public DatosRespuestaEstudiante(Estudiante registro) {
        this(registro.getId(), registro.getNombre(), registro.getEmail(), registro.getFecha(),registro.isActivo(),registro.getCurso().getId());
    }
}
