package alura.fororacle.api_fororacle.domain.topicos.validaciones.actualizacion;

import alura.fororacle.api_fororacle.domain.topicos.DatosActualizarTopico;
import alura.fororacle.api_fororacle.domain.topicos.TopicoRepository;
import alura.fororacle.api_fororacle.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorTopicoActivo implements ValidadorDeActualizacionTopicos{

    @Autowired
    private TopicoRepository topicoRepository;

    public void validar(DatosActualizarTopico datos) {
        var topicoActivo = topicoRepository.findByActivoTrue(datos.idTopico());
        if(!topicoActivo) {
            throw new ValidacionException("El tópico ingresado ya ha sido solucionado, por lo que no está activo para actualizarse.");
        }
    }
}
