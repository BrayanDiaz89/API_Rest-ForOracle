package alura.fororacle.api_fororacle.domain.instructor;

import alura.fororacle.api_fororacle.domain.cursos.CursoRepository;
import alura.fororacle.api_fororacle.domain.estudiante.DatosRegistrarEstudiante;
import alura.fororacle.api_fororacle.domain.estudiante.DatosRespuestaEstudiante;
import alura.fororacle.api_fororacle.domain.estudiante.Estudiante;
import alura.fororacle.api_fororacle.infra.errores.ValidacionException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegistroDeInstructores {

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    CursoRepository cursoRepository;

    public DatosRespuestaInstructor guardarInstructor(DatosRegistrarInstructor datosRegistro) {
        if(!cursoRepository.existsById(datosRegistro.idCurso())){
            throw new ValidacionException("No existe un curso, con el id informado.");
        }
        var fecha = LocalDateTime.now();
        var curso = cursoRepository.findById(datosRegistro.idCurso()).get();
        var registro = new Instructor(null, curso, datosRegistro.nombre(), datosRegistro.email(), fecha);

        instructorRepository.save(registro);
        return new DatosRespuestaInstructor(registro);
    }
}
