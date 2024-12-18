package alura.fororacle.api_fororacle.domain.estudiante;

import java.time.LocalDateTime;

public record DatosListadoEstudiantes(
                                    Long id,
                                    String nombre,
                                    String email,
                                    LocalDateTime fecha,
                                    Long idCurso,
                                    String nombreCurso
                                ) {
                public DatosListadoEstudiantes(Estudiante estudiante){
                    this(estudiante.getId(),estudiante.getNombre(),estudiante.getEmail(),estudiante.getFecha(),estudiante.getCurso().getId(),estudiante.getCurso().getNombre());
                }
}
