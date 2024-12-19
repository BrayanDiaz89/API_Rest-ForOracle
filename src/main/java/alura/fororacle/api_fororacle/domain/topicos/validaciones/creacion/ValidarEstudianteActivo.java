package alura.fororacle.api_fororacle.domain.topicos.validaciones.creacion;

import alura.fororacle.api_fororacle.domain.estudiante.EstudianteRepository;
import alura.fororacle.api_fororacle.domain.topicos.DatosRegistrarTopico;
import alura.fororacle.api_fororacle.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarEstudianteActivo implements ValidadorDeTopicos{

    @Autowired
    private EstudianteRepository repository;

    public void validar(DatosRegistrarTopico datos) {

        var estudianteEstaActivo = repository.findByActivoById(datos.idEstudiante());
        if(!estudianteEstaActivo){
            throw new ValidacionException("El estudiante no está activo, por lo tanto no es posible crear el tópico.");
        }
    }
}
