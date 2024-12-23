package alura.fororacle.api_fororacle.domain.topicos;

import java.time.LocalDateTime;

public record DatosRespuestaTopicoSinRespuestas(Long id,
                                                String titulo,
                                                String descripcion,
                                                LocalDateTime fecha,
                                                Long idEstudiante,
                                                Long idCurso,
                                                Boolean no_resuelto) {
    public DatosRespuestaTopicoSinRespuestas(Topico topico){
        this(topico.getId(),topico.getTitulo(),topico.getDescripcion(), topico.getFecha(),
                topico.getEstudiante().getId(),topico.getCurso().getId(),topico.getNo_resuelto());
    }
}
