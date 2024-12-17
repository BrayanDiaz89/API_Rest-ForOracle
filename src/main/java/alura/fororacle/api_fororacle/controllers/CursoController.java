package alura.fororacle.api_fororacle.controllers;

import alura.fororacle.api_fororacle.domain.cursos.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cursos")
//@SecurityRequirement(name = "bearer-key")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaCurso> registrarCurso(@RequestBody @Valid DatosRegistrarCurso datosRegistrarCurso,
                                                             UriComponentsBuilder uriComponentsBuilder){
        //Guardar en tú base de datos el nuevo curso enviado en la request.
        Curso curso = cursoRepository.save(new Curso(datosRegistrarCurso));
        //Retornar 201 created, además de retornar el curso creado.
        DatosRespuestaCurso datosRespuestaCurso = new DatosRespuestaCurso(curso.getId(), curso.getNombre(), curso.getDescripcion(),curso.isActivo());
        URI url = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaCurso);
    }

    //Ver cursos activos
    @GetMapping
    public ResponseEntity<Page<DatosListadoCursos>> listadoDeCursos(@PageableDefault(size=5) Pageable paginacion) {
        return ResponseEntity.ok(cursoRepository.findByActivoTrue(paginacion).map(DatosListadoCursos::new));
    }

    //Ver cursos inactivos
    @GetMapping("/inactivos")
    public ResponseEntity<Page<DatosListadoCursos>> listadoCursosInactivos(@PageableDefault(size=5) Pageable paginacion) {
        return ResponseEntity.ok(cursoRepository.findByActivoFalse(paginacion).map(DatosListadoCursos::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaCurso> actualizarCurso(@RequestBody @Valid DatosActualizarCurso datosActualizarCurso){
        Curso curso = cursoRepository.getReferenceById(datosActualizarCurso.id());
        curso.actualizarDatos(datosActualizarCurso);
        return ResponseEntity.ok(new DatosRespuestaCurso(curso.getId(),curso.getNombre(),curso.getDescripcion(), curso.isActivo()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarCurso(@PathVariable Long id){
        Curso curso = cursoRepository.getReferenceById(id);
        curso.desactivarCurso();
        return ResponseEntity.noContent().build();
    }


}
