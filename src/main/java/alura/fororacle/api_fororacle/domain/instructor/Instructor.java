package alura.fororacle.api_fororacle.domain.instructor;

import alura.fororacle.api_fororacle.domain.cursos.Curso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "instructores")
@Entity(name = "Instructor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private LocalDateTime fecha;
    private boolean activo;

    //Creación de relación uno a muchos con Cursos, campo id_curso
    //Un instructor pertenece a almenos un curso
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_curso")
    private Curso curso;

    public void desactivarInstructor() { this.activo = false; }

}
