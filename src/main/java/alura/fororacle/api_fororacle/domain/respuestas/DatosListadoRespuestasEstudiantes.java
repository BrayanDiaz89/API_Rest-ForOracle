package alura.fororacle.api_fororacle.domain.respuestas;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public record DatosListadoRespuestasEstudiantes(
                                                Long idRespuesta,
                                                Long idTopico,
                                                String contenido,
                                                LocalDateTime fecha,
                                                Long idEstudiante,
                                                String nombreDeEstudiante,
                                                LocalDateTime miembroDesde
                                                ) {
    public DatosListadoRespuestasEstudiantes(Respuesta respuesta){
        this(respuesta.getId(), respuesta.getTopico().getId(), respuesta.getContenido(), respuesta.getFecha(), respuesta.getEstudiante().getId(),
                respuesta.getEstudiante().getNombre(), respuesta.getEstudiante().getFecha());
    }
}
