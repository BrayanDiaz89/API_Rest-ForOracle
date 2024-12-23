package alura.fororacle.api_fororacle.domain.topicos;

import alura.fororacle.api_fororacle.domain.respuestas.DatosRespuesta;

import java.time.LocalDateTime;
import java.util.List;

public record DatosListadoTopicos(
                                Long id,
                                String titulo,
                                String descripcion,
                                LocalDateTime fecha,
                                Long idCurso,
                                String nombreDelCurso,
                                Long idEstudiante,
                                String nombreDelCreador,
                                Boolean no_resuelto,
                                List<DatosRespuesta> respuestas
) {
    public DatosListadoTopicos(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getDescripcion(), topico.getFecha(),
                topico.getCurso().getId(), topico.getCurso().getNombre(), topico.getEstudiante().getId(),
                topico.getEstudiante().getNombre(), topico.getNo_resuelto(),
                topico.getRespuestas().stream()
                        .map(DatosRespuesta::new)
                        .toList());
    }
}
