package alura.fororacle.api_fororacle.domain.respuestas;

import alura.fororacle.api_fororacle.domain.estudiante.EstudianteRepository;
import alura.fororacle.api_fororacle.domain.instructor.InstructorRepository;
import alura.fororacle.api_fororacle.domain.respuestas.validaciones.actualizacion.estudiante.ValidadoresActualizacionRespuestaEstudiante;
import alura.fororacle.api_fororacle.domain.respuestas.validaciones.actualizacion.instructor.ValidadoresActualizacionRespuestaInstructor;
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
    @Autowired
    private List<ValidadoresActualizacionRespuestaInstructor> validadoresActualizacionRespuestaInstructores;
    @Autowired
    private List<ValidadoresActualizacionRespuestaEstudiante> validadoresActualizacionRespuestaEstudiantes;


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

    public DatosVisualizarRespuestaInstructor actualizarRespuestaInstructor(DatosActualizarRespuestaInstructor datosActualizarRespuesta) {
        var respuestaExiste = respuestaRepository.existsById(datosActualizarRespuesta.idRespuesta());
        var instructorExite = instructorRepository.existsById(datosActualizarRespuesta.idInstructor());
        var topicoExiste = topicoRepository.existsById(datosActualizarRespuesta.idTopico());
        if(!respuestaExiste){
            throw new ValidacionException("No existe una respuesta, con el id suministrado.");
        }
        if(!instructorExite){
            throw new ValidacionException("No existe un instructor, con el id suministrado.");
        }
        if(!topicoExiste){
            throw new ValidacionException("No existe un topico, con el id suministrado.");
        }

        var instructorEstaActivo = instructorRepository.findByActivoById(datosActualizarRespuesta.idInstructor());
        if(!instructorEstaActivo){
            throw new ValidacionException("El instructor no se encuentra activo, y no puede modificar sus respuestas.");
        }
        //Validadores
        validadoresActualizacionRespuestaInstructores.forEach(v-> v.validar(datosActualizarRespuesta));

        var fecha = LocalDateTime.now();
        var instructor = instructorRepository.findById(datosActualizarRespuesta.idInstructor()).get();

        Respuesta respuesta = respuestaRepository.getReferenceById(datosActualizarRespuesta.idRespuesta());
        respuesta.actualizarDatosRespuestaInstructor(datosActualizarRespuesta);

        return new DatosVisualizarRespuestaInstructor(respuesta.getTopico().getId(), respuesta.getContenido(), fecha,
                respuesta.getInstructor().getId(), instructor.getNombre(), instructor.getFecha());
    }

    public DatosVisualizarRespuestaEstudiante actualizarRespuestaEstudiante(DatosActualizarRespuestaEstudiante datosActualizarRespuesta) {
        var respuestaExiste = respuestaRepository.existsById(datosActualizarRespuesta.idRespuesta());
        var estudianteExiste = estudianteRepository.existsById(datosActualizarRespuesta.idEstudiante());
        var topicoExiste = topicoRepository.existsById(datosActualizarRespuesta.idTopico());
        var estudianteEstaActivo = instructorRepository.findByActivoById(datosActualizarRespuesta.idEstudiante());
        if(!respuestaExiste){
            throw new ValidacionException("No existe una respuesta, con el id suministrado.");
        }
        if(!estudianteExiste){
            throw new ValidacionException("No existe un instructor, con el id suministrado.");
        }
        if(!topicoExiste){
            throw new ValidacionException("No existe un topico, con el id suministrado.");
        }
        if(!estudianteEstaActivo){
            throw new ValidacionException("El instructor no se encuentra activo, y no puede modificar sus respuestas.");
        }
        //Validadores
        validadoresActualizacionRespuestaEstudiantes.forEach(v-> v.validar(datosActualizarRespuesta));

        var fecha = LocalDateTime.now();
        var estudiante = estudianteRepository.findById(datosActualizarRespuesta.idEstudiante()).get();

        Respuesta respuesta = respuestaRepository.getReferenceById(datosActualizarRespuesta.idRespuesta());
        respuesta.actualizarDatosRespuestaEstudiante(datosActualizarRespuesta);

        return new DatosVisualizarRespuestaEstudiante(respuesta.getTopico().getId(), respuesta.getContenido(), fecha,
                estudiante.getId(), estudiante.getNombre(), estudiante.getFecha());
    }
}
