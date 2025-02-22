package alura.fororacle.api_fororacle.domain.respuestas.validaciones.actualizacion.estudiante;

import alura.fororacle.api_fororacle.domain.respuestas.estudiante.DatosActualizarRespuestaEstudiante;
import alura.fororacle.api_fororacle.domain.respuestas.RespuestaRepository;
import alura.fororacle.api_fororacle.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorIdEstudianteAndIdRespuestaCoinciden implements ValidadoresActualizacionRespuestaEstudiante {

    @Autowired
    private RespuestaRepository respuestaRepository;

    public void validar(DatosActualizarRespuestaEstudiante datos){
        var datosCoinciden = respuestaRepository.findByCoincidenciaIdEstudianteAndIdRespuesta(datos.idEstudiante(), datos.idRespuesta(), datos.idTopico());
        if(!datosCoinciden){
            throw new ValidacionException("Los id no coinciden, validelos por favor.");
        }
    }
}
