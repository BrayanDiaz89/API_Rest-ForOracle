package alura.fororacle.api_fororacle.domain.estudiante;

import alura.fororacle.api_fororacle.domain.cursos.CursoRepository;
import alura.fororacle.api_fororacle.infra.errores.ValidacionException;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegistroDeEstudiantes {

    @Autowired
    EstudianteRepository estudianteRepository;

    @Autowired
    CursoRepository cursoRepository;

    public DatosRespuestaEstudiante guardarEstudiante(DatosRegistrarEstudiante datos) {
        if(!cursoRepository.existsById(datos.idCurso())){
            throw new ValidacionException("No existe un curso, con el id informado.");
        }
        var fecha = LocalDateTime.now();
        var curso = cursoRepository.findById(datos.idCurso()).get();
        var registro = new Estudiante(null, curso, datos.nombre(), datos.email(), fecha, null);

        estudianteRepository.save(registro);
        return new DatosRespuestaEstudiante(registro);
    }

}
