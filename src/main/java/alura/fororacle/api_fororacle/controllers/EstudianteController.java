package alura.fororacle.api_fororacle.controllers;

import alura.fororacle.api_fororacle.domain.estudiante.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    RegistroDeEstudiantes registroDeEstudiantes;

    @PostMapping
    public ResponseEntity<DatosRespuestaEstudiante> registrarEstudiante(@RequestBody @Valid DatosRegistrarEstudiante datosRegistrarEstudiante){
        var detalleRegistroEstudiante = registroDeEstudiantes.guardarEstudiante(datosRegistrarEstudiante);
        return ResponseEntity.ok(detalleRegistroEstudiante);
    }
}
