package alura.fororacle.api_fororacle.domain.estudiante;

import alura.fororacle.api_fororacle.domain.cursos.Curso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name="estudiantes")
@Entity(name="Estudiante")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id_estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estudiante;
    private String nombreEstudiante;
    private String email;
    private LocalDateTime fechaRegistro;

    //Creación de relación uno a muchos con Cursos, campo id_curso
    //Un estudiante pertenecen a almenos un curso
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_curso")
    private Curso curso;

}
