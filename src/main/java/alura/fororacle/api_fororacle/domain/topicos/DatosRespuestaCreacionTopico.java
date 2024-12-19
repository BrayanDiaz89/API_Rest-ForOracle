package alura.fororacle.api_fororacle.domain.topicos;

public record DatosRespuestaCreacionTopico(
                                        Long id,
                                        String titulo,
                                        String descripcion,
                                        Long idCreador,
                                        String nombreDelCreador,
                                        Boolean no_resuelto
) {
    public DatosRespuestaCreacionTopico(Topico topico) {
        this(topico.getId(),topico.getTitulo(),topico.getDescripcion(),topico.getEstudiante().getId(), topico.getEstudiante().getNombre(), topico.getNo_resuelto());
    }
}
