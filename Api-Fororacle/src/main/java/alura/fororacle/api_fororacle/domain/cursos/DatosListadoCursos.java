package alura.fororacle.api_fororacle.domain.cursos;

public record DatosListadoCursos(
                    Long id,
                    String nombre,
                    String descripcion,
                    Boolean activo
        ) {
        public DatosListadoCursos(Curso curso){
                this(curso.getId(),curso.getNombre(), curso.getDescripcion(),curso.getActivo());
        }
}
