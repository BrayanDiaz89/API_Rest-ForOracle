package alura.fororacle.api_fororacle.domain.respuestas.validaciones.creacion.instructor;

import alura.fororacle.api_fororacle.domain.estudiante.EstudianteRepository;
import alura.fororacle.api_fororacle.domain.instructor.InstructorRepository;
import alura.fororacle.api_fororacle.domain.respuestas.DatosRegistroRespuesta;
import alura.fororacle.api_fororacle.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorInstructorNoExiste implements ValidadoresCreacionRespuestaInstructores{
    @Autowired
    private InstructorRepository instructorRepository;

    public void validar(DatosRegistroRespuesta datos) {

        var instructor = instructorRepository.findByActivoById(datos.idInstructor());

        if(datos.idInstructor() != null){
            if(instructor == null || !instructor){
                throw new ValidacionException("No es posible responder a este tópico, porque el instructor no existe o su ID no se encuentra activo.");
            }
        }
    }
}
