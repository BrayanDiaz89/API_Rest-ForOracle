package alura.fororacle.api_fororacle.controllers;

import alura.fororacle.api_fororacle.domain.topicos.*;
import jakarta.validation.Valid;
import org.hibernate.engine.jdbc.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private RegistroDeTopicos registro;

    @PostMapping
    public ResponseEntity<DatosRespuestaCreacionTopico> registrarUnTopico(@RequestBody @Valid DatosRegistrarTopico datosRegistrarTopico){
        var detalleRegistroTopico = registro.crearTopico(datosRegistrarTopico);
        return ResponseEntity.ok(detalleRegistroTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopicos>> listadoDeTopicosSinResolver(@PageableDefault(size = 5) Pageable paginacion) {
       return ResponseEntity.ok(repository.findByNoResueltoTrue(paginacion).map(DatosListadoTopicos::new));
    }

    @GetMapping("/resueltos")
    public ResponseEntity<Page<DatosListadoTopicos>> listadoDeTopicosResueltos(@PageableDefault(size = 5) Pageable paginacion) {
        return ResponseEntity.ok(repository.findByNoResueltoFalse(paginacion).map(DatosListadoTopicos::new));
    }

}
