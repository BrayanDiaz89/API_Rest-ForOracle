package alura.fororacle.api_fororacle.controllers;

import alura.fororacle.api_fororacle.domain.cursos.DatosListadoCursos;
import alura.fororacle.api_fororacle.domain.estudiante.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    EstudianteRepository estudianteRepository;

    @Autowired
    RegistroDeEstudiantes registroDeEstudiantes;

    @PostMapping
    public ResponseEntity<DatosRespuestaEstudiante> registrarEstudiante(@RequestBody @Valid DatosRegistrarEstudiante datosRegistrarEstudiante){
        var detalleRegistroEstudiante = registroDeEstudiantes.guardarEstudiante(datosRegistrarEstudiante);
        return ResponseEntity.ok(detalleRegistroEstudiante);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoEstudiantes>> listadoEstudiantesActivos(@PageableDefault(size=5) Pageable paginacion){
        return ResponseEntity.ok(estudianteRepository.findByActivoTrue(paginacion).map(DatosListadoEstudiantes::new));
    }

    @GetMapping("/inactivos")
    public ResponseEntity<Page<DatosListadoEstudiantes>> listadoEstudiantesInactivos(@PageableDefault(size=5) Pageable paginacion){
        return ResponseEntity.ok(estudianteRepository.findByActivoFalse(paginacion).map(DatosListadoEstudiantes::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaEstudiante> actualizarEstudiante(@RequestBody @Valid DatosActualizarEstudiante datosActualizarEstudiante){
        Estudiante estudiante = estudianteRepository.getReferenceById(datosActualizarEstudiante.id());
        estudiante.actualizarDatos(datosActualizarEstudiante);
        return ResponseEntity.ok(new DatosRespuestaEstudiante(estudiante.getId(), estudiante.getNombre(),
                estudiante.getEmail(), estudiante.getFecha(), estudiante.getActivo(), estudiante.getCurso().getId()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarEstudiante(@PathVariable Long id) {
        Estudiante estudiante = estudianteRepository.getReferenceById(id);
        estudiante.desactivarEstudiante();
        return ResponseEntity.noContent().build();
    }



}
