package alura.fororacle.api_fororacle.domain.respuestas.validaciones.creacion.instructor;

import alura.fororacle.api_fororacle.domain.respuestas.DatosRegistroRespuesta;
import alura.fororacle.api_fororacle.domain.topicos.TopicoRepository;
import alura.fororacle.api_fororacle.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorTopicoNoEstaResueltoInstructor implements ValidadoresCreacionRespuestaInstructores {

    @Autowired
    private TopicoRepository topicoRepository;

    public void validar(DatosRegistroRespuesta datos){
        var topicoActivo = topicoRepository.findByActivoTrue(datos.idTopico());
        if(!topicoActivo){
            throw new ValidacionException("No es posible registrar su respuesta, porque el tópido que desea responder, ya ha sido resuelto.");
        }
    }

}
