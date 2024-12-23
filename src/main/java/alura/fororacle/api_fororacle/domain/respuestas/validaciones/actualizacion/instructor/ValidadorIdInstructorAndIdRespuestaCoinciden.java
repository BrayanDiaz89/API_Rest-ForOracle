package alura.fororacle.api_fororacle.domain.respuestas.validaciones.actualizacion.instructor;

import alura.fororacle.api_fororacle.domain.respuestas.instructor.DatosActualizarRespuestaInstructor;
import alura.fororacle.api_fororacle.domain.respuestas.RespuestaRepository;
import alura.fororacle.api_fororacle.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorIdInstructorAndIdRespuestaCoinciden implements ValidadoresActualizacionRespuestaInstructor{

    @Autowired
    private RespuestaRepository respuestaRepository;

    public void validar(DatosActualizarRespuestaInstructor datos){
        var datosCoinciden = respuestaRepository.findByCoincidenciaIdInstructorAndIdRespuesta(datos.idInstructor(), datos.idRespuesta(), datos.idTopico());
        if(!datosCoinciden){
            throw new ValidacionException("Los Id no coinciden, validelos por favor.");
        }
    }
}
