package alura.fororacle.api_fororacle.domain.topicos;

import alura.fororacle.api_fororacle.domain.respuestas.DatosRespuesta;

import java.time.LocalDateTime;
import java.util.List;

public record DatosRespuestaTopico(Long id,
                                   String titulo,
                                   String descripcion,
                                   LocalDateTime fecha,
                                   Long idEstudiante,
                                   Long idCurso,
                                   Boolean no_resuelto,
                                   List<DatosRespuesta> respuestas
                                ) {
    public DatosRespuestaTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getDescripcion(), topico.getFecha(), topico.getEstudiante().getId(),
                topico.getCurso().getId(),topico.getNo_resuelto(),
                topico.getRespuestas().stream()
                        .map(DatosRespuesta::new)
                        .toList());
    }
}
