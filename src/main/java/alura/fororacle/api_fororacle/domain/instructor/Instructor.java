package alura.fororacle.api_fororacle.domain.instructor;

import alura.fororacle.api_fororacle.domain.cursos.Curso;
import jakarta.persistence.*;
import jakarta.validation.Valid;
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
    private Boolean activo;

    //Creación de relación uno a muchos con Cursos, campo id_curso
    //Un instructor pertenece a almenos un curso
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_curso")
    private Curso curso;

    //constructor para registrar instructor, teniendo en cuenta la relación con cursos
    public Instructor(Long id, Curso curso, String nombre, String email, LocalDateTime fecha, Boolean activo){
        this.id = id;
        this.curso = curso;
        this.nombre = nombre;
        this.email = email;
        this.fecha = fecha;
        this.activo = activo;
    }

    public void desactivarInstructor() { this.activo = false; }

    public void actualizarDatos(DatosActualizarInstructor datosActualizarInstructor) {
        if(datosActualizarInstructor.nombre() != null){
            this.nombre = datosActualizarInstructor.nombre();
        }
        if(datosActualizarInstructor.email() != null){
            this.email = datosActualizarInstructor.email();
        }
        if(datosActualizarInstructor.activo() != null){
            this.activo = datosActualizarInstructor.activo();
        }
    }
}
