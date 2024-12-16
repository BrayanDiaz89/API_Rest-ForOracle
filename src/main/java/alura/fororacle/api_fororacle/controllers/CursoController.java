package alura.fororacle.api_fororacle.controllers;

import alura.fororacle.api_fororacle.domain.cursos.Curso;
import alura.fororacle.api_fororacle.domain.cursos.CursoRepository;
import alura.fororacle.api_fororacle.domain.cursos.DatosListadoCursos;
import alura.fororacle.api_fororacle.domain.cursos.DatosRegistrarCurso;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cursos")
//@SecurityRequirement(name = "bearer-key")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity<DatosListadoCursos> registrarCurso(@RequestBody @Valid DatosRegistrarCurso datosRegistrarCurso,
                                                             UriComponentsBuilder uriComponentsBuilder){
        //Guardar en tú base de datos el nuevo curso enviado en la request.
        Curso curso = cursoRepository.save(new Curso(datosRegistrarCurso));
        //Retornar 201 created, además de retornar el curso creado.
        DatosListadoCursos datosListadoCursos = new DatosListadoCursos(curso.getIdCurso(), curso.getNombre(), curso.getDescripcion());
        URI url = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getIdCurso()).toUri();
        return ResponseEntity.created(url).body(datosListadoCursos);
    }



}
