package alura.fororacle.api_fororacle.controllers;

import alura.fororacle.api_fororacle.domain.respuestas.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private RegistroDeRespuestas registro;

    @PostMapping("/estudiante")
    public ResponseEntity<DatosVisualizarRespuestaEstudiante> registrarRespuestaEstudiante(@RequestBody @Valid DatosRegistroRespuesta datosRegistroRespuesta){
        var detallesRespuestaEstudiante = registro.crearRespuestaEstudiante(datosRegistroRespuesta);
        return ResponseEntity.ok(detallesRespuestaEstudiante);
    }
    @PostMapping("/instructor")
    public ResponseEntity<DatosVisualizarRespuestaInstructor> registrarRespuestaInstructor(@RequestBody @Valid DatosRegistroRespuesta datosRegistroRespuesta){
        var detallesRespuestaInstructor = registro.crearRespuestaInstructor(datosRegistroRespuesta);
        return ResponseEntity.ok(detallesRespuestaInstructor);
    }

}
