package alura.fororacle.api_fororacle.domain.respuestas;

import java.time.LocalDateTime;

public record DatosRespuesta(Long id,
                             String contenido,
                             LocalDateTime fecha,
                             Long idEstudiante,
                             String nombreEstudiante,
                             Long idInstructor,
                             String nombreInstructor) {
    public DatosRespuesta(Respuesta respuesta) {
        this(respuesta.getId(),
                respuesta.getContenido(),
                respuesta.getFecha(),
                respuesta.getEstudiante() != null ? respuesta.getEstudiante().getId() : null,
                respuesta.getEstudiante() != null ? respuesta.getEstudiante().getNombre() : "N/A",
                respuesta.getInstructor() != null ? respuesta.getInstructor().getId() : null,
                respuesta.getInstructor() != null ? respuesta.getInstructor().getNombre() : "N/A");
    }
}
