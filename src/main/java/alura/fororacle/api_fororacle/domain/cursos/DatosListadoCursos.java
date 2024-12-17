package alura.fororacle.api_fororacle.domain.cursos;

public record DatosListadoCursos(
                    Long id,
                    String nombre,
                    String descripcion,
                    boolean activo
        ) {
        public DatosListadoCursos(Curso curso){
                this(curso.getId(),curso.getNombre(), curso.getDescripcion(),curso.isActivo());
        }
}
