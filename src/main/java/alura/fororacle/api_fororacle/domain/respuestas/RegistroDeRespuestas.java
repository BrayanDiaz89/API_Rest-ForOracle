package alura.fororacle.api_fororacle.domain.respuestas;

import alura.fororacle.api_fororacle.domain.estudiante.EstudianteRepository;
import alura.fororacle.api_fororacle.domain.instructor.InstructorRepository;
import alura.fororacle.api_fororacle.domain.respuestas.validaciones.creacion.estudiante.ValidadoresCreacionRespuestaEstudiante;
import alura.fororacle.api_fororacle.domain.respuestas.validaciones.creacion.instructor.ValidadoresCreacionRespuestaInstructores;
import alura.fororacle.api_fororacle.domain.topicos.TopicoRepository;
import alura.fororacle.api_fororacle.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RegistroDeRespuestas {

    @Autowired
    private RespuestaRepository respuestaRepository;
    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private InstructorRepository instructorRepository;
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private List<ValidadoresCreacionRespuestaEstudiante> validadoresCreacionRespuestaEstudiantes;
    @Autowired
    private List<ValidadoresCreacionRespuestaInstructores> validadoresCreacionRespuestaInstructores;


    public DatosVisualizarRespuestaEstudiante crearRespuestaEstudiante(DatosRegistroRespuesta datos) {
        if(!topicoRepository.existsById(datos.idTopico())){
            throw new ValidacionException("No es posible registrar esta respuesta, porque no existe un tópico con el ID ingresado.");
        }
        var fecha = LocalDateTime.now();
        var topico = topicoRepository.findById(datos.idTopico()).get();
        //Validadores
        validadoresCreacionRespuestaEstudiantes.forEach(v-> v.validar(datos));

        var estudiante = estudianteRepository.findById(datos.idEstudiante()).get();
        var registroConEstudiante = new Respuesta(null, datos.contenido(), fecha, estudiante, null, topico);
        respuestaRepository.save(registroConEstudiante);

        return new DatosVisualizarRespuestaEstudiante(registroConEstudiante);
    }
    public DatosVisualizarRespuestaInstructor crearRespuestaInstructor(DatosRegistroRespuesta datos) {
        if(!topicoRepository.existsById(datos.idTopico())){
            throw new ValidacionException("No es posible registrar esta respuesta, porque no existe un tópico con el ID ingresado.");
        }
        var fecha = LocalDateTime.now();
        var topico = topicoRepository.findById(datos.idTopico()).get();
        //Validadores
        validadoresCreacionRespuestaInstructores.forEach(v-> v.validar(datos));

        var instructor = instructorRepository.findById(datos.idInstructor()).get();
        var registroConInstructor = new Respuesta(null, datos.contenido(), fecha, null, instructor, topico);
        respuestaRepository.save(registroConInstructor);

        return new DatosVisualizarRespuestaInstructor(registroConInstructor);
    }
}
