package alura.fororacle.api_fororacle.domain.instructor;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarInstructor(@NotNull
                                        Long id,
                                        String nombre,
                                        String email,
                                        Boolean activo) {
}
