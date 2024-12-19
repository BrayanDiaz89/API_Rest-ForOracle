package alura.fororacle.api_fororacle.domain.estudiante;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistrarEstudiante(
                                    @NotNull
                                    Long idCurso,
                                    @NotBlank
                                    String nombre,
                                    @NotBlank
                                    @Email
                                    String email,
                                    @Future
                                    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                    LocalDateTime fecha,
                                    Boolean activo
                                    ) {
}
