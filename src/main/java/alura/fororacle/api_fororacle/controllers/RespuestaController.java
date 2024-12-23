package alura.fororacle.api_fororacle.controllers;

import alura.fororacle.api_fororacle.domain.respuestas.*;
import alura.fororacle.api_fororacle.domain.respuestas.estudiante.DatosActualizarRespuestaEstudiante;
import alura.fororacle.api_fororacle.domain.respuestas.estudiante.DatosListadoRespuestasEstudiantes;
import alura.fororacle.api_fororacle.domain.respuestas.estudiante.DatosVisualizarRespuestaEstudiante;
import alura.fororacle.api_fororacle.domain.respuestas.estudiante.RegistroDeRespuestasEstudiante;
import alura.fororacle.api_fororacle.domain.respuestas.instructor.DatosActualizarRespuestaInstructor;
import alura.fororacle.api_fororacle.domain.respuestas.instructor.DatosListadoRespuestasInstructores;
import alura.fororacle.api_fororacle.domain.respuestas.instructor.DatosVisualizarRespuestaInstructor;
import alura.fororacle.api_fororacle.domain.respuestas.instructor.RegistroDeRespuestasInstructor;
import alura.fororacle.api_fororacle.domain.topicos.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaRepository respuestaRepository;
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private RegistroDeRespuestasEstudiante registroRespuestaEstudiante;
    @Autowired
    private RegistroDeRespuestasInstructor registroRespuestaInstructor;

    @PostMapping("/estudiante")
    public ResponseEntity<DatosVisualizarRespuestaEstudiante> registrarRespuestaEstudiante(@RequestBody @Valid DatosRegistroRespuesta datosRegistroRespuesta){
        var detallesRespuestaEstudiante = registroRespuestaEstudiante.crearRespuestaEstudiante(datosRegistroRespuesta);
        return ResponseEntity.ok(detallesRespuestaEstudiante);
    }
    @PostMapping("/instructor")
    public ResponseEntity<DatosVisualizarRespuestaInstructor> registrarRespuestaInstructor(@RequestBody @Valid DatosRegistroRespuesta datosRegistroRespuesta){
        var detallesRespuestaInstructor = registroRespuestaInstructor.crearRespuestaInstructor(datosRegistroRespuesta);
        return ResponseEntity.ok(detallesRespuestaInstructor);
    }

    @GetMapping("/instructor")
    public ResponseEntity<Page<DatosListadoRespuestasInstructores>> listadoDeRespuestasInstructores(@PageableDefault Pageable paginacion){
        return ResponseEntity.ok((respuestaRepository.findByIdInstructorNotNullAndRespuestaActiva(paginacion).map(DatosListadoRespuestasInstructores::new)));
    }

    @GetMapping("/estudiante")
    public ResponseEntity<Page<DatosListadoRespuestasEstudiantes>> listadoDeRespuestasEstudiantes(@PageableDefault Pageable paginacion){
        return ResponseEntity.ok((respuestaRepository.findByIdEstudianteNotNullAndRespuestaActiva(paginacion).map(DatosListadoRespuestasEstudiantes::new)));
    }

    @PutMapping("/instructor")
    @Transactional
    public ResponseEntity<DatosVisualizarRespuestaInstructor> actualizarRespuestaInstructor(@RequestBody @Valid DatosActualizarRespuestaInstructor datosActualizarRespuesta){
        var detallesActualizarInstructor = registroRespuestaInstructor.actualizarRespuestaInstructor(datosActualizarRespuesta);
        return ResponseEntity.ok(detallesActualizarInstructor);
    }
    @PutMapping("/estudiante")
    @Transactional
    public ResponseEntity<DatosVisualizarRespuestaEstudiante> actualizarRespuestaEstudiante(@RequestBody @Valid DatosActualizarRespuestaEstudiante datosActualizarRespuesta){
        var detallesActualizarEstudiante = registroRespuestaEstudiante.actualizarRespuestaEstudiante(datosActualizarRespuesta);
        return ResponseEntity.ok(detallesActualizarEstudiante);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarRespuesta(@PathVariable Long id){
        Respuesta respuesta = respuestaRepository.getReferenceById(id);
        respuesta.eliminarRespuesta();
        return ResponseEntity.noContent().build();
    }

}
