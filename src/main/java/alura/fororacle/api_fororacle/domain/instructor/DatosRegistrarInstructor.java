package alura.fororacle.api_fororacle.domain.instructor;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.web.JsonPath;

import java.time.LocalDateTime;

public record DatosRegistrarInstructor(
                                        @NotNull
                                        Long idCurso,
                                        @NotBlank(message = "El nombre no debe estar vacío.")
                                        String nombre,
                                        @NotBlank
                                        @Email
                                        String email,
                                        @Future
                                        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                        LocalDateTime fecha
                                        ) {
}
