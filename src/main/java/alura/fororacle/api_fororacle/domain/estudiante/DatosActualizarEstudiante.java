package alura.fororacle.api_fororacle.domain.estudiante;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarEstudiante(
                                        @NotNull
                                        Long id,
                                        String nombre,
                                        String email,
                                        boolean activo) {
}
