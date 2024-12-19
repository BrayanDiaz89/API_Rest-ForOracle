package alura.fororacle.api_fororacle.domain.topicos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistrarTopico(
                            @NotNull
                            Long idCurso,
                            @NotNull
                            Long idEstudiante,
                            @NotBlank
                            String titulo,
                            @NotBlank
                            String descripcion,
                            @Future
                            @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                            LocalDateTime fecha,
                            Boolean no_resuelto
                            ) {

}
