package alura.fororacle.api_fororacle.domain.cursos;

public record DatosRespuestaCurso(
        Long id,
        String nombre,
        String descripcion,
        boolean activo
) {
}
