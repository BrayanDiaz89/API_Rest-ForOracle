package alura.fororacle.api_fororacle.domain.respuestas.instructor;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosActualizarRespuestaInstructor(
                                        @NotNull
                                        Long idTopico,
                                        @NotNull
                                        Long idRespuesta,
                                        @NotNull
                                        Long idInstructor,
                                        @NotBlank
                                        String contenido,
                                        @Future
                                        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                        LocalDateTime fecha
                                        ) {
}
