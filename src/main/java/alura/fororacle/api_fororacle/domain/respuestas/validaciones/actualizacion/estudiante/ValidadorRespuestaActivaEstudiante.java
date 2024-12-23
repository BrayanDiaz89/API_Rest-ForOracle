package alura.fororacle.api_fororacle.domain.respuestas.validaciones.actualizacion.estudiante;

import alura.fororacle.api_fororacle.domain.respuestas.RespuestaRepository;
import alura.fororacle.api_fororacle.domain.respuestas.estudiante.DatosActualizarRespuestaEstudiante;
import alura.fororacle.api_fororacle.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorRespuestaActivaEstudiante implements ValidadoresActualizacionRespuestaEstudiante{

    @Autowired
    private RespuestaRepository respuestaRepository;

    public void validar(DatosActualizarRespuestaEstudiante datos){
        var respuestaActiva = respuestaRepository.findByActivoTrueAndIsIdRespuesta(datos.idRespuesta());
        if(!respuestaActiva){
            throw new ValidacionException("La respuesta ha sido eliminada, no puede ser actualizada.");
        }
    }
}
