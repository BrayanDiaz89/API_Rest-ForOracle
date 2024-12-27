package alura.fororacle.api_fororacle.controllers;

import alura.fororacle.api_fororacle.domain.instructor.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instructores")
@SecurityRequirement(name = "bearer-key")
public class InstructorController {

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    RegistroDeInstructores registro;

    @PostMapping
    public ResponseEntity<DatosRespuestaInstructor> registrarInstructor(@RequestBody @Valid DatosRegistrarInstructor datosRegistro){
        var detalleRegistroInstructor = registro.guardarInstructor(datosRegistro);
        return ResponseEntity.ok(detalleRegistroInstructor);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoInstructores>> listadoDeInstructoresActivos(@PageableDefault(size = 5) Pageable paginacion){
        return ResponseEntity.ok(instructorRepository.findByActivoTrue(paginacion).map(DatosListadoInstructores::new));
    }
    @GetMapping("/inactivos")
    public ResponseEntity<Page<DatosListadoInstructores>> listadoDeInstructoresInactivos(@PageableDefault(size = 5) Pageable paginacion){
        return ResponseEntity.ok(instructorRepository.findByActivoFalse(paginacion).map(DatosListadoInstructores::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaInstructor> actualizarDatosInstructor(@RequestBody @Valid DatosActualizarInstructor datosActualizarInstructor){
        Instructor instructor = instructorRepository.getReferenceById(datosActualizarInstructor.id());
        instructor.actualizarDatos(datosActualizarInstructor);
        return ResponseEntity.ok(new DatosRespuestaInstructor(instructor.getId(),instructor.getNombre(),
                instructor.getEmail(),instructor.getFecha(),instructor.getActivo(),instructor.getCurso().getId()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarInstructor(@PathVariable Long id){
        Instructor instructor = instructorRepository.getReferenceById(id);

        instructor.desactivarInstructor();
        return ResponseEntity.noContent().build();
    }

}
