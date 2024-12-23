package alura.fororacle.api_fororacle.domain.respuestas.estudiante;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosActualizarRespuestaEstudiante(
                                                 @NotNull
                                                 Long idTopico,
                                                 @NotNull
                                                 Long idRespuesta,
                                                 @NotNull
                                                 Long idEstudiante,
                                                 @NotBlank
                                                 String contenido,
                                                 @Future
                                                 @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                                 LocalDateTime fecha
                                                 ) {
}

