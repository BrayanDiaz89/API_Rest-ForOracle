package alura.fororacle.api_fororacle.domain.respuestas;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroRespuesta(
                                    Long idEstudiante,
                                    Long idInstructor,
                                    @NotBlank
                                    String contenido,
                                    @Future
                                    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                    LocalDateTime fecha,
                                    @NotNull
                                    Long idTopico
                                    ) {
}
