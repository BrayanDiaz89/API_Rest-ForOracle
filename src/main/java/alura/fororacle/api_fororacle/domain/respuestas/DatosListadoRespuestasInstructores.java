package alura.fororacle.api_fororacle.domain.respuestas;

import alura.fororacle.api_fororacle.domain.instructor.Instructor;

import java.time.LocalDateTime;

public record DatosListadoRespuestasInstructores(
                                    Long idRespuesta,
                                    Long idTopico,
                                    String contenido,
                                    LocalDateTime fecha,
                                    Long idInstructor,
                                    String nombreInstructor,
                                    LocalDateTime miembroDesde
                                    ) {
    public DatosListadoRespuestasInstructores(Respuesta respuesta){
        this(respuesta.getId(), respuesta.getTopico().getId(), respuesta.getContenido(), respuesta.getFecha(), respuesta.getInstructor().getId(),
                respuesta.getInstructor().getNombre(),respuesta.getInstructor().getFecha());
    }

}
