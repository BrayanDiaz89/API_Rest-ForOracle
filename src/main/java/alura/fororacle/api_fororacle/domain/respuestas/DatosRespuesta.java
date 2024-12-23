package alura.fororacle.api_fororacle.domain.respuestas;

import java.time.LocalDateTime;

public record DatosRespuesta(Long id,
                             String contenido,
                             LocalDateTime fecha,
                             Long idEstudiante,
                             Long idInstructor) {
    public DatosRespuesta(Respuesta respuesta) {
        this(respuesta.getId(),
                respuesta.getContenido(),
                respuesta.getFecha(),
                respuesta.getEstudiante() != null ? respuesta.getEstudiante().getId() : null,
                respuesta.getInstructor() != null ? respuesta.getInstructor().getId() : null);
    }
}
