package alura.fororacle.api_fororacle.domain.cursos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarCurso(
                                   @NotNull
                                   Long id,
                                   String nombre,
                                   String descripcion,
                                   Boolean activo) {
}
