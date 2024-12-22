package alura.fororacle.api_fororacle.domain.respuestas.validaciones.creacion.estudiante;

import alura.fororacle.api_fororacle.domain.estudiante.EstudianteRepository;
import alura.fororacle.api_fororacle.domain.respuestas.DatosRegistroRespuesta;
import alura.fororacle.api_fororacle.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorEstudianteNoExiste implements ValidadoresCreacionRespuestaEstudiante {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public void validar(DatosRegistroRespuesta datos) {

        var estudiante = estudianteRepository.findByActivoById(datos.idEstudiante());

        if(datos.idEstudiante() != null){
            if(estudiante == null || !estudiante){
                throw new ValidacionException("No es posible responder a este tópico, porque el estudiante no existe o su ID no se encuentra activo.");
            }
        }
    }
}
