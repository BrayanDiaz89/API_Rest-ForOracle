package alura.fororacle.api_fororacle.domain.topicos;

import java.time.LocalDateTime;

public record DatosListadoTopicos(
                                Long id,
                                String titulo,
                                String descripcion,
                                LocalDateTime fecha,
                                Long idCurso,
                                String nombreDelCurso,
                                Long idEstudiante,
                                String nombreDelCreador,
                                Boolean no_resuelto
) {
    public DatosListadoTopicos(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getDescripcion(), topico.getFecha(),
                topico.getCurso().getId(), topico.getCurso().getNombre(), topico.getEstudiante().getId(),
                topico.getEstudiante().getNombre(), topico.getNo_resuelto());
    }
}
