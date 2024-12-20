package alura.fororacle.api_fororacle.domain.topicos.validaciones.actualizacion;

import alura.fororacle.api_fororacle.domain.estudiante.EstudianteRepository;
import alura.fororacle.api_fororacle.domain.topicos.DatosActualizarTopico;
import alura.fororacle.api_fororacle.domain.topicos.TopicoRepository;
import alura.fororacle.api_fororacle.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorEstudianteCreoTopico implements ValidadorDeActualizacionTopicos{

    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private TopicoRepository topicoRepository;

    public void validar(DatosActualizarTopico datos) {
        var estudiante = estudianteRepository.getReferenceById(datos.idEstudiante()).getId();
        var topico = topicoRepository.getReferenceById(datos.idTopico()).getId();
        var estudianteCreoElTopico = topicoRepository.findByTopicoIfEstudianteCreoElTopico(topico, estudiante);
        if(!estudianteCreoElTopico){
            throw new ValidacionException("El topico no fue creado por el estudiante ingresado, no es posible, editar ningún valor.");
        }
    }


}
