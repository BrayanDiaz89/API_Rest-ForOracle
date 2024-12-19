package alura.fororacle.api_fororacle.controllers;

import alura.fororacle.api_fororacle.domain.topicos.DatosRegistrarTopico;
import alura.fororacle.api_fororacle.domain.topicos.DatosRespuestaCreacionTopico;
import alura.fororacle.api_fororacle.domain.topicos.RegistroDeTopicos;
import alura.fororacle.api_fororacle.domain.topicos.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
}
