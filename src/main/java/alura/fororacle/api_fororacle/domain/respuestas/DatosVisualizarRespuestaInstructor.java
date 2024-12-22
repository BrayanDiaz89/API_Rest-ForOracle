package alura.fororacle.api_fororacle.domain.respuestas;

import java.time.LocalDateTime;

public record DatosVisualizarRespuestaInstructor(
                                                Long idTopico,
                                                String contenido,
                                                LocalDateTime fecha,
                                                Long idInstructor,
                                                String nombreInstructor,
                                                LocalDateTime miembroDesde
                                                ) {
    public DatosVisualizarRespuestaInstructor(Respuesta respuesta) {
        this(respuesta.getTopico().getId(), respuesta.getContenido(), respuesta.getFecha(), respuesta.getInstructor().getId(),
                respuesta.getInstructor().getNombre(), respuesta.getInstructor().getFecha());
    }
}

