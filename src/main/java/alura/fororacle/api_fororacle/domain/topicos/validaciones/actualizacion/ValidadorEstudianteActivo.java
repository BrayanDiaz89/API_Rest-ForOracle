package alura.fororacle.api_fororacle.domain.topicos.validaciones.actualizacion;

import alura.fororacle.api_fororacle.domain.estudiante.EstudianteRepository;
import alura.fororacle.api_fororacle.domain.topicos.DatosActualizarTopico;
import alura.fororacle.api_fororacle.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorEstudianteActivo implements ValidadorDeActualizacionTopicos{

    @Autowired
    private EstudianteRepository estudianteRepository;

    public void validar(DatosActualizarTopico datos) {
        var estudianteActivo = estudianteRepository.findByActivoById(datos.idEstudiante());
        if(!estudianteActivo) {
            throw new ValidacionException("El estudiante no se encuentra activo, no puede actualizar su tópico.");
        }
    }
}
