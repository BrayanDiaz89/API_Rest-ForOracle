package alura.fororacle.api_fororacle.domain.topicos.validaciones.creacion;

import alura.fororacle.api_fororacle.domain.cursos.CursoRepository;
import alura.fororacle.api_fororacle.domain.topicos.DatosRegistrarTopico;
import alura.fororacle.api_fororacle.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorCursoActivo implements ValidadorDeTopicos{

    @Autowired
    private CursoRepository repository;

    public void validar(DatosRegistrarTopico datos) {

        var cursoEstaActivo = repository.findByActivoById(datos.idCurso());
        if (!cursoEstaActivo){
            throw new ValidacionException("El curso no está activo, por lo tanto no es posible crear el tópico.");
        }
    }
}
