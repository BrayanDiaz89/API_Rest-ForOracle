package alura.fororacle.api_fororacle.domain.respuestas.estudiante;

import alura.fororacle.api_fororacle.domain.respuestas.Respuesta;

import java.time.LocalDateTime;

public record DatosVisualizarRespuestaEstudiante(
                                    Long idTopico,
                                    String contenido,
                                    LocalDateTime fecha,
                                    Long idEstudiante,
                                    String nombreEstudiante,
                                    LocalDateTime miembroDesde
                                    ) {
    public DatosVisualizarRespuestaEstudiante(Respuesta respuesta) {
        this(respuesta.getTopico().getId(), respuesta.getContenido(), respuesta.getFecha(), respuesta.getEstudiante().getId(),
                respuesta.getEstudiante().getNombre(), respuesta.getEstudiante().getFecha());
    }
}
