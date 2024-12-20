package alura.fororacle.api_fororacle.domain.topicos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosActualizarTopico(
                                @NotNull
                                Long idTopico,
                                @NotNull
                                Long idEstudiante,
                                String titulo,
                                String descripcion,
                                @Future
                                @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                LocalDateTime fecha,
                                Boolean no_resuelto
                                    ) {
}
