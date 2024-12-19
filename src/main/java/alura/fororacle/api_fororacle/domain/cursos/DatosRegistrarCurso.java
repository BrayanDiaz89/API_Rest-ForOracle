package alura.fororacle.api_fororacle.domain.cursos;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistrarCurso(
                    @NotBlank(message = "El nombre no puede estar vacío.")
                    String nombre,
                    @NotBlank(message = "Debe dar una descripción del curso.")
                    String descripcion,
                    Boolean activo
            ) {
}
