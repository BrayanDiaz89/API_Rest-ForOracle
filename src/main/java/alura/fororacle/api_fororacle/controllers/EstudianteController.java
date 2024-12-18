package alura.fororacle.api_fororacle.controllers;

import alura.fororacle.api_fororacle.domain.cursos.DatosListadoCursos;
import alura.fororacle.api_fororacle.domain.estudiante.*;
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

}
