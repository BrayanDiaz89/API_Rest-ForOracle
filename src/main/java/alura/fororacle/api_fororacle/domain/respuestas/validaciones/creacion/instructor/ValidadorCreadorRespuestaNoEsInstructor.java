package alura.fororacle.api_fororacle.domain.respuestas.validaciones.creacion.instructor;

import alura.fororacle.api_fororacle.domain.respuestas.DatosRegistroRespuesta;
import alura.fororacle.api_fororacle.infra.errores.ValidacionException;
import org.springframework.stereotype.Component;

@Component
public class ValidadorCreadorRespuestaNoEsInstructor implements ValidadoresCreacionRespuestaInstructores {

    public void validar(DatosRegistroRespuesta datos){
        var idEstudiante = datos.idEstudiante();
        var idInstructor = datos.idInstructor();

        if(idEstudiante == null && idInstructor == null){
            throw new ValidacionException("Debe haber ID de estudiante o ID de instructor de la respuesta.");
        }
        if(idEstudiante != null && idInstructor != null){
            throw new ValidacionException("Solo puede haber un creador de la respuesta, estudiante o alumno. No son permitidos los dos ID, en la misma respuesta.");
        }
        if(idEstudiante != null){
            throw new ValidacionException("Es el apartado de respuestas para instructores, un estudiante no puede responder desde este apartado, ingrese a /estudiante.");
        }
    }
}
